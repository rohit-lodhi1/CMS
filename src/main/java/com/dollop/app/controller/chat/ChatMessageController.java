package com.dollop.app.controller.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.entity.payload.chat.MessageDeleteRequest;
import com.dollop.app.entity.payload.chat.MessageRequest;
import com.dollop.app.service.chat.IMessageService;

@RestController
@RequestMapping("/rise/chat/message")
@CrossOrigin("*")
public class ChatMessageController {

	@Autowired
	private IMessageService messageService;
	
	
	@PostMapping
	public ResponseEntity<?> saveMessage(@RequestBody MessageRequest request){
	  return new ResponseEntity<>(this.messageService.saveMessage(request),HttpStatus.OK);	
	}
	

	
	@GetMapping("/conversation")
	public ResponseEntity<?> getAllMessageByConversationIdId(@RequestParam("converId") String conversatonId){
		return this.messageService.getMessageByConversationById(conversatonId);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteMessages(@RequestBody MessageDeleteRequest request){
		return this.messageService.deleteMessage(request);
	}
 }
