package com.dollop.app.entity.payload.admin;

import java.util.List;

import com.dollop.app.entity.Permissions;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModulePermissionResponse {
	private Integer id;

	private String name;

	private List<Permissions> permissions;
}
