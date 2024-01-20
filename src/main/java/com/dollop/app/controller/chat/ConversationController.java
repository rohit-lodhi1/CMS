package com.dollop.app.controller.chat;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.service.chat.IConversationService;

@RestController
@RequestMapping("/rise/chat/conversation")
@CrossOrigin("*")
public class ConversationController {

	@Autowired
	private IConversationService conversationService;
	
	@PostMapping
	public ResponseEntity<?> createConversation(@RequestBody ConversationRequest request){
		return conversationService.createConversation(request);
	}
	
	@PostMapping("/getId")
	public ResponseEntity<?> getConversationBySenderAndRecipient(@RequestBody ConversationRequest request){
		return conversationService.getConversationById(request);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getConversationUsers(Principal p){
		return conversationService.getConversationUsersByUserId(p.getName());
	}
}
