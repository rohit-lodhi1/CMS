package com.dollop.app.entity.payload.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusUpdateRequest {

	private Integer userId;
	
	private String  status;
	
}
