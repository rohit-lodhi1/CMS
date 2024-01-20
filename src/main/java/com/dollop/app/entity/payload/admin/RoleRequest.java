package com.dollop.app.entity.payload.admin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
	
    private Integer id;
	
	private String title;
	
	
	private Boolean deleted;
}
