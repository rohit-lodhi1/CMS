package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Designation;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceIndicatorResponse {

	public Integer id;
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
	
	public Designation designation;
	
	private Boolean deleted;
	private Date createdAt ;
	
}
