package com.dollop.app.entity.payload;

import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.Users;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationRequest {
	private Integer id;
	private String title;

	private Department department;
	
	private List<Users> users;

	private Boolean isDeleted;
}
