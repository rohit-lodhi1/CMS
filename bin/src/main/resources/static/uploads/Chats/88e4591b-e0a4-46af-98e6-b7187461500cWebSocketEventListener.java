package com.socket.demo.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.socket.demo.entity.ChatMessage;
import com.socket.demo.entity.MessageType;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Data
public class WebSocketEventListener {

	
	private final SimpMessageSendingOperations messageTemplate;
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		
		  SimpMessageHeaderAccessor accessor = SimpMessageHeaderAccessor.wrap(event.getMessage());
		  String userName = (String)accessor.getSessionAttributes().get("username");	 
		  if(userName!=null) {
			  log.info("User Disconnected :{} ",userName);
			  ChatMessage message = new ChatMessage();
			  message.setType(MessageType.LEAVE);
			  message.setSender(userName);
			  message.setContent(userName);
			  messageTemplate.convertAndSend("/topic/public",message);
		  }
		  
	}
}
