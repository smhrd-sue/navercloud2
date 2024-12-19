package com.smhrd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@EnableWebSocket // 웹소켓 사용시작할 것이다.
@RequiredArgsConstructor
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

	private final WebSocketHandler handler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		// ws://localhost:8088/chat
		registry.addHandler(handler, "/chat/{room}")
				.setAllowedOrigins("*");
				// 외부 서버에서 연결을 허용
		
	}
	
	
	
	

}
