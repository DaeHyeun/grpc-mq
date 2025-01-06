package com.example.grpc.multiChat;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 서비스 정의
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: multiChat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MultiChatServiceGrpc {

  private MultiChatServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.multiChat.MultiChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.multiChat.MultiChatMessage,
      com.example.grpc.multiChat.MultiChatMessage> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.example.grpc.multiChat.MultiChatMessage.class,
      responseType = com.example.grpc.multiChat.MultiChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.multiChat.MultiChatMessage,
      com.example.grpc.multiChat.MultiChatMessage> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.multiChat.MultiChatMessage, com.example.grpc.multiChat.MultiChatMessage> getSendMessageMethod;
    if ((getSendMessageMethod = MultiChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (MultiChatServiceGrpc.class) {
        if ((getSendMessageMethod = MultiChatServiceGrpc.getSendMessageMethod) == null) {
          MultiChatServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.multiChat.MultiChatMessage, com.example.grpc.multiChat.MultiChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.multiChat.MultiChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.multiChat.MultiChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MultiChatServiceMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MultiChatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MultiChatServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MultiChatServiceStub>() {
        @java.lang.Override
        public MultiChatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MultiChatServiceStub(channel, callOptions);
        }
      };
    return MultiChatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MultiChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MultiChatServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MultiChatServiceBlockingStub>() {
        @java.lang.Override
        public MultiChatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MultiChatServiceBlockingStub(channel, callOptions);
        }
      };
    return MultiChatServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MultiChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MultiChatServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MultiChatServiceFutureStub>() {
        @java.lang.Override
        public MultiChatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MultiChatServiceFutureStub(channel, callOptions);
        }
      };
    return MultiChatServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 서비스 정의
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 클라이언트에서 보내는 스트리밍 메시지
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.example.grpc.multiChat.MultiChatMessage> sendMessage(
        io.grpc.stub.StreamObserver<com.example.grpc.multiChat.MultiChatMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MultiChatService.
   * <pre>
   * 서비스 정의
   * </pre>
   */
  public static abstract class MultiChatServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MultiChatServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MultiChatService.
   * <pre>
   * 서비스 정의
   * </pre>
   */
  public static final class MultiChatServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MultiChatServiceStub> {
    private MultiChatServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MultiChatServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MultiChatServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 클라이언트에서 보내는 스트리밍 메시지
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.multiChat.MultiChatMessage> sendMessage(
        io.grpc.stub.StreamObserver<com.example.grpc.multiChat.MultiChatMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MultiChatService.
   * <pre>
   * 서비스 정의
   * </pre>
   */
  public static final class MultiChatServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MultiChatServiceBlockingStub> {
    private MultiChatServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MultiChatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MultiChatServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MultiChatService.
   * <pre>
   * 서비스 정의
   * </pre>
   */
  public static final class MultiChatServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MultiChatServiceFutureStub> {
    private MultiChatServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MultiChatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MultiChatServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMessage(
              (io.grpc.stub.StreamObserver<com.example.grpc.multiChat.MultiChatMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendMessageMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.example.grpc.multiChat.MultiChatMessage,
              com.example.grpc.multiChat.MultiChatMessage>(
                service, METHODID_SEND_MESSAGE)))
        .build();
  }

  private static abstract class MultiChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MultiChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.multiChat.MultiChat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MultiChatService");
    }
  }

  private static final class MultiChatServiceFileDescriptorSupplier
      extends MultiChatServiceBaseDescriptorSupplier {
    MultiChatServiceFileDescriptorSupplier() {}
  }

  private static final class MultiChatServiceMethodDescriptorSupplier
      extends MultiChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MultiChatServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MultiChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MultiChatServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
