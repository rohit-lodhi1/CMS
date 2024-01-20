package com.dollop.app.entity.payload.chat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.dollop.app.entity.chat.ChatFiles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationMessageHistoryResponse {

	private Long id;
	
	private Integer sender;
	private Integer recipient;
	
	   private String message;
	
	private String conversationId;

	private String sent;

	private String recieved;
	@JsonIgnoreProperties(value= {"message"})
	private List<ChatFiles> chatFiles;
	
	@JsonIgnoreProperties(value="message")
	private List<ChatFiles> images;
	
	private String isSeen;

}
