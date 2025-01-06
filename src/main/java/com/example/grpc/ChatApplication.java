package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		// 서버를 모든 네트워크 인터페이스에서 접근할 수 있도록 설정
		//String serverAddress = "0.0.0.0"; // 0.0.0.0은 모든 IP에서 연결을 받겠다는 의미입니다.
		//ip는 크게 의미가 없는거 같은데 왜 넣은 걸까???
		int port = 50052; // 사용하고자 하는 포트

		// gRPC 서버 인스턴스 생성
		Server server = ServerBuilder.forPort(port) // 포트 50052에서 서버 실행
				.addService(new ChatServiceImpl()) // ChatService 구현체 등록
				.build();

		System.out.println("====================================================");
		System.out.println("메인서버 가동 " +  ":" + port + "...");
		System.out.println("====================================================");


		// 서버 시작
		server.start();

		// 서버가 종료되지 않도록 대기
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.err.println("gRPC서버 종료");
			server.shutdown();
		}));

		// 서버 종료 대기
		server.awaitTermination();
	}

}
