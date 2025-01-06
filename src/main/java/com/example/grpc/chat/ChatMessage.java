// 이 파일은 프로토콜 버퍼 컴파일러에 의해 생성되었습니다. 수정하지 마세요!
// 체크인된 프로토콜 버퍼 생성 코드는 없습니다.
// 원본 파일: src/main/java/proto/chat.proto
// 프로토콜 버퍼 자바 버전: 4.29.0

package com.example.grpc.chat;


public final class ChatMessage extends com.google.protobuf.GeneratedMessage implements
        // 이 클래스는 'com.example.grpc.chat.ChatMessage' 메시지의 구현체입니다.
        ChatMessageOrBuilder {

    // 발신자 이름을 저장하는 필드
    public static final int SENDER_FIELD_NUMBER = 1; // 발신자 필드 번호는 1번
    // 메시지 내용을 저장하는 필드
    public static final int MESSAGE_FIELD_NUMBER = 2; // 메시지 필드 번호는 2번
    // TIMESTAMP_FIELD_NUMBER는 이 클래스에서 'timestamp' 필드의 번호
    // 프로토콜 버퍼에서 각 필드는 고유한 번호를 가집니다. 여기서는 'timestamp' 필드가 3번 필드
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    // 고유한 ID를 설정하여 클래스 직렬화를 처리
    private static final long serialVersionUID = 0L;

    /**     * 기본 'ChatMessage' 인스턴스를 설정하는 static 블록     */
    private static final ChatMessage DEFAULT_INSTANCE;

    /**     * 'ChatMessage' 객체를 파싱하는 Parser     */
    private static final com.google.protobuf.Parser<ChatMessage> PARSER = new com.google.protobuf.AbstractParser<ChatMessage>() {
        @java.lang.Override
        public ChatMessage parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            Builder builder = newBuilder();  // 새로운 Builder 객체 생성
            try {
                builder.mergeFrom(input, extensionRegistry);  // 입력 데이터를 Builder에 병합
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builder.buildPartial());  // 예외 발생 시 부분적으로 생성된 메시지 반환
            } catch (com.google.protobuf.UninitializedMessageException e) {
                throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());  // 메시지가 초기화되지 않았을 때 처리
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(builder.buildPartial());  // I/O 예외 발생 시 처리
            }
            return builder.buildPartial();  // 최종적으로 부분적으로 생성된 ChatMessage 반환
        }
    };

    static {
        // 프로토콜 버퍼 런타임 검증. 사용하는 프로토콜 버전이 정확한지 확인합니다.
        com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
                com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
                /* major= */ 4,
                /* minor= */ 29,
                /* patch= */ 0,
                /* suffix= */ "",
                ChatMessage.class.getName());
    }

    static {
        DEFAULT_INSTANCE = new ChatMessage();  // 기본 인스턴스 생성
    }

    @SuppressWarnings("serial")
    private volatile java.lang.Object sender_ = ""; // 발신자 이름을 저장하는 변수
    @SuppressWarnings("serial")
    private volatile java.lang.Object message_ = ""; // 메시지 내용을 저장하는 변수
    // timestamp_는 메시지의 전송 시간을 저장하는 내부 필드입니다.
// 초기 값은 빈 문자열로 설정됩니다.
    @SuppressWarnings("serial")
    private volatile java.lang.Object timestamp_ = "";
    // 'isInitialized' 메소드는 이 객체가 초기화되었는지를 체크합니다.
// 이 메소드는 객체가 올바르게 생성되었는지 확인할 때 사용됩니다.
    private byte memoizedIsInitialized = -1; // 이 값을 -1로 초기화하여 객체의 초기화 상태를 추적

    /////////////////////////////////////////////////////////////생성자
    // ChatMessage 객체를 생성할 때 사용하는 빌더 패턴의 생성자입니다.
    // ChatMessage.newBuilder()를 사용하여 이 객체를 생성해야 합니다.
    private ChatMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
        super(builder); // 상위 클래스인 GeneratedMessage의 생성자 호출
    }

    // 기본 생성자입니다. 필드들을 기본값으로 초기화합니다.
    private ChatMessage() {
        sender_ = "";  // 발신자 이름 초기값은 빈 문자열
        message_ = ""; // 메시지 내용 초기값은 빈 문자열
        timestamp_ = ""; // 타임스탬프 초기값은 빈 문자열
    }

    /////////////////////////////////////////////////////////////////////Method
    // 'ChatMessage' 클래스의 Descriptor를 반환하는 메소드입니다.
    // Descriptor는 이 클래스가 프로토콜 버퍼로 정의된 메시지임을 설명합니다.
    public static com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return Chat.internal_static_chat_ChatMessage_descriptor; // 정의된 프로토콜 메시지의 설명을 반환
    }

    // ByteBuffer에서 데이터를 읽어 ChatMessage 객체로 변환
    public static ChatMessage parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

// 'timestamp' 필드의 값을 반환하는 메소드입니다.
// 이 필드는 메시지가 전송된 시간을 나타내며, 문자열로 저장됩니다.
// 내부적으로 ByteString 형식으로 저장되어 있을 수 있으므로, 이를 UTF-8 문자열로 변환하여 반환합니다.

    // ByteBuffer에서 데이터를 읽어 ChatMessage 객체로 변환 (확장 레지스트리 사용)
    public static ChatMessage parseFrom(java.nio.ByteBuffer data,
                                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

// 'timestamp' 필드의 값을 바이트 배열 형식(ByteString)으로 반환하는 메소드입니다.
// 이 메소드는 `getTimestamp()`와 비슷하지만, 결과를 바이트 데이터로 반환합니다.

    // ByteString에서 데이터를 읽어 ChatMessage 객체로 변환
    public static ChatMessage parseFrom(com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    // ByteString에서 데이터를 읽어 ChatMessage 객체로 변환 (확장 레지스트리 사용)
    public static ChatMessage parseFrom(com.google.protobuf.ByteString data,
                                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    // byte 배열에서 데이터를 읽어 ChatMessage 객체로 변환
    public static ChatMessage parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    // byte 배열에서 데이터를 읽어 ChatMessage 객체로 변환 (확장 레지스트리 사용)
    public static ChatMessage parseFrom(byte[] data,
                                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    // InputStream에서 데이터를 읽어 ChatMessage 객체로 변환
    public static ChatMessage parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseWithIOException(PARSER, input); // 입력 스트림을 읽고 파싱
    }

    // InputStream에서 데이터를 읽어 ChatMessage 객체로 변환 (확장 레지스트리 사용)
    public static ChatMessage parseFrom(java.io.InputStream input,
                                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseWithIOException(PARSER, input, extensionRegistry); // 입력 스트림을 읽고 파싱
    }

    // Delimited 형식으로 구분된 데이터를 InputStream에서 읽어 ChatMessage 객체로 변환
    public static ChatMessage parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseDelimitedWithIOException(PARSER, input); // 구분된 데이터를 읽고 파싱
    }

// 'parseFrom' 메소드들은 다양한 입력 스트림 타입에서 데이터를 읽어
// ChatMessage 객체로 변환하는 메소드들입니다. 이 메소드들은 프로토콜 버퍼 데이터를 역직렬화합니다.

    // Delimited 형식으로 구분된 데이터를 InputStream에서 읽어 ChatMessage 객체로 변환 (확장 레지스트리 사용)
    public static ChatMessage parseDelimitedFrom(java.io.InputStream input,
                                                 com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry); // 구분된 데이터를 읽고 파싱
    }

    // CodedInputStream에서 데이터를 읽어 ChatMessage 객체로 변환
    public static ChatMessage parseFrom(com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseWithIOException(PARSER, input); // CodedInputStream을 읽고 파싱
    }

    // CodedInputStream에서 데이터를 읽어 ChatMessage 객체로 변환 (확장 레지스트리 사용)
    public static ChatMessage parseFrom(com.google.protobuf.CodedInputStream input,
                                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseWithIOException(PARSER, input, extensionRegistry); // CodedInputStream을 읽고 파싱
    }

    // 기본 ChatMessage 객체에서 Builder 객체를 생성하는 메소드입니다.
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder(); // 기본 인스턴스를 기반으로 Builder 객체 생성
    }

    // 주어진 ChatMessage 객체를 바탕으로 Builder 객체를 생성하는 메소드입니다.
// prototype은 초기 값으로 사용됩니다.
    public static Builder newBuilder(ChatMessage prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype); // 기존 인스턴스를 병합하여 Builder 객체 생성
    }

    /**
     * 기본 'ChatMessage' 인스턴스를 반환합니다.
     *
     * @return The default instance of ChatMessage.
     */
    public static ChatMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;  // 기본 인스턴스 반환
    }

    /**
     * 'ChatMessage'를 파싱하는 Parser 객체를 반환합니다.
     *
     * @return The parser for ChatMessage.
     */
    public static com.google.protobuf.Parser<ChatMessage> parser() {
        return PARSER;  // Parser 객체 반환
    }

    // 이 클래스의 각 필드를 접근할 수 있는 액세서 테이블을 반환합니다.
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return Chat.internal_static_chat_ChatMessage_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        ChatMessage.class, ChatMessage.Builder.class); // 클래스와 빌더 클래스 초기화
    }

    /**
     * <pre>
     * 발신자
     * </pre>
     * 이 메소드는 'sender' 필드를 반환하는 메소드입니다.
     * 프로토콜 버퍼에서 정의된 'string sender = 1;'와 일치합니다.
     *
     * @return 발신자 이름을 반환합니다.
     */
    @java.lang.Override
    public java.lang.String getSender() {
        java.lang.Object ref = sender_; // sender_ 필드를 참조합니다.
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref; // 이미 문자열로 저장되어 있으면 바로 반환
        } else {
            // ByteString 타입으로 저장되어 있으면 문자열로 변환하여 반환
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8(); // UTF-8로 변환
            sender_ = s; // 변환된 값을 다시 sender_에 저장
            return s; // 발신자 이름을 반환
        }
    }

    /**
     * <pre>
     * 발신자
     * </pre>
     * 이 메소드는 'sender' 필드를 바이트 배열로 반환하는 메소드입니다.
     *
     * @return 발신자 이름의 바이트 데이터를 반환합니다.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getSenderBytes() {
        java.lang.Object ref = sender_; // sender_ 필드를 참조
        if (ref instanceof java.lang.String) {
            // 문자열로 저장되어 있으면 ByteString으로 변환하여 반환
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
            sender_ = b; // 변환된 ByteString 값을 다시 sender_에 저장
            return b; // ByteString 반환
        } else {
            return (com.google.protobuf.ByteString) ref; // 이미 ByteString이면 그대로 반환
        }
    }

    /**
     * <pre>
     * 메시지 내용
     * </pre>
     * 이 메소드는 'message' 필드를 반환하는 메소드입니다.
     * 프로토콜 버퍼에서 정의된 'string message = 2;'와 일치합니다.
     *
     * @return 메시지 내용을 반환합니다.
     */
    @java.lang.Override
    public java.lang.String getMessage() {
        java.lang.Object ref = message_; // message_ 필드를 참조
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref; // 이미 문자열로 저장되어 있으면 바로 반환
        } else {
            // ByteString 타입으로 저장되어 있으면 문자열로 변환하여 반환
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8(); // UTF-8로 변환
            message_ = s; // 변환된 값을 다시 message_에 저장
            return s; // 메시지 내용을 반환
        }
    }

    /**
     * <pre>
     * 메시지 내용
     * </pre>
     * 이 메소드는 'message' 필드를 바이트 배열로 반환하는 메소드입니다.
     *
     * @return 메시지 내용의 바이트 데이터를 반환합니다.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getMessageBytes() {
        java.lang.Object ref = message_; // message_ 필드를 참조
        if (ref instanceof java.lang.String) {
            // 문자열로 저장되어 있으면 ByteString으로 변환하여 반환
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
            message_ = b; // 변환된 ByteString 값을 다시 message_에 저장
            return b; // ByteString 반환
        } else {
            return (com.google.protobuf.ByteString) ref; // 이미 ByteString이면 그대로 반환
        }
    }

    /**
     * <pre>
     * 메시지 전송 시간
     * </pre>
     *
     * <code>string timestamp = 3;</code>
     *
     * @return 메시지 전송 시간을 나타내는 문자열을 반환합니다.
     */
    @java.lang.Override
    public java.lang.String getTimestamp() {
        java.lang.Object ref = timestamp_; // timestamp_ 필드를 참조
        if (ref instanceof java.lang.String) {
            // 이미 문자열로 저장되어 있으면 바로 반환
            return (java.lang.String) ref;
        } else {
            // ByteString 타입으로 저장되어 있으면 문자열로 변환하여 반환
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8(); // UTF-8로 변환
            timestamp_ = s; // 변환된 문자열을 다시 timestamp_에 저장
            return s; // 전송 시간을 나타내는 문자열을 반환
        }
    }

    /**
     * <pre>
     * 메시지 전송 시간
     * </pre>
     *
     * <code>string timestamp = 3;</code>
     *
     * @return 메시지 전송 시간의 바이트 데이터를 반환합니다.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getTimestampBytes() {
        java.lang.Object ref = timestamp_; // timestamp_ 필드를 참조
        if (ref instanceof java.lang.String) {
            // 문자열로 저장되어 있으면 ByteString으로 변환하여 반환
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
            timestamp_ = b; // 변환된 ByteString 값을 다시 timestamp_에 저장
            return b; // ByteString 반환
        } else {
            // 이미 ByteString이면 그대로 반환
            return (com.google.protobuf.ByteString) ref;
        }
    }

    @java.lang.Override
    public boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;  // 초기화가 완료된 경우 true 반환
        if (isInitialized == 0) return false; // 초기화되지 않은 경우 false 반환

        memoizedIsInitialized = 1; // 초기화 완료 상태로 설정
        return true; // 객체가 초기화되었으므로 true 반환
    }

    // 'writeTo' 메소드는 객체를 직렬화하여 CodedOutputStream에 기록하는 메소드입니다.
// 직렬화는 데이터를 바이너리 형식으로 변환하여 저장하거나 전송하는 과정입니다.
    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        // sender_ 필드가 비어 있지 않으면 데이터를 직렬화하여 기록
        if (!com.google.protobuf.GeneratedMessage.isStringEmpty(sender_)) {
            com.google.protobuf.GeneratedMessage.writeString(output, 1, sender_);
        }
        // message_ 필드가 비어 있지 않으면 데이터를 직렬화하여 기록
        if (!com.google.protobuf.GeneratedMessage.isStringEmpty(message_)) {
            com.google.protobuf.GeneratedMessage.writeString(output, 2, message_);
        }
        // timestamp_ 필드가 비어 있지 않으면 데이터를 직렬화하여 기록
        if (!com.google.protobuf.GeneratedMessage.isStringEmpty(timestamp_)) {
            com.google.protobuf.GeneratedMessage.writeString(output, 3, timestamp_);
        }
        // 'getUnknownFields()'는 예상하지 못한 필드들을 처리하기 위해 사용됩니다.
        getUnknownFields().writeTo(output);  // 알 수 없는 필드를 직렬화하여 기록
    }

    // 'getSerializedSize' 메소드는 직렬화된 데이터의 크기를 반환하는 메소드입니다.
// 이 메소드는 데이터가 얼마나 많은 공간을 차지할지를 계산하여 반환합니다.
    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize; // memoizedSize는 직렬화된 데이터 크기를 저장합니다.
        if (size != -1) return size; // 이미 계산된 크기가 있으면 그 값을 반환

        size = 0;
        // sender_ 필드가 비어 있지 않으면 그 크기를 더합니다.
        if (!com.google.protobuf.GeneratedMessage.isStringEmpty(sender_)) {
            size += com.google.protobuf.GeneratedMessage.computeStringSize(1, sender_);
        }
        // message_ 필드가 비어 있지 않으면 그 크기를 더합니다.
        if (!com.google.protobuf.GeneratedMessage.isStringEmpty(message_)) {
            size += com.google.protobuf.GeneratedMessage.computeStringSize(2, message_);
        }
        // timestamp_ 필드가 비어 있지 않으면 그 크기를 더합니다.
        if (!com.google.protobuf.GeneratedMessage.isStringEmpty(timestamp_)) {
            size += com.google.protobuf.GeneratedMessage.computeStringSize(3, timestamp_);
        }
        size += getUnknownFields().getSerializedSize(); // 알 수 없는 필드의 크기를 더합니다.
        memoizedSize = size; // 계산된 크기를 저장
        return size; // 직렬화된 크기를 반환
    }

    // 'equals' 메소드는 두 객체가 동일한지 비교하는 메소드입니다.
// 이 메소드는 객체의 내용을 비교하여 같으면 true, 다르면 false를 반환합니다.
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) { // 객체가 동일하면 true 반환
            return true;
        }
        if (!(obj instanceof ChatMessage other)) { // 다른 타입이면 false 반환
            return super.equals(obj);
        }
        // 비교할 다른 객체를 ChatMessage로 변환

        // sender_, message_, timestamp_ 필드를 비교하여 같지 않으면 false 반환
        if (!getSender().equals(other.getSender())) return false;
        if (!getMessage().equals(other.getMessage())) return false;
        if (!getTimestamp().equals(other.getTimestamp())) return false;

        // 알 수 없는 필드까지 비교
        return getUnknownFields().equals(other.getUnknownFields());// 모든 필드가 같으면 true 반환
    }

    // 'hashCode()' 메소드는 객체의 해시 코드를 반환하는 메소드입니다.
// 해시 코드는 객체를 식별하기 위한 고유한 값이며, 객체를 HashMap 등의 컬렉션에 저장할 때 사용됩니다.
// 해시 코드를 계산할 때는 객체의 모든 중요한 필드를 포함시킵니다.
    @java.lang.Override
    public int hashCode() {
        // 이미 계산된 해시 코드가 있다면 그것을 반환 (최적화를 위해 메모이제이션 사용)
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }

        // 해시 코드의 초기값을 41로 설정
        int hash = 41;

        // 'getDescriptor()' 메소드를 호출하여 ChatMessage 객체의 설명(descriptor) 해시 코드를 추가
        hash = (19 * hash) + getDescriptor().hashCode();

        // 각 필드 번호와 그 필드의 값을 포함시켜 해시 값을 계산
        hash = (37 * hash) + SENDER_FIELD_NUMBER;
        hash = (53 * hash) + getSender().hashCode();
        hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getMessage().hashCode();
        hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
        hash = (53 * hash) + getTimestamp().hashCode();

        // 알 수 없는 필드까지 포함하여 해시 값 계산
        hash = (29 * hash) + getUnknownFields().hashCode();

        // 계산된 해시 값을 memoizedHashCode에 저장하여 재사용
        memoizedHashCode = hash;
        return hash; // 최종 계산된 해시 코드 반환
    }

    // 새로운 Builder 객체를 생성하여 반환하는 메소드입니다.
// Builder는 ChatMessage 객체를 생성할 때 필요한 값을 설정할 수 있도록 도와줍니다.
    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    // 현재 ChatMessage 객체를 바탕으로 새로운 Builder 객체를 생성하는 메소드입니다.
    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this); // 객체가 기본값이라면 새 Builder 생성, 아니면 병합
    }

    // 내부적으로 Builder를 생성하는 메소드로, 부모 객체를 받아서 새로운 Builder를 생성합니다.
    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        Builder builder = new Builder(parent); // 부모 객체를 받는 Builder 생성
        return builder; // 생성된 Builder 반환
    }

    /**
     * 'ChatMessage' 타입에 대한 Parser 객체를 반환합니다.
     *
     * @return The parser for the type of ChatMessage.
     */
    @java.lang.Override
    public com.google.protobuf.Parser<ChatMessage> getParserForType() {
        return PARSER;  // 'ChatMessage' 타입에 대한 Parser 객체 반환
    }

    /**
     * 'ChatMessage' 타입에 대한 기본 인스턴스를 반환합니다.
     *
     * @return The default instance of ChatMessage.
     */
    @java.lang.Override
    public ChatMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;  // 기본 인스턴스 반환
    }

    // Builder 클래스는 ChatMessage 객체를 빌드하는 데 사용됩니다.
// Builder는 ChatMessage 객체의 각 필드를 설정할 수 있게 해주는 메소드들을 포함하고 있습니다.
    public static final class Builder extends
            com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:com.example.grpc.chat.ChatMessage)
            ChatMessageOrBuilder {

        // 'bitField0_'는 필드가 설정되었는지 여부를 추적하는 비트 마스크입니다.
// 각 비트가 각 필드의 설정 여부를 나타냅니다.
        private int bitField0_;
        // 'sender_'는 발신자 정보를 저장하는 필드입니다.
// 기본 값은 빈 문자열로 설정됩니다.
        private java.lang.Object sender_ = "";
        private java.lang.Object message_ = "";  // 메시지 내용 필드, 기본 값은 빈 문자열
        private java.lang.Object timestamp_ = "";  // 메시지 전송 시간을 저장하는 필드, 기본 값은 빈 문자열

        // 'Builder'는 ChatMessage 객체를 생성하는 데 사용되는 도우미 클래스입니다.
// 이 클래스는 'ChatMessage' 객체의 필드를 설정할 수 있는 메소드들을 제공합니다.
        private Builder() {
            // 기본 생성자: 외부에서 호출할 수 없도록 제한되어 있음.
        }

        // 부모 클래스에서 생성자를 호출하여 'Builder' 객체를 초기화합니다.
// 부모 클래스는 주로 메시지 빌더에서 필요한 필드를 초기화합니다.
        private Builder(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            super(parent); // 부모 클래스의 생성자를 호출하여 초기화
        }

        // 'getDescriptor()' 메소드는 ChatMessage 객체의 정의(descriptor)를 반환합니다.
        // 이 메소드는 프로토콜 버퍼가 각 타입에 대해 생성한 메타데이터를 제공합니다.
        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return Chat.internal_static_chat_ChatMessage_descriptor; // ChatMessage의 descriptor 반환
        }

        // 이 메소드는 ChatMessage 객체의 필드를 다루는 내부 메소드입니다.
        @java.lang.Override
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Chat.internal_static_chat_ChatMessage_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            ChatMessage.class, ChatMessage.Builder.class); // 필드 접근자를 초기화하여 반환
        }

        // 'clear()' 메소드는 'Builder' 객체의 상태를 초기화합니다.
// 이 메소드를 호출하면 필드들이 기본 값으로 초기화됩니다.
        @java.lang.Override
        public Builder clear() {
            super.clear(); // 부모 클래스의 'clear()' 메소드 호출
            bitField0_ = 0; // 비트 필드를 초기화
            sender_ = ""; // sender 필드를 빈 문자열로 초기화
            message_ = ""; // message 필드를 빈 문자열로 초기화
            timestamp_ = ""; // timestamp 필드를 빈 문자열로 초기화
            return this; // 초기화된 Builder 객체 반환
        }

        // 'getDescriptorForType()' 메소드는 이 객체의 메타데이터인 'Descriptor'를 반환합니다.
// Descriptor는 프로토콜 버퍼 메시지 타입에 대한 정보를 포함하고 있습니다.
        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return Chat.internal_static_chat_ChatMessage_descriptor; // 'ChatMessage'의 Descriptor 반환
        }

        // 'getDefaultInstanceForType()' 메소드는 이 타입의 기본 인스턴스를 반환합니다.
// 기본 인스턴스는 필드가 모두 기본값으로 설정된 객체입니다.
        @java.lang.Override
        public ChatMessage getDefaultInstanceForType() {
            return ChatMessage.getDefaultInstance(); // 'ChatMessage'의 기본 인스턴스 반환
        }

        // 'build()' 메소드는 최종적으로 'ChatMessage' 객체를 생성합니다.
// 이 메소드는 'buildPartial()'을 호출하여 부분적으로 생성된 객체를 기반으로,
// 해당 객체가 초기화되지 않았다면 예외를 던집니다.
        @java.lang.Override
        public ChatMessage build() {
            ChatMessage result = buildPartial(); // 부분적으로 객체를 생성
            if (!result.isInitialized()) { // 객체가 초기화되지 않았다면 예외를 던짐
                throw newUninitializedMessageException(result); // 초기화되지 않은 객체에 대한 예외 처리
            }
            return result; // 완전한 객체 반환
        }

        // 'buildPartial()' 메소드는 필드들이 설정된 'ChatMessage' 객체를 반환합니다.
// 이 메소드는 객체가 완전히 초기화된 상태가 아닐 수 있으며, 이를 검증하지 않습니다.
        @java.lang.Override
        public ChatMessage buildPartial() {
            ChatMessage result = new ChatMessage(this); // 'ChatMessage' 객체 생성
            if (bitField0_ != 0) {
                buildPartial0(result);
            } // 일부 필드가 설정되었으면, 필드값을 설정
            onBuilt(); // 빌드 완료 후 후속 작업
            return result; // 부분적으로 생성된 객체 반환
        }

        // 필드가 설정된 객체를 반환하는 데 사용됩니다.
// 'bitField0_' 비트마스크에 의해 어떤 필드가 설정되었는지 체크하고,
// 해당 필드를 'ChatMessage' 객체에 설정합니다.
        private void buildPartial0(ChatMessage result) {
            int from_bitField0_ = bitField0_; // 비트마스크 저장
            if (((from_bitField0_ & 0x00000001) != 0)) {
                result.sender_ = sender_; // sender가 설정되었으면 'ChatMessage' 객체에 설정
            }
            if (((from_bitField0_ & 0x00000002) != 0)) {
                result.message_ = message_; // message가 설정되었으면 'ChatMessage' 객체에 설정
            }
            if (((from_bitField0_ & 0x00000004) != 0)) {
                result.timestamp_ = timestamp_; // timestamp가 설정되었으면 'ChatMessage' 객체에 설정
            }
        }

        // 'mergeFrom()' 메소드는 다른 메시지 객체로부터 데이터를 병합합니다.
// 다른 객체가 'ChatMessage' 타입이면 병합을 진행하고, 그렇지 않으면 부모 클래스의 'mergeFrom()'을 호출합니다.
        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof ChatMessage) {
                return mergeFrom((ChatMessage) other); // 'ChatMessage' 객체에서 병합
            } else {
                super.mergeFrom(other); // 다른 타입일 경우 부모 클래스의 병합 메소드 호출
                return this;
            }
        }

        // 'mergeFrom(ChatMessage other)'는 두 'ChatMessage' 객체의 필드를 병합합니다.
// 이미 설정된 값은 덮어씁니다.
        public Builder mergeFrom(ChatMessage other) {
            if (other == ChatMessage.getDefaultInstance()) return this; // 기본값이면 병합 안함
            if (!other.getSender().isEmpty()) {
                sender_ = other.sender_; // 'sender' 필드 병합
                bitField0_ |= 0x00000001; // 'sender' 필드가 설정됨을 표시
                onChanged(); // 변경 사항 반영
            }
            if (!other.getMessage().isEmpty()) {
                message_ = other.message_; // 'message' 필드 병합
                bitField0_ |= 0x00000002; // 'message' 필드가 설정됨을 표시
                onChanged(); // 변경 사항 반영
            }
            if (!other.getTimestamp().isEmpty()) {
                timestamp_ = other.timestamp_; // 'timestamp' 필드 병합
                bitField0_ |= 0x00000004; // 'timestamp' 필드가 설정됨을 표시
                onChanged(); // 변경 사항 반영
            }
            this.mergeUnknownFields(other.getUnknownFields()); // 알 수 없는 필드 병합
            onChanged(); // 변경 사항 반영
            return this; // Builder 반환
        }

        // 'isInitialized()' 메소드는 객체가 완전히 초기화되었는지 확인하는 메소드입니다.
// 여기서는 항상 true를 반환하며, 'ChatMessage' 객체가 항상 초기화된 상태임을 가정합니다.
        @java.lang.Override
        public boolean isInitialized() {
            return true; // 항상 true 반환
        }

        // 'mergeFrom()' 메소드는 CodedInputStream에서 데이터를 읽어 ChatMessage 객체를 병합합니다.
// 확장 레지스트리를 사용하여 확장된 필드도 처리합니다.
        @java.lang.Override
        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException(); // extensionRegistry가 null이면 예외 발생
            }
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag(); // 태그 읽기
                    switch (tag) {
                        case 0:
                            done = true; // 끝에 도달하면 종료
                            break;
                        case 10: {
                            sender_ = input.readStringRequireUtf8(); // sender 필드 읽기
                            bitField0_ |= 0x00000001; // sender 필드 설정 표시
                            break;
                        }
                        case 18: {
                            message_ = input.readStringRequireUtf8(); // message 필드 읽기
                            bitField0_ |= 0x00000002; // message 필드 설정 표시
                            break;
                        }
                        case 26: {
                            timestamp_ = input.readStringRequireUtf8(); // timestamp 필드 읽기
                            bitField0_ |= 0x00000004; // timestamp 필드 설정 표시
                            break;
                        }
                        default: {
                            if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                done = true; // 알 수 없는 태그일 경우 종료
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.unwrapIOException(); // 예외 처리
            } finally {
                onChanged(); // 변경 사항 반영
            }
            return this; // Builder 반환
        }

        /**
         * <pre>
         * 발신자
         * </pre>
         *
         * <code>string sender = 1;</code>
         *
         * @return The sender.
         */
        public java.lang.String getSender() {
            java.lang.Object ref = sender_;  // sender_ 필드 참조
            if (!(ref instanceof java.lang.String)) {  // 만약 sender_가 String이 아니라면
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;  // ByteString으로 변환
                java.lang.String s = bs.toStringUtf8();  // UTF-8로 변환하여 문자열 생성
                sender_ = s;  // 변환된 값을 sender_에 저장
                return s;  // 발신자 문자열 반환
            } else {
                return (java.lang.String) ref;  // 이미 String 타입이면 그대로 반환
            }
        }

        /**
         * <pre>
         * 발신자
         * </pre>
         *
         * <code>string sender = 1;</code>
         *
         * @param value The sender to set.
         * @return This builder for chaining.
         */
        public Builder setSender(java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }  // value가 null이면 예외 발생
            sender_ = value;  // sender_ 필드에 값 설정
            bitField0_ |= 0x00000001;  // 해당 비트 필드를 설정
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 발신자
         * </pre>
         *
         * <code>string sender = 1;</code>
         *
         * @return The bytes for sender.
         */
        public com.google.protobuf.ByteString getSenderBytes() {
            java.lang.Object ref = sender_;  // sender_ 필드 참조
            if (ref instanceof String) {  // 만약 sender_가 String이면
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);  // UTF-8로 ByteString 생성
                sender_ = b;  // ByteString을 sender_에 저장
                return b;  // ByteString 반환
            } else {
                return (com.google.protobuf.ByteString) ref;  // ByteString이 이미 설정되어 있으면 그대로 반환
            }
        }

        /**
         * <pre>
         * 발신자
         * </pre>
         *
         * <code>string sender = 1;</code>
         *
         * @param value The bytes for sender to set.
         * @return This builder for chaining.
         */
        public Builder setSenderBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }  // value가 null이면 예외 발생
            checkByteStringIsUtf8(value);  // ByteString이 UTF-8 형식인지 확인
            sender_ = value;  // sender_ 필드에 ByteString 값 설정
            bitField0_ |= 0x00000001;  // 해당 비트 필드를 설정
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 발신자
         * </pre>
         *
         * <code>string sender = 1;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearSender() {
            sender_ = getDefaultInstance().getSender();  // 기본값으로 sender_ 초기화
            bitField0_ = (bitField0_ & ~0x00000001);  // 해당 비트 필드 초기화
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 메시지 내용
         * </pre>
         *
         * <code>string message = 2;</code>
         *
         * @return The message.
         */
        public java.lang.String getMessage() {
            java.lang.Object ref = message_;  // message_ 필드 참조
            if (!(ref instanceof java.lang.String)) {  // 만약 message_가 String이 아니라면
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;  // ByteString으로 변환
                java.lang.String s = bs.toStringUtf8();  // UTF-8로 변환하여 문자열 생성
                message_ = s;  // 변환된 값을 message_에 저장
                return s;  // 메시지 문자열 반환
            } else {
                return (java.lang.String) ref;  // 이미 String 타입이면 그대로 반환
            }
        }

        /**
         * <pre>
         * 메시지 내용
         * </pre>
         *
         * <code>string message = 2;</code>
         *
         * @param value The message to set.
         * @return This builder for chaining.
         */
        public Builder setMessage(java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }  // value가 null이면 예외 발생
            message_ = value;  // message_ 필드에 값 설정
            bitField0_ |= 0x00000002;  // 해당 비트 필드를 설정
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 메시지 내용
         * </pre>
         *
         * <code>string message = 2;</code>
         *
         * @return The bytes for message.
         */
        public com.google.protobuf.ByteString getMessageBytes() {
            java.lang.Object ref = message_;  // message_ 필드 참조
            if (ref instanceof String) {  // 만약 message_가 String이면
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);  // UTF-8로 ByteString 생성
                message_ = b;  // ByteString을 message_에 저장
                return b;  // ByteString 반환
            } else {
                return (com.google.protobuf.ByteString) ref;  // ByteString이 이미 설정되어 있으면 그대로 반환
            }
        }

        /**
         * <pre>
         * 메시지 내용
         * </pre>
         *
         * <code>string message = 2;</code>
         *
         * @param value The bytes for message to set.
         * @return This builder for chaining.
         */
        public Builder setMessageBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }  // value가 null이면 예외 발생
            checkByteStringIsUtf8(value);  // ByteString이 UTF-8 형식인지 확인
            message_ = value;  // message_ 필드에 ByteString 값 설정
            bitField0_ |= 0x00000002;  // 해당 비트 필드를 설정
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 메시지 내용
         * </pre>
         *
         * <code>string message = 2;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearMessage() {
            message_ = getDefaultInstance().getMessage();  // 기본값으로 message_ 초기화
            bitField0_ = (bitField0_ & ~0x00000002);  // 해당 비트 필드 초기화
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 메시지 전송 시간
         * </pre>
         *
         * <code>string timestamp = 3;</code>
         *
         * @return The timestamp.
         */
        public java.lang.String getTimestamp() {
            java.lang.Object ref = timestamp_;  // timestamp_ 필드 참조
            if (!(ref instanceof java.lang.String)) {  // 만약 timestamp_가 String이 아니라면
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;  // ByteString으로 변환
                java.lang.String s = bs.toStringUtf8();  // UTF-8로 변환하여 문자열 생성
                timestamp_ = s;  // 변환된 값을 timestamp_에 저장
                return s;  // 타임스탬프 문자열 반환
            } else {
                return (java.lang.String) ref;  // 이미 String 타입이면 그대로 반환
            }
        }

        /**
         * <pre>
         * 메시지 전송 시간
         * </pre>
         *
         * <code>string timestamp = 3;</code>
         *
         * @param value The timestamp to set.
         * @return This builder for chaining.
         */
        public Builder setTimestamp(java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }  // value가 null이면 예외 발생
            timestamp_ = value;  // timestamp_ 필드에 값 설정
            bitField0_ |= 0x00000004;  // 해당 비트 필드를 설정
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 메시지 전송 시간
         * </pre>
         *
         * <code>string timestamp = 3;</code>
         *
         * @return The bytes for timestamp.
         */
        public com.google.protobuf.ByteString getTimestampBytes() {
            java.lang.Object ref = timestamp_;  // timestamp_ 필드를 참조
            if (ref instanceof String) {  // 만약 timestamp_가 String이면
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);  // UTF-8로 ByteString 생성
                timestamp_ = b;  // ByteString을 timestamp_에 저장
                return b;  // ByteString 반환
            } else {
                return (com.google.protobuf.ByteString) ref;  // timestamp_가 이미 ByteString이면 그대로 반환
            }
        }

        /**
         * <pre>
         * 메시지 전송 시간
         * </pre>
         *
         * <code>string timestamp = 3;</code>
         *
         * @param value The bytes for timestamp to set.
         * @return This builder for chaining.
         */
        public Builder setTimestampBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }  // value가 null이면 예외 발생
            checkByteStringIsUtf8(value);  // ByteString이 UTF-8 형식인지 확인
            timestamp_ = value;  // timestamp_ 필드에 ByteString 값 설정
            bitField0_ |= 0x00000004;  // 해당 비트 필드를 설정
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        /**
         * <pre>
         * 메시지 전송 시간
         * </pre>
         *
         * <code>string timestamp = 3;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearTimestamp() {
            timestamp_ = getDefaultInstance().getTimestamp();  // 기본값으로 timestamp_ 초기화
            bitField0_ = (bitField0_ & ~0x00000004);  // 해당 비트 필드를 초기화
            onChanged();  // 변경 사항 반영
            return this;  // Builder 객체 반환 (메소드 체이닝 가능)
        }

        // @@protoc_insertion_point(builder_scope:com.example.grpc.chat.ChatMessage)
// 'ChatMessage'의 빌더 범위를 나타내는 주석. 프로토콜 버퍼 컴파일러에서 추가되는 부분입니다.

    }
}

