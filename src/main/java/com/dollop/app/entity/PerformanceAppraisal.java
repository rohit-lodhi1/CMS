package com.dollop.app.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PerformanceAppraisal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public Date createdAt;
	
	public String customerExperience;
	
	public String marketing;
	
	public String management;
	
	public String administration;
	
	public String presentationSkill;
	
	public String qualityOfWork;
	
	public String efficiency;
	
	public String status;
	
	public String integrity;
	
	public String professionalism;
	
	public String teamWork;
	
	public String criticalThinking;
	
	public String conflictManagement;
	
	public String attendance;
	
	public String abilityToMeetDeadline;
	
	@OneToOne
	private Users user;
	
	private Boolean isDelete=false;
		
}
