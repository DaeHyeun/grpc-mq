// 프로토콜 버퍼 컴파일러에 의해 생성됨. 수정하지 마세요!
// 체크된 프로토콜 버퍼 생성 코드가 아닙니다.
// 출처: src/main/java/proto/chat.proto
// 프로토콜 버퍼 Java 버전: 4.29.0

package com.example.grpc.chat;
// Chat 클래스는 생성자가 private로 되어 있어 인스턴스를 만들 수 없고,
// 프로토콜 버퍼로 정의된 메시지 구조를 다루는 정적 클래스
public final class Chat {

  // 기본 생성자를 private으로 설정하여 외부에서 객체 생성이 불가능
  private Chat() {}

  // 클래스가 로드될 때 프로토콜 버퍼의 버전 검사를 수행
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,// 검증 대상은 PUBLIC 도메인
      /* major= */ 4, //주요버전
      /* minor= */ 29, //부버전
      /* patch= */ 0, //패치버전
      /* suffix= */ "",// 버전 뒤에 붇는 접미사
      Chat.class.getName());//검증할 클래스 이름
  }

  // 확장 필드를 레지스트리에 등록하는 메서드 현재는 구현이 없다
  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}
  // 동일한 메서드로, 확장 필드를 레지스트리에 등록
  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  // ChatMessage 메시지에 대한 설명자(Descriptor)를 정의
  static final com.google.protobuf.Descriptors.Descriptor internal_static_chat_ChatMessage_descriptor;
  // ChatMessage 메시지에 대한 필드 접근자를 정의
  static final com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_chat_ChatMessage_fieldAccessorTable;

  // 현재 클래스의 파일 설명자를 반환하는 메서드
  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  // 파일 설명자를 저장하는 변수입니다.
  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
  // static 블록 내에서 파일 설명자를 초기화
  static {// 프로토콜 버퍼로 작성된 .proto 파일의 내용을 문자열로 정의
    java.lang.String[] descriptorData = {
      "\n\036src/main/java/proto/chat.proto\022\004chat\"A" +
      "\n\013ChatMessage\022\016\n\006sender\030\001 \001(\t\022\017\n\007message" +
      "\030\002 \001(\t\022\021\n\ttimestamp\030\003 \001(\t2F\n\013ChatService" +
      "\0227\n\013SendMessage\022\021.com.example.grpc.chat.ChatMessage\032\021.cha" +
      "t.ChatMessage(\0010\001B\002P\001b\006proto3"
    };

    // 위에서 정의된 descriptorData를 바탕으로 파일 설명자를 빌드
    descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {});
    // ChatMessage 메시지의 설명자를 가져옴
    internal_static_chat_ChatMessage_descriptor = getDescriptor().getMessageTypes().get(0);
    // ChatMessage 메시지의 필드 접근자를 설정합니다.
    internal_static_chat_ChatMessage_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_chat_ChatMessage_descriptor,
        new java.lang.String[] { "Sender", "Message", "Timestamp", });
    // 모든 특성을 불변으로 해결합니다.
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
