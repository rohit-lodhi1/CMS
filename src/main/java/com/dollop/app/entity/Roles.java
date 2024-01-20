package com.dollop.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Roles {
	
	@Id
	private Integer id;
	
	private String title;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "role_permissions")
	@JsonIgnoreProperties(value = {"role","modulePermissions"})
	 private  List<Permissions> permissions;
	
	private Boolean deleted=false;

	public Roles(Integer id, String title, Boolean deleted) {
		super();
		this.id = id;
		this.title = title;
		this.deleted = deleted;
	}
	
	
}
