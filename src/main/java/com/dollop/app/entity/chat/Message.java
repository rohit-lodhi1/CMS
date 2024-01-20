package com.dollop.app.entity.chat;

import java.time.LocalDateTime;
import java.util.List;

import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "sender_id")
	private Users sender;

	@ManyToOne
	@JoinColumn(name = "recipient_id")
	private Users recipient;

	private String message;

	private String conversationId;

	private LocalDateTime isSeen;

	private Boolean isDeleted = false;

	private LocalDateTime sent;

	private LocalDateTime recieved;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_id")
	@JsonIgnoreProperties(value = { "message" })
	private List<ChatFiles> chatFiles;

	private Boolean isSenderDeleted = false;
	private Boolean isRecipientDeleted = false;

	@PrePersist
	public void setSentDate() {
		sent = LocalDateTime.now();
	}

}
