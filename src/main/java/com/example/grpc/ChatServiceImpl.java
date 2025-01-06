package com.example.grpc;

import com.example.grpc.chat.ChatMessage;
import com.example.grpc.chat.ChatServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//메인서버에 싣는 서비스
//기본적인 기능들이 들어있을것으로 생각됨
// ChatServiceGrpc.ChatServiceImplBase를 상속받아 proto 파일에서 기본적인 기능들을 가지고 온다고 생각됨
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {
    // 필드
    private final Map<String, StreamObserver<ChatMessage>> clients = new ConcurrentHashMap<>();

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
                // 필드 초기화가 안되면
                if (username == null) {
                    // 새로운 사용자일 경우
                    username = chatMessage.getSender();
                    clients.put(username, responseObserver);
                    broadcastMessage("메인서버 : ", username + "님이 채팅에 참여하였습니다.");
                    return;
                }

                String message = chatMessage.getMessage();

                // 명령어 처리
                if (message.equalsIgnoreCase("users")) {
                    handleUsers(responseObserver);
                } else if (message.startsWith("귓 ")) {
                    handlePrivate(message, responseObserver);
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
                ChatMessage broadcastMessage = ChatMessage.newBuilder()
                        .setSender(sender)
                        .setMessage(message)
                        .setTimestamp(String.valueOf(System.currentTimeMillis()))
                        .build();

                for (StreamObserver<ChatMessage> client : clients.values()) {
                    client.onNext(broadcastMessage);
                }
            }

            // "users" 명령어 처리: 온라인 사용자 목록 반환
            private void handleUsers(StreamObserver<ChatMessage> responseObserver) {
                StringBuilder usersList = new StringBuilder("온라인 사용자 목록 :\n");
                for (String user : clients.keySet()) {
                    usersList.append(user).append("\n");
                }
                sendMessageToClient(responseObserver, usersList.toString());
            }

            // "귓" 명령어 처리: 특정 사용자에게 메시지 전송
            private void handlePrivate(String message, StreamObserver<ChatMessage> responseObserver) {
                String[] parts = message.split(" ", 3);
                if (parts.length < 3) {
                    sendMessageToClient(responseObserver, "잘못된 형식입니다. 올바른 형식은 귓 <유저이름> <메시지> 입니다.");
                } else {
                    String targetUser = parts[1];
                    String privateMessage = parts[2];

                    // 대상 사용자가 존재하는지 확인
                    if (clients.containsKey(targetUser)) {
                        StreamObserver<ChatMessage> targetObserver = clients.get(targetUser);
                        ChatMessage privateChatMessage = ChatMessage.newBuilder()
                                .setSender(username)
                                .setMessage(privateMessage)
                                .setTimestamp(String.valueOf(System.currentTimeMillis()))
                                .build();
                        targetObserver.onNext(privateChatMessage);  // 특정 사용자에게 메시지 전송
                    } else {
                        sendMessageToClient(responseObserver, targetUser + "님은 현재 채팅방에 없습니다.");
                    }
                }
            }

            // 서버 측에서 클라이언트에게 메시지 전송
            private void sendMessageToClient(StreamObserver<ChatMessage> clientObserver, String message) {
                ChatMessage messageToClient = ChatMessage.newBuilder()
                        .setSender("")
                        .setMessage(message)
                        .setTimestamp(String.valueOf(System.currentTimeMillis()))
                        .build();
                clientObserver.onNext(messageToClient);
            }

        };
    }
}