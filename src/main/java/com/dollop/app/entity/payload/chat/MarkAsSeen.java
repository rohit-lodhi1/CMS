package com.dollop.app.entity.payload.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkAsSeen {

	private Integer senderId;
	private Integer recipientId;
}
