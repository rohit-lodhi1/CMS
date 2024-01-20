package com.dollop.app.controller.chat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.chat.ChatFiles;
import com.dollop.app.entity.chat.Message;
import com.dollop.app.entity.payload.chat.ChatFileResponse;
import com.dollop.app.entity.payload.chat.ConversationMessageHistoryResponse;
import com.dollop.app.entity.payload.chat.MarkAsSeen;
import com.dollop.app.entity.payload.chat.MarkAsSeenResponse;
import com.dollop.app.entity.payload.chat.MessageRequest;
import com.dollop.app.entity.payload.chat.UserStatusResponse;
import com.dollop.app.entity.payload.chat.UserStatusUpdateRequest;
import com.dollop.app.service.chat.IMessageService;
import com.dollop.app.service.chat.IUserActiveStatusService;

@RestController
@RequestMapping("/rise/chat")
public class ChatController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	private IMessageService messageService; 
	
	@Autowired
	private IUserActiveStatusService statusService;
	
	@MessageMapping("/chat")
	public ResponseEntity<?> sendMessage(@Payload MessageRequest message){
		 ConversationMessageHistoryResponse response = this.messageService.saveMessage(message);
		 // sending message to user
		 this.simpMessagingTemplate.convertAndSend(AppConstants.MESSAGE_TOPIC+message.getSender()+"/"+message.getRecipient(), response);
		 
		 // sending to public that someone send the recipient message so that if someone sends him he can check it
		 this.simpMessagingTemplate.convertAndSend(AppConstants.MESSAGE_PUBLIC+message.getRecipient(),"");
		 return new ResponseEntity<>(response,HttpStatus.OK); 
	}
	
	
	@MessageMapping("/status")
	public ResponseEntity<?> updateStatus(@Payload UserStatusUpdateRequest request){
		UserStatusResponse status = this.statusService.updateUserStatus(request);
		this.simpMessagingTemplate.convertAndSend(AppConstants.STATUS_TOPIC+"/"+request.getUserId(),status);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	
	@MessageMapping("/markAsSeen")
	public ResponseEntity<?> markMessagesAsSeen(@Payload MarkAsSeen markAsSeen){
		
		List<MarkAsSeenResponse> response = this.messageService.markAsSeen(markAsSeen);
		this.simpMessagingTemplate.convertAndSend(AppConstants.MARKS_AS_SEEN_TOPIC+markAsSeen.getRecipientId(),response);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@MessageMapping("/chat-files")
	public ResponseEntity<?> forward(MessageRequest request){
		System.err.println(request);
		
		
		 // sending to public that someone send the recipient message so that if someone sends him he can check it
		 this.simpMessagingTemplate.convertAndSend(AppConstants.MESSAGE_PUBLIC+request.getRecipient(),"");
		
		 ListIterator<ChatFileResponse> iterator = request.getChatFiles().listIterator();
		 List<ChatFileResponse> images  = new ArrayList<>();
		while(iterator.hasNext()) {
			ChatFileResponse f=  iterator.next();
			if(f.getFileName().endsWith(".jpg") || f.getFileName().endsWith(".png") ||f.getFileName().endsWith(".jpeg") ) {
				images.add(f);
				iterator.remove();
			}
		}
		if(images.size()>0)
			request.setImages(images);
		 
	      	this.simpMessagingTemplate.convertAndSend(AppConstants.MESSAGE_FILE_TOPIC+"/"+request.getSender()+"/"+request.getRecipient(),request);
	      	return null;
	}
	
	
}
