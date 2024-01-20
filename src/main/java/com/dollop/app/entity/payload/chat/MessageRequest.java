package com.dollop.app.entity.payload.chat;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.chat.ChatFiles;
import com.dollop.app.entity.chat.Conversation;

import jakarta.mail.Multipart;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
	   
	   private Long messageId;
	
	    private Integer sender;
	 
		private Integer recipient;
		
	    private String message;
	    
	    private String sent;
	 
	    private String conversationId;
		
		private List<ChatFileResponse> chatFiles;
		
		private List<ChatFileResponse> images;
}
