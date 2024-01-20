package com.dollop.app.entity.payload.chat;

import java.time.LocalDateTime;

import com.dollop.app.entity.Users;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationRequest {

    private Integer senderId;
	private Integer recipientId;
	

}
