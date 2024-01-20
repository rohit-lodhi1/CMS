package com.dollop.app.entity.payload.chat;

import com.dollop.app.entity.chat.UserActiveStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ConversationUserResponse {

	private String firstName;
	private String lastName;
	private String profileName;

	private UserStatusResponse status;
	
	private Integer unSeenMessageCount;

	private Integer id;
}
