package com.example.grpc.mq;

import lombok.NoArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

@Service
@NoArgsConstructor
public class QueueConsumer implements Runnable, ExceptionListener{
    private String name;
    private String fileName;

    public QueueConsumer(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public QueueConsumer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://172.168.10.71:61616");

            Connection connection = connectionFactory.createConnection();
            connection.start();
            connection.setExceptionListener(this);

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Destination
            Destination destination = session.createQueue(name);

            // Create a MessageConsumer from the Session to the Queue
            MessageConsumer consumer = session.createConsumer(destination);

            // Continuously listen for new messages
            while (true) {
                Message message = consumer.receive(); // Wait indefinitely for a new message
                if (message instanceof TextMessage) {
                    if(((TextMessage) message).getText().contains("첨부파일:!!@@")){
                    fileName = String.valueOf(((TextMessage) message).getText());
                    fileName = fileName.substring(fileName.lastIndexOf("@") + 1);
                }else {
                        // ANSI escape codes for colors
                        String red = "\u001B[31m";  // 빨간색
                        String reset = "\u001B[0m";  // 색상 초기화
                        //System.out.println("This is a normal text.");
                        //System.out.println(red + "This text is red!" + reset);
                    // Handle text message
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println(red + text + reset);
                }} else if (message instanceof BytesMessage) {
                    // 폴더 경로 지정
                    String folderPath = "C:\\download";

                    // File 객체 생성
                    File folder = new File(folderPath);

                    if (!folder.exists()) {
                        folder.mkdir();
                    }


                    // Handle file (BytesMessage)
                    BytesMessage bytesMessage = (BytesMessage) message;
                    byte[] fileBytes = new byte[(int) bytesMessage.getBodyLength()];
                    bytesMessage.readBytes(fileBytes);
                    File outputFile = new File("C:\\download","HCNC 받은파일 " + System.currentTimeMillis() + fileName);
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        fos.write(fileBytes);
                        // ANSI escape codes for colors
                        String red = "\u001B[31m";  // 빨간색
                        String reset = "\u001B[0m";  // 색상 초기화
                        //System.out.println("This is a normal text.");
                        //System.out.println(red + "This text is red!" + reset);
                        System.out.println(red + "파일전송 및 저장 : " + outputFile.getAbsolutePath() + reset);
                    } catch (IOException e) {
                        System.out.println("Error saving received file: " + e);
                    }
                    fileName = "";


                } else if (message instanceof MapMessage) {
                    // Handle MapMessage
                    MapMessage mapMessage = (MapMessage) message;
                    HashMap<String, Object> mapData = new HashMap<>();

                    // Extract data from the MapMessage and store it in the HashMap
                    for (Enumeration<?> e = mapMessage.getMapNames(); e.hasMoreElements(); ) {
                        String key = (String) e.nextElement();
                        Object value = null;

                        // Depending on the type of value, get the corresponding value from the MapMessage
                        try {
                            if (mapMessage.itemExists(key)) {
                                if (mapMessage.getObject(key) instanceof String) {
                                    value = mapMessage.getString(key);
                                } else if (mapMessage.getObject(key) instanceof Integer) {
                                    value = mapMessage.getInt(key);
                                } else if (mapMessage.getObject(key) instanceof Boolean) {
                                    value = mapMessage.getBoolean(key);
                                } else if (mapMessage.getObject(key) instanceof Double) {
                                    value = mapMessage.getDouble(key);
                                } else {
                                    value = mapMessage.getObject(key); // For other types
                                }
                                mapData.put(key, value); // Add the key-value pair to the map

                            }
                        } catch (JMSException e1) {
                            e1.printStackTrace();
                        }
                    }
                    System.out.println(mapData);
                } else {
                    System.out.println(name + " received an unexpected message type.");
                }
            }
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured. Shutting down client.");
    }
}
