package com.example.grpc;


import com.example.grpc.chat.ChatMessage;
import com.example.grpc.chat.ChatServiceGrpc;
import com.example.grpc.mq.Consumer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 이름 입력
        System.out.print("성명 입력: ");
        String username = scanner.nextLine();

        // gRPC 서버와 연결할 채널 생성 (서버 IP를 localhost 대신 사용)
        // 예: 서버의 공인 IP 주소를 넣어야 함
        String serverAddress = "172.168.10.71"; // 예: "172.168.10.74"
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, 50052)
                .usePlaintext() // 암호화되지 않은 연결 (보안상 더 안전한 방법은 gRPC TLS를 사용하는 것)
                .build();

        //수신처리
        String reciId = "";
        if(username.equals("aa")){
            reciId = "bb";
        }else {
            reciId = "aa";
        };
        Consumer consumer = new Consumer(username,reciId);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        // 비동기 클라이언트 스텁 생성
        ChatServiceGrpc.ChatServiceStub asyncStub = ChatServiceGrpc.newStub(channel);

        // 서버로 메시지를 전송할 스트림
        StreamObserver<ChatMessage> requestObserver = asyncStub.sendMessage(new StreamObserver<ChatMessage>() {
            @Override
            public void onNext(ChatMessage chatMessage) {
                // 서버로부터 받은 메시지 출력
                System.out.println(chatMessage.getSender() + " : " + chatMessage.getMessage());
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
        ChatMessage joinMessage = ChatMessage.newBuilder()
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

            ChatMessage chatMessage = ChatMessage.newBuilder()
                    .setSender(username)
                    .setMessage(message)
                    .setTimestamp(String.valueOf(System.currentTimeMillis()))
                    .build();
            System.out.println(chatMessage.getMessage());
            requestObserver.onNext(chatMessage);
        }

        // 연결 종료
        requestObserver.onCompleted();
        channel.shutdownNow();
    }
}