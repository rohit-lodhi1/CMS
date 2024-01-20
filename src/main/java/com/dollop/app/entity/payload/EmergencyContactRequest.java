package com.dollop.app.entity.payload;

import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.Users;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmergencyContactRequest {
	
private Integer id;
	
	private String name;
	
	private String name1;
	
	private String relationship;
	
	private String relationship1;
	
	private String phone;
	
	private Boolean isDelete;
	private String phone1;
	
	private String phone2;
	
	private String Phone3;
	
	private Integer userId ;
	


}
