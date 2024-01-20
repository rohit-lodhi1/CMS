package com.dollop.app.entity.payload.chat;

import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ConversationResponse {

	private Integer id;
	
	private String conversationId;
	
   private ConversationUserResponse user;

//	private Users you;
//
//	private Users they;

}
