package com.dollop.app.entity.payload.admin;

import java.util.List;

import com.dollop.app.entity.Permissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
private Integer id;
	
	private String title;
	
	 private  List<Permissions> permissions;
	
	private Boolean deleted;
}
