package com.dollop.app.entity;

import java.sql.Date;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PerformanceIndicator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String customerExperience;
	private String marketing;
	private String management;
	private String administration;
	private String presentationSkill;
	private String qualityOfWork;
	private String efficiency;
	private String status;
	private String integrity;
	private String professionalism;
	private String teamWork;
	private String criticalThinking;
	private String conflictManagement;
	private String attendance;
	private String abilityToMeetDeadline;
	@ManyToOne
	@JsonIgnoreProperties(value= {"performanceIndicator"})
	private Designation designation;
	
	private Boolean deleted=false;
	private Date createdAt ;
	
}
