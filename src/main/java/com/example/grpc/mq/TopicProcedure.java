package com.example.grpc.mq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.File;
import java.io.FileInputStream;

@Service
@NoArgsConstructor
public class TopicProcedure implements Runnable{
    private String name;
    private String cusTopic;
    private String message;
    private byte[] file; // To hold the file to be sent

    public TopicProcedure(String name, String cusTopic, String message, byte[] file) {
        this.name = name;
        this.cusTopic = cusTopic;
        this.message = message;
        this.file = file;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getFile() {
        return file;
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
            //DeliveryMode.NON_PERSISTENT
            //DeliveryMode.PERSISTENT

            // Create the destination as Topic (Changed from Queue)
            Topic topic = session.createTopic(cusTopic);

            // Create a MessageProducer from the Session to the Topic
            MessageProducer producer = session.createProducer(topic);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            if (file != null) {

                TextMessage textMessage = session.createTextMessage(message);
                producer.send(textMessage);
                // If a file is provided, send it as a BytesMessage
                BytesMessage bytesMessage = session.createBytesMessage();
                bytesMessage.writeBytes(file);
                producer.send(bytesMessage); // Send the file as a BytesMessage
                file = null;
            } else {
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
