package com.dollop.app.entity;


import java.util.Date;

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
public class ActivityLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Date createdAt;
	
	private Integer createdBy;
	// enum
   private String action;
   
   private String logType;
   
   private String logTypeTitle;
   
   private Integer logTypeId;
   
   private String changes;
   
   private String logFor;
   
   private Integer logForId;
   
   private String logFor2;
   
   private Integer logForId2;
   
   private Boolean deleted;
	
}
