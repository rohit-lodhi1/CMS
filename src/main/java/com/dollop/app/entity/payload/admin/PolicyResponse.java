package com.dollop.app.entity.payload.admin;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.PolicyFiles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponse {
private Integer id;
	
	private String name;
	
	private Department	department;
	
	private String description ;

	private Date createdAt;
	
	private boolean isDeleted;
    @JsonIgnoreProperties(value= {"policy"})
	private List<PolicyFiles> files;
}
