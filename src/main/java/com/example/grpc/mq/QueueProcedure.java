package com.example.grpc.mq;


import lombok.NoArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class QueueProcedure implements Runnable{
    private String name;
    private String message;
    private String receivedId;
    private HashMap<String, Object> mapData;
    private byte[] file; // To hold the file to be sent

    public QueueProcedure(String name, String message, String receivedId, HashMap<String, Object> mapData, byte[] file) {
        this.name = name;
        this.message = message;
        this.receivedId = receivedId;
        this.mapData = mapData;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getReceivedId() {
        return receivedId;
    }

    public HashMap<String, Object> getMapData() {
        return mapData;
    }

    public byte[] getFile() {
        return file;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReceivedId(String receivedId) {
        this.receivedId = receivedId;
    }

    public void setMapData(HashMap<String, Object> mapData) {
        this.mapData = mapData;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {

            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination
            Destination destination = session.createQueue(receivedId);

            // Create a MessageProducer from the Session to the Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            if (file != null) {
                TextMessage textMessage = session.createTextMessage(message);
                producer.send(textMessage);
                // If a file is provided, send it as a BytesMessage
                BytesMessage bytesMessage = session.createBytesMessage();
                bytesMessage.writeBytes(file);
                producer.send(bytesMessage); // Send the file as a BytesMessage
                file = null;
            } else if(mapData != null){
                // If a message is provided, send a MapMessage
                MapMessage mapMessage = session.createMapMessage();
                for (Map.Entry<String, Object> entry : mapData.entrySet()) {
                    if (entry.getValue() instanceof String) {
                        mapMessage.setString(entry.getKey(), (String) entry.getValue()); // Add key-value pairs
                    } else if (entry.getValue() instanceof Integer) {
                        mapMessage.setInt(entry.getKey(), Integer.parseInt(entry.getKey()));
                    } else if (entry.getValue() instanceof Character) {
                        mapMessage.setChar(entry.getKey(), (Character) entry.getValue());
                    }
                }
                // Send the MapMessage
                producer.send(mapMessage); // Send the MapMessage
            }else {
                // If no file, send a regular TextMessage
                TextMessage textMessage = session.createTextMessage(message);
                producer.send(textMessage); // Send the text message
            }

            // Clean up
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
