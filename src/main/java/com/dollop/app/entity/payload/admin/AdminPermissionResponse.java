package com.dollop.app.entity.payload.admin;

import com.dollop.app.entity.Roles;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPermissionResponse {

private Integer id;
	
	private String title;
	
	private Boolean isReadable=true;
	
	private Boolean isWriteable=true;
	
	private Boolean isEditable=true;

	private Boolean isDeleteable=true;
	

	private Roles role;
}
