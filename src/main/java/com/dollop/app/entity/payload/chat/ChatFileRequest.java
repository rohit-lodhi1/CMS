package com.dollop.app.entity.payload.chat;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatFileRequest {

	private MultipartFile chatFile;
	
	private Long messageId;
}
