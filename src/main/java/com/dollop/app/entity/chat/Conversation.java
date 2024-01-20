package com.dollop.app.entity.chat;

import java.time.LocalDateTime;

import com.dollop.app.entity.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private Users sender;
	
	@ManyToOne
	@JoinColumn(name="recipient_id")
	private Users recipient;
	
	private Boolean isDeleted=false;
	
	private String conversationId;
	
	private LocalDateTime createdAt;
		
}
