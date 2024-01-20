package com.dollop.app.service.chat;

import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.payload.chat.ConversationRequest;

public interface IConversationService {

	ResponseEntity<?> createConversation(ConversationRequest request);

	ResponseEntity<?> getConversationById(ConversationRequest request);

	ResponseEntity<?> getConversationUsersByUserId(String email);
}
