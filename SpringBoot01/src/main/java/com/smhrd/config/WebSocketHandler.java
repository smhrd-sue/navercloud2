package com.smhrd.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// WebSocket에서 일어나는 동작들을 정의하는 파일
// 이 클래스가 Bean으로 등록이 되어져야한다.
@Component
public class WebSocketHandler extends TextWebSocketHandler {
	
	// 사용자의 정보를 저장할 ArrayList
	// HashMap 자료구조
	// >> Dict 유사
	// >> key - value 데이터를 저장하는 구조
	// >> key, value 자료형 처음 한번만 정의, 변하지 X
	private static HashMap<String , List<WebSocketSession> > users
				= new HashMap<String, List<WebSocketSession>>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 사용자가 Socket에 연결된 직후에 실행되는 메소드
		
		// ex) 요청에서 path variable 꺼내기
		String uri = session.getUri().toString();
		String pathVariable = uri.split("/chat/")[1];
		
		if( users.get(pathVariable) == null ) {
			users.put( pathVariable, new ArrayList<WebSocketSession>() );
		}
		
		List<WebSocketSession> list = users.get(pathVariable);
		
		// 사용자의 정보를 저장
		list.add(session);	
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 사용자가 Socket과의 연결을 끊으면 실행되는 메소드
		
		// ex) 요청에서 path variable 꺼내기
		String uri = session.getUri().toString();
		String pathVariable = uri.split("/chat/")[1];
		
		List<WebSocketSession> list = users.get(pathVariable);
		
		// list에서 사용자 정보를 삭제
		list.remove( session );
	}
	
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// ex) 요청에서 path variable 꺼내기
		String uri = session.getUri().toString();
		String pathVariable = uri.split("/chat/")[1];
		
		List<WebSocketSession> list = users.get(pathVariable);
		
		
		// 사용자가 보낸 메세지가 도착했을 때 실행되는 메소드
		// (Socket이 메세지를 받았을 때)
		System.out.println( message.getPayload() ); // 사용자가 보낸 메세지 가져오기
		
		// String json --> DTO (Gson)
		String json = (String) message.getPayload();
		
		// DB에 저장
		
		
		
		// 접속한 사용자들에게 메세지를 전달
		for( WebSocketSession user  : list ) {
			if( ! user.equals(session) ) {
				// 메세지 전송
				user.sendMessage(message);
			}
		}
		
	
	}
	
	
	
	

}
