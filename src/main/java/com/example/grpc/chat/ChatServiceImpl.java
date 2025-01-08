package com.example.grpc.chat;

import com.example.grpc.mq.QueueProcedure;
import com.example.grpc.mq.TopicProcedure;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//메인서버에 싣는 서비스
//기본적인 기능들이 들어있을것으로 생각됨
// ChatServiceGrpc.ChatServiceImplBase를 상속받아 proto 파일에서 기본적인 기능들을 가지고 온다고 생각됨
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    // ActiceMQ Queue를 활용예정

    // 필드
    private final Map<String, StreamObserver<ChatMessage>> clients = new ConcurrentHashMap<>();
    //private List<QueueProcedure> queueProcedureList = new ArrayList<>();
    // 메소드 오버라이딩
    // 메세지 보내는 것으로생각됨 파라미터는 스트림 옵저버 타입
    // return 옵저버 타입
    @Override
    public StreamObserver<ChatMessage> sendMessage(StreamObserver<ChatMessage> responseObserver) {
        // 별다른 작없없이 바로 스트림 옵저버 타입 리턴
        return new StreamObserver<ChatMessage>() {
            //인터페이스 타입 바로 생성하면서 메소드 오버라이딩
            // 필드 추가 사용자 이름
            private String username;

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            //                                          Method 오버라이딩                                         //
            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            //onNext
            //파라미터 ChatMessage타입
            @Override
            public void onNext(ChatMessage chatMessage) {
                String message = chatMessage.getMessage();
                String receiveId = chatMessage.getReceiveId();

                if(message.contains("첨부파일:!!@@")) {
                    ByteString fileData = chatMessage.getFile();
                    // ByteString을 바이트 배열로 변환
                    byte[] fileContent = fileData.toByteArray();
                   // fileMessage(chatMessage.getSender(), chatMessage.getMessage(), fileContent);
                    System.out.println("====================================");
                    System.out.println(fileContent.length);
                    System.out.println("====================================");

                    new Thread(new QueueProcedure(chatMessage.getSender(), chatMessage.getSender() + " : " + message, receiveId, null, fileContent)).start();

                }else {
                    new Thread(new QueueProcedure(chatMessage.getSender(), chatMessage.getSender() + " : " + message, receiveId, null, null)).start();
                }
            }

            //에러
            @Override
            public void onError(Throwable t) {
                System.err.println("에러난 사람 이름 : " + username);
                t.printStackTrace();
                removeClient();
            }

            //퇴장
            @Override
            public void onCompleted() {
            }

            private void removeClient() {
                if (username != null) {
                    clients.remove(username);
                }
                responseObserver.onCompleted();
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            //                                          커스템 메소드                                             //
            ////////////////////////////////////////////////////////////////////////////////////////////////////////



        };
    }
}