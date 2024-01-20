package com.dollop.app.entity.payload;

import java.util.List;

import com.dollop.app.entity.Designation;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {

	private Integer id;

	private String title;

	private String description;

	private List<Designation> designations;

	private Boolean isActive;

	private Boolean isDeleted;

}
