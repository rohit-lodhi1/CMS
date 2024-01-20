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
public class NotificationSettings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String event;
	
	private String category;
	
	private Integer enableEmail;
	
	private Integer enableWeb;
	// colum text
	private String  notifyToTeam;
	// colum text
	private String notifyToTeamMembers;
	
	private Integer sort;
	
	private Boolean deleted;
}
