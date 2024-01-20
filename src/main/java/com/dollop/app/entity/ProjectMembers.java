package com.dollop.app.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectMembers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="project_id_id")
	@JsonIgnoreProperties(value={"projectMembers"})
	private Projects projectId;
	
	@ManyToOne
	private Users userId;
	
	private Boolean isLeader;
	 
	private Boolean deleted=false;

	public ProjectMembers(Long id, Users userId, Boolean isLeader, Boolean deleted) {
		super();
		this.id = id;
		this.userId = userId;
		this.isLeader = isLeader;
		this.deleted = deleted;
	}
	 
}