package com.dollop.app.service.chat;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.payload.chat.ConversationMessageHistoryResponse;
import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.entity.payload.chat.MarkAsSeen;
import com.dollop.app.entity.payload.chat.MarkAsSeenResponse;
import com.dollop.app.entity.payload.chat.MessageDeleteRequest;
import com.dollop.app.entity.payload.chat.MessageRequest;

public interface IMessageService {

	ConversationMessageHistoryResponse saveMessage(MessageRequest request);

	ResponseEntity<?> getMessageByConversationById(String conversationId);

	ResponseEntity<?> updateMessage(MessageRequest request);

	List<MarkAsSeenResponse> markAsSeen(MarkAsSeen markAsSeen);

	ResponseEntity<?> deleteMessage(MessageDeleteRequest request);

}
