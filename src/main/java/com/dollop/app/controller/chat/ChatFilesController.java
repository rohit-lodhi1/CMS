package com.dollop.app.controller.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.chat.ChatFileRequest;
import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.service.chat.IChatFilesService;

@RestController
@RequestMapping("/rise/chat/files")
@CrossOrigin("*")
public class ChatFilesController {

	@Autowired
	private IChatFilesService filesService;
	
	@PostMapping
	public ResponseEntity<?> uploadChatFile(ChatFileRequest request){
		return this.filesService.saveChatFile(request);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<?> getProfileFiles(@RequestBody ConversationRequest request){
		return this.filesService.getProfileFiles(request);
	}
	
	
	@GetMapping("/download/{destination}/{serverFileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("destination") String destination,@PathVariable("serverFileName") String serverFileName){
		return this.filesService.downloadFile(destination,serverFileName);
	}
}
