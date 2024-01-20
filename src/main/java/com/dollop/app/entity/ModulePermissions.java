package com.dollop.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModulePermissions {

	@Id

	private Integer id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="module_permissions_id")
	@JsonIgnoreProperties(value="modulePermissions")
	
	private List<Permissions> permissions;
}
