package com.example.grpc.mq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@NoArgsConstructor
public class TopicConsumer implements Runnable, ExceptionListener{
    private String name;
    private String cusTopic ;
    private String fileName ;

    public TopicConsumer(String name, String cusTopic) {
        this.name = name;
        this.cusTopic = cusTopic;
    }

    public TopicConsumer(String name, String cusTopic, String fileName) {
        this.name = name;
        this.cusTopic = cusTopic;
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCusTopic() {
        return cusTopic;
    }

    public void setCusTopic(String cusTopic) {
        this.cusTopic = cusTopic;
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
            connection.setClientID(name);
            connection.start();
            connection.setExceptionListener(this);

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Destination changed to Topic
            Topic topic = session.createTopic(cusTopic);

            // Create a MessageConsumer from the Session to the Topic
            // 기존 코드
            // MessageConsumer consumer = session.createConsumer(topic);

            // 수정된 코드
            MessageConsumer consumer = session.createDurableSubscriber(topic, "subscription-" + name);

            // Continuously listen for new messages
            while (true) {
                Message message = consumer.receive(); // Wait indefinitely for a new message
                if (message instanceof TextMessage) {
                    if(((TextMessage) message).getText().contains("첨부파일:!!@@")){
                        fileName = String.valueOf(((TextMessage) message).getText());
                        fileName = fileName.substring(fileName.lastIndexOf("@") + 1);
                    }else {
                        // Handle text message
                        TextMessage textMessage = (TextMessage) message;
                        String text = textMessage.getText();
                        System.out.println(text);
                    }
                } else if (message instanceof BytesMessage) {

                    // Handle file (BytesMessage)
                    BytesMessage bytesMessage = (BytesMessage) message;
                    byte[] fileBytes = new byte[(int) bytesMessage.getBodyLength()];
                    bytesMessage.readBytes(fileBytes);
                    File outputFile = new File("C:\\Users\\HCNC\\Desktop\\download","HCNC 받은파일 " + System.currentTimeMillis() + fileName);
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        fos.write(fileBytes);
                        System.out.println("파일전송 및 저장 : " + outputFile.getAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Error saving received file: " + e);
                    }
                    fileName = "";
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
