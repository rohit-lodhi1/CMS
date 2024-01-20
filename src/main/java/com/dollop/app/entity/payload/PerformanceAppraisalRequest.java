package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceAppraisalRequest {
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
	private Users user;
	private Boolean isDelete=false;
	
}
