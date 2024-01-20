package com.dollop.app.entity.payload.chat;

import java.time.LocalDateTime;

import com.dollop.app.entity.chat.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatFileResponse {
private Long id;
	
	private String fileName;
	
	private String serverFileName;
	
	private String fileSize;
	
	
	
	private Long messageId;
	
	private Boolean isDeleted=false;
	
	private LocalDateTime createdAt;
	
	private Integer senderId;
	private Integer recipientId;
}
