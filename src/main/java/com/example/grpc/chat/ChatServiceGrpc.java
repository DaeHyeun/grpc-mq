package com.example.grpc.chat;

import static io.grpc.MethodDescriptor.generateFullMethodName;

@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.62.2)",
        comments = "Source: src/main/java/proto/chat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatServiceGrpc {

    // 서비스 이름: gRPC에서 호출할 때 사용할 서비스 이름
    public static final java.lang.String SERVICE_NAME = "chat.ChatService";
    // 메서드 ID 상수 정의 (예: SendMessage 메서드)
    private static final int METHODID_SEND_MESSAGE = 0;
    // SendMessage 메서드에 대한 MethodDescriptor 객체를 저장할 필드
    private static volatile io.grpc.MethodDescriptor<ChatMessage, ChatMessage> getSendMessageMethod;
    // 서비스 설명자 (ServiceDescriptor) 캐시
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    // 생성자는 private으로 설정하여 외부에서 인스턴스를 생성하지 못하게 함
    private ChatServiceGrpc() {
    }

    // gRPC 메서드의 메타데이터 정의
    // 'SendMessage' 메서드는 양방향 스트리밍(BIDI_STREAMING) 방식으로 데이터를 전송
    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "SendMessage",  // 전체 메서드 이름
            requestType = ChatMessage.class,  // 요청 타입
            responseType = ChatMessage.class,  // 응답 타입
            methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)  // 메서드 타입: 양방향 스트리밍

    // SendMessage 메서드에 대한 MethodDescriptor를 반환하는 메서드
    public static io.grpc.MethodDescriptor<ChatMessage, ChatMessage> getSendMessageMethod() {
        io.grpc.MethodDescriptor<ChatMessage, ChatMessage> getSendMessageMethod;
        // 이미 MethodDescriptor가 생성되어 있는지 확인하고, 없다면 생성
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
            synchronized (ChatServiceGrpc.class) {
                if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
                    // MethodDescriptor 생성 (gRPC에서 메서드를 어떻게 처리할지 정의)
                    ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod = io.grpc.MethodDescriptor.<ChatMessage, ChatMessage>newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)  // 양방향 스트리밍 방식
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))  // 메서드 이름 설정
                            .setSampledToLocalTracing(true)  // 로컬 추적을 위한 설정
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(  // 요청 메시지의 직렬화 설정
                                    ChatMessage.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(  // 응답 메시지의 직렬화 설정
                                    ChatMessage.getDefaultInstance()))
                            .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("SendMessage"))  // 메서드에 대한 설명 공급자 설정
                            .build();
                }
            }
        }
        return getSendMessageMethod;// 최종적으로 메서드 반환
    }

    // 클라이언트가 호출할 수 있는 비동기 Stub 생성
    public static ChatServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub> factory = new io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub>() {
            @java.lang.Override
            public ChatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ChatServiceStub(channel, callOptions);// ChatServiceStub 객체 반환
            }
        };
        return ChatServiceStub.newStub(factory, channel);// 채널을 통해 새 Stub 반환
    }

    // 클라이언트가 호출할 수 있는 블로킹(동기식) Stub 생성
    public static ChatServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub>() {
            @java.lang.Override
            public ChatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ChatServiceBlockingStub(channel, callOptions);  // ChatServiceBlockingStub 객체 반환
            }
        };
        return ChatServiceBlockingStub.newStub(factory, channel);  // 채널을 통해 새 블로킹 Stub 반환
    }

    // 클라이언트가 호출할 수 있는 Future(비동기) Stub 생성
    public static ChatServiceFutureStub newFutureStub(io.grpc.Channel channel) {

        io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub>() {
            @java.lang.Override
            public ChatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ChatServiceFutureStub(channel, callOptions);  // ChatServiceFutureStub 객체 반환
            }
        };
        return ChatServiceFutureStub.newStub(factory, channel);  // 채널을 통해 새 Future Stub 반환
    }

    // 서버에 서비스를 바인딩하는 메서드
    public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                .addMethod(
                        getSendMessageMethod(),  // 메서드 추가
                        io.grpc.stub.ServerCalls.asyncBidiStreamingCall(  // 양방향 스트리밍 처리
                                new MethodHandlers<ChatMessage, ChatMessage>(
                                        service, METHODID_SEND_MESSAGE)))  // 'SendMessage' 메서드 핸들러 연결
                .build();
    }

    // 서비스 설명자 반환 메서드 (싱글톤 패턴)
    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (ChatServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    // 서비스 설명자 생성
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())  // 파일 설명 공급자 설정
                            .addMethod(getSendMessageMethod())  // 메서드 추가
                            .build();
                }
            }
        }
        return result;  // 최종적으로 서비스 설명자 반환
    }

    // 비동기 서비스 인터페이스 정의
    // 이 인터페이스는 서버에서 비동기 방식으로 클라이언트 요청을 처리하는 메서드를 포함
    public interface AsyncService {
        // 'sendMessage' 메서드의 기본 구현 제공 (메서드는 비동기 방식으로 처리)
        default io.grpc.stub.StreamObserver<ChatMessage> sendMessage(io.grpc.stub.StreamObserver<ChatMessage> responseObserver) {
            return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendMessageMethod(), responseObserver);  // 메서드 미구현시 기본 구현
        }
    }

    // 서버 구현 클래스
    // 이 클래스는 실제로 서비스 메서드를 구현하는 기본 클래스
    public static abstract class ChatServiceImplBase implements io.grpc.BindableService, AsyncService {
        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return ChatServiceGrpc.bindService(this);  // 서비스 바인딩
        }
    }

    // 비동기 클라이언트 Stub 클래스
    public static final class ChatServiceStub extends io.grpc.stub.AbstractAsyncStub<ChatServiceStub> {
        // 생성자: 채널과 호출 옵션을 받아서 상위 클래스인 AbstractAsyncStub에 전달
        private ChatServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        // Stub의 새 인스턴스를 생성하는 메서드
        @java.lang.Override
        protected ChatServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChatServiceStub(channel, callOptions);
        }

        // 'SendMessage' 메서드 호출을 위한 비동기 스트리밍 호출
        public io.grpc.stub.StreamObserver<ChatMessage> sendMessage(io.grpc.stub.StreamObserver<ChatMessage> responseObserver) {
            return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
                    getChannel().newCall(getSendMessageMethod(), getCallOptions()), responseObserver);
        }
    }

    // 동기 클라이언트 Stub 클래스
    public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatServiceBlockingStub> {
        // 생성자: 채널과 호출 옵션을 받아서 상위 클래스인 AbstractBlockingStub에 전달
        private ChatServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        // Stub의 새 인스턴스를 생성하는 메서드
        @java.lang.Override
        protected ChatServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChatServiceBlockingStub(channel, callOptions);
        }
    }

    // Future 스타일의 클라이언트 Stub 클래스
    public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ChatServiceFutureStub> {
        // 생성자: 채널과 호출 옵션을 받아서 상위 클래스인 AbstractFutureStub에 전달
        private ChatServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        // Stub의 새 인스턴스를 생성하는 메서드
        @java.lang.Override
        protected ChatServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChatServiceFutureStub(channel, callOptions);
        }
    }

    // 서버에서 메서드를 처리하는 핸들러 클래스
    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,  // 단방향 호출 처리
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,  // 서버 스트리밍 호출 처리
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,  // 클라이언트 스트리밍 호출 처리
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {  // 양방향 스트리밍 호출 처리

        // 필드: 서비스 구현체와 메서드 ID
        private final AsyncService serviceImpl;
        private final int methodId;

        // 생성자: 서비스 구현체와 메서드 ID를 초기화
        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                          메서드 오버라이딩                                         //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();  // 예외 처리 (메서드 ID가 잘못된 경우)
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SEND_MESSAGE:
                    // 'SendMessage' 메서드를 처리하는 부분
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMessage(
                            (io.grpc.stub.StreamObserver<ChatMessage>) responseObserver);
                default:
                    throw new AssertionError();  // 예외 처리 (메서드 ID가 잘못된 경우)
            }
        }
    }

    // 서비스 설명을 위한 기본 클래스
    private static abstract class ChatServiceBaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        ChatServiceBaseDescriptorSupplier() {
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                          메서드 오버라이딩                                         //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Chat.getDescriptor();  // 프로토 파일의 설명을 반환
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ChatService");  // 'ChatService' 서비스 설명 반환
        }
    }

    // 서비스 파일 설명 공급자 클래스
    private static final class ChatServiceFileDescriptorSupplier extends ChatServiceBaseDescriptorSupplier {
        ChatServiceFileDescriptorSupplier() {
        }
    }

    // 메서드 설명 공급자 클래스
    private static final class ChatServiceMethodDescriptorSupplier extends ChatServiceBaseDescriptorSupplier implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        // 필드: 메서드 이름
        private final java.lang.String methodName;

        // 생성자
        ChatServiceMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                          메서드 오버라이딩                                         //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);  // 메서드 설명 반환
        }
    }
}
