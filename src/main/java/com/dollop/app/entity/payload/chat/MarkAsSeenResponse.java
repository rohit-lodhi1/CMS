package com.dollop.app.entity.payload.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkAsSeenResponse {

	private Long messageId;
	
	private String isSeen;
}
