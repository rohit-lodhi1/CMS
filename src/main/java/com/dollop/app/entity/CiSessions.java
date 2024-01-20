package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CiSessions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	
	private String id;
	
	private String ipAddress;
	
	private Integer timestamp;
	
	private Integer data;
}
