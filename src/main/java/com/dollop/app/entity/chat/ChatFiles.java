package com.dollop.app.entity.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatFiles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fileName;
	
	private String serverFileName;
	
	private String fileSize;
	
	@ManyToOne
	@JoinColumn(name="message_id")
	@JsonIgnoreProperties(value= {"chatFiles"})
	private Message message;
	
	private Boolean isDeleted=false;
	
}
