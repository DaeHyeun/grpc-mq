package com.example.grpc.multiChat;


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
public class MultiChatServiceImpl extends MultiChatServiceGrpc.MultiChatServiceImplBase {

    // ActiveMQ Topic를 활용 예정

    // 필드
    private final Map<String, StreamObserver<com.example.grpc.multiChat.MultiChatMessage>> clients = new ConcurrentHashMap<>();
    private List<TopicProcedure> topicProcedureList = new ArrayList<>();

    // 메소드 오버라이딩
    // 메세지 보내는 것으로생각됨 파라미터는 스트림 옵저버 타입
    // return 옵저버 타입
    @Override
    public StreamObserver<com.example.grpc.multiChat.MultiChatMessage> sendMessage(StreamObserver<com.example.grpc.multiChat.MultiChatMessage> responseObserver) {
        // 별다른 작없없이 바로 스트림 옵저버 타입 리턴
        return new StreamObserver<com.example.grpc.multiChat.MultiChatMessage>() {
            //인터페이스 타입 바로 생성하면서 메소드 오버라이딩
            // 필드 추가 사용자 이름
            private String username;

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            //                                          Method 오버라이딩                                         //
            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            //onNext
            //파라미터 ChatMessage타입
            @Override
            public void onNext(com.example.grpc.multiChat.MultiChatMessage chatMessage) {
                if (clients.size()==0){
                    topicProcedureList.add(new TopicProcedure( "Server", "topic","", null));
                }
                // 필드 초기화가 안되면
                if (username == null) {
                    username = chatMessage.getSender();
                    clients.put(username, responseObserver);
                    // 새로운 사용자일 경우
                    topicProcedureList.add(new TopicProcedure( username, "topic","", null));
                    broadcastMessage("메인서버 : ", username + "님이 채팅에 참여하였습니다.");
                    return;
                }

                String message = chatMessage.getMessage();

                // 명령어 처리
                if (message.equalsIgnoreCase("users")) {
                    handleUsers(responseObserver);
                } else if (message.equalsIgnoreCase("help")) {
                    handlehelp(responseObserver);
                } else if (message.contains("첨부파일:!!@@")) {
                    ByteString fileData = chatMessage.getFile();
                    // ByteString을 바이트 배열로 변환
                    byte[] fileContent = fileData.toByteArray();
                    fileMessage(chatMessage.getSender(), chatMessage.getMessage(), fileContent);
                    } else {
                    // 수신된 메시지를 다른 클라이언트에게 브로드캐스트
                    broadcastMessage(chatMessage.getSender(), chatMessage.getMessage());

                    // 메시지를 데이터베이스에 저장

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
                System.out.println(username + "님이 나가셨습니다.");
                broadcastMessage("메인서버", username + "님이 나가셨습니다.");
                removeClient();
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

            //메세지 보내는 Method
            private void broadcastMessage(String sender, String message) {
                if(message.contains("님이 채팅에 참여하였습니다.")){
                    for (int i = 0; i < topicProcedureList.size(); i++) {
                        if(topicProcedureList.get(i).getName().equals("Server")){
                            topicProcedureList.get(i).setMessage(message);
                            new Thread(topicProcedureList.get(i)).start();
                        }
                    }
                }
                for (int i = 0; i < topicProcedureList.size(); i++) {
                    if (topicProcedureList.get(i).getName().equals(sender)) {
                        topicProcedureList.get(i).setMessage(sender +" : " +  message);
                        new Thread(topicProcedureList.get(i)).start();
                        break;
                    }
                }
            }

            //파일 전송
            private void fileMessage(String sender, String message, byte[] fileData) {
                for (int i = 0; i < topicProcedureList.size(); i++) {
                    if (topicProcedureList.get(i).getName().equals(sender)) {
                        topicProcedureList.get(i).setMessage(message);
                        topicProcedureList.get(i).setFile(fileData);
                        new Thread(topicProcedureList.get(i)).start();
                        break;
                    }
                }
            }

            // "users" 명령어 처리: 온라인 사용자 목록 반환
            private void handleUsers(StreamObserver<com.example.grpc.multiChat.MultiChatMessage> responseObserver) {
                 StringBuilder usersList = new StringBuilder("온라인 사용자 목록 :\n");
                for (String user : clients.keySet()) {
                    usersList.append(user).append("\n");
                }
                sendMessageToClient(responseObserver, usersList.toString());
            }
            // "users" 명령어 처리: 온라인 사용자 목록 반환
            private void handlehelp(StreamObserver<com.example.grpc.multiChat.MultiChatMessage> responseObserver) {
                StringBuilder help = new StringBuilder("<도움말>\n" +
                        "\n" +
                        "단체 채팅을 기본으로 진행됩니다. \n" +
                        "\n" +
                        "특정 1인에게 메세지 전달 -> 귓 -> 보낼 사람 선택 -> 메세지 입력\n" +
                        "\n" +
                        "첨부파일 \n" +
                        "1. 파일 -> 파일경로\n" +
                        "2. 귓 -> 보낼사람 선택 -> 파일 -> 파일 경로\n" +
                        "\n" +
                        "MAP\n" +
                        "1. map -> map입력\n" +
                        "2. 귓 -> 보낼사람 선택 -> map -> map입력\n" +
                        "\n" +
                        "사용자 확인 users 입력");
                sendMessageToClient(responseObserver, help.toString());
            }

            // 서버 측에서 클라이언트에게 메시지 전송
            private void sendMessageToClient(StreamObserver<com.example.grpc.multiChat.MultiChatMessage> clientObserver, String message) {
                com.example.grpc.multiChat.MultiChatMessage messageToClient = MultiChatMessage.newBuilder()
                        .setSender("")
                        .setMessage(message)
                        .setTimestamp(String.valueOf(System.currentTimeMillis()))
                        .build();
                clientObserver.onNext(messageToClient);
            }

        };
    }
}