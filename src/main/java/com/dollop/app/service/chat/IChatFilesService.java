package com.dollop.app.service.chat;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.payload.chat.ChatFileRequest;
import com.dollop.app.entity.payload.chat.ConversationRequest;

public interface IChatFilesService {
	
	public ResponseEntity<?> saveChatFile(ChatFileRequest request);

	public ResponseEntity<Resource> downloadFile(String destination, String serverFileName);

	public ResponseEntity<?> getProfileFiles(ConversationRequest request);
	

}
