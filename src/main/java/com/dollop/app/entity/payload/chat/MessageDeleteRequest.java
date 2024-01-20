package com.dollop.app.entity.payload.chat;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDeleteRequest {

	private List<Long>  messageId;
	
	private Integer deletedById;
}
