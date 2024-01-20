package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmailTemplates {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer id;
	
	private String templateName;
	
	private String emailSubject;
	
	private String customMessage;
	
	private Boolean deleted;
	
}
