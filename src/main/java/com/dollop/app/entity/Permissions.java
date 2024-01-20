package com.dollop.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permissions {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private Boolean isReadable=true;
	
	private Boolean isWriteable=true;
	
	private Boolean isEditable=true;

	private Boolean isDeleteable=true;
	
	@ManyToOne
	@JoinColumn(name = "role_permissions")
	@JsonIgnoreProperties(value= {"permissions"})
	private Roles role;
	
@ManyToOne
@JoinColumn(name="module_permissions_id")
@JsonIgnoreProperties(value= {"permissions"})
private ModulePermissions modulePermissions;
}
