package com.example.grpc;


import com.example.grpc.chat.ChatMessage;
import com.example.grpc.chat.ChatServiceGrpc;
import com.example.grpc.mq.QueueConsumer;
import com.example.grpc.mq.TopicConsumer;
import com.example.grpc.multiChat.MultiChatMessage;
import com.example.grpc.multiChat.MultiChatServiceGrpc;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 이름 입력
        System.out.print("성명 입력: ");
        String username = scanner.nextLine();
        // String received = scanner.nextLine();


        // gRPC 서버와 연결할 채널 생성 (서버 IP를 localhost 대신 사용)
        // 예: 서버의 공인 IP 주소를 넣어야 함
        String serverAddress = "172.168.10.71"; // 예: "172.168.10.74"
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, 50052)
                .usePlaintext() // 암호화되지 않은 연결 (보안상 더 안전한 방법은 gRPC TLS를 사용하는 것)
                .build();


        //mq 수신처리 토픽은 수정가능
        TopicConsumer topicConsumer = new TopicConsumer(username,"topic");
        Thread topicThread = new Thread(topicConsumer);
        topicThread.start();
        QueueConsumer queueConsumer = new QueueConsumer(username);
        Thread queueThread = new Thread(queueConsumer);
        queueThread.start();



        // 비동기 클라이언트 스텁 생성
        //ChatServiceGrpc.ChatServiceStub asyncStub = ChatServiceGrpc.newStub(channel);
        MultiChatServiceGrpc.MultiChatServiceStub asyncStub = MultiChatServiceGrpc.newStub(channel);
        ChatServiceGrpc.ChatServiceStub asyncStub2 = ChatServiceGrpc.newStub(channel);

        // 서버로 메시지를 전송할 스트림
        StreamObserver<MultiChatMessage> requestObserver = asyncStub.sendMessage(new StreamObserver<MultiChatMessage>() {
            @Override
            public void onNext(MultiChatMessage multiChatMessage) {
                // 서버로부터 받은 메시지 출력
                System.out.println(multiChatMessage.getSender() + " : " + multiChatMessage.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("에러: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("서버가 닫혔다");
            }
        });


        // 사용자 이름 전송 (첫 메시지)
        MultiChatMessage joinMessage = MultiChatMessage.newBuilder()
                .setSender(username)
                .setTimestamp(String.valueOf(System.currentTimeMillis()))
                //.setMessage("님이 입장하셨습니다. ") 필요없는 부분인데 왜 넣은걸까???
                .build();
        requestObserver.onNext(joinMessage);

        // 사용자로부터 메시지 입력받아 전송
        System.out.println("채팅을 시작합니다.");
        while (true) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            if(message.equals("귓")||message.equals("rnlt")) {
                MultiChatMessage multiChatMessage = MultiChatMessage.newBuilder()
                        .setSender(username)
                        .setMessage("users")
                        .setTimestamp(String.valueOf(System.currentTimeMillis()))
                        .build();
                requestObserver.onNext(multiChatMessage);
                System.out.println("누구에게 보낼것인가");
                String receiveId = scanner.nextLine();;
                System.out.println("보낼 내용 or 파일전송('파일')");
                String wmessage = scanner.nextLine();
                ChatMessage chatMessage = null;
                if(wmessage.equals("파일") || wmessage.equals("vkdlf")) {
                    System.out.println("파일 경로 입력");
                    // 파일 경로 입력
                    String filePath = scanner.nextLine();
                    try {
                        // FileInputStream을 사용하여 파일을 바이트 배열로 읽기
                        File file = new File(filePath);
                        byte[] fileContent = new byte[(int) file.length()];

                        FileInputStream fis = new FileInputStream(file);

                        fis.read(fileContent);  // 파일 내용을 바이트 배열로 읽음

                        // MultiChatMessage에 바이트 배열을 전달
                        //파일 업하는 부분
                        chatMessage = ChatMessage.newBuilder()
                                .setSender(username)
                                .setMessage("첨부파일:!!@@" + file.getName())
                                .setReceiveId(receiveId)
                                .setFile(ByteString.copyFrom(fileContent))
                                .setTimestamp(String.valueOf(System.currentTimeMillis()))
                                .build();

                        fis.close();  // FileInputStream 닫기
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        //System.out.println("트라이케치 끝부분");
                    }
                }else {
                    chatMessage = ChatMessage.newBuilder()
                            .setSender(username)
                            .setMessage(wmessage)
                            .setReceiveId(receiveId)
                            .setTimestamp(String.valueOf(System.currentTimeMillis()))
                            .build();
                }



                StreamObserver<ChatMessage> chatrequestObserver = asyncStub2.sendMessage(new StreamObserver<ChatMessage>() {

                    @Override
                    public void onNext(ChatMessage chatMessage) {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    }

                    @Override
                    public void onCompleted() {
                    }
                });
                chatrequestObserver.onNext(chatMessage);
                // 연결 종료
                chatrequestObserver.onCompleted();

            } else if (message.equals("파일")||message.equals("vkdlf")) {
                System.out.println("파일 경로 입력");
                // 파일 경로 입력
                String filePath = scanner.nextLine();
                try {
                    // FileInputStream을 사용하여 파일을 바이트 배열로 읽기
                    File file = new File(filePath);
                    byte[] fileContent = new byte[(int) file.length()];

                    FileInputStream fis = new FileInputStream(file);

                    fis.read(fileContent);  // 파일 내용을 바이트 배열로 읽음

                    // MultiChatMessage에 바이트 배열을 전달
                    MultiChatMessage multiChatMessage = MultiChatMessage.newBuilder()
                            .setSender(username)
                            .setMessage("첨부파일:!!@@" + file.getName())  // 빈 메시지 또는 적절한 메시지를 설정
                            .setFile(ByteString.copyFrom(fileContent))  // 바이트 배열을 ByteString으로 변환
                            .setTimestamp(String.valueOf(System.currentTimeMillis()))
                            .build();
                    requestObserver.onNext(multiChatMessage);

                    fis.close();  // FileInputStream 닫기
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //System.out.println("트라이케치 끝부분");
                }
            } else {
                MultiChatMessage multiChatMessage = MultiChatMessage.newBuilder()
                        .setSender(username)
                        .setMessage(message)
                        .setTimestamp(String.valueOf(System.currentTimeMillis()))
                        .build();
                requestObserver.onNext(multiChatMessage);
            }
        }

        // 연결 종료
        requestObserver.onCompleted();
        channel.shutdownNow();
    }
}

