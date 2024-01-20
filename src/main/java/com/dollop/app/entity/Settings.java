package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Settings {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String settingName;

	private String settingValue;

	private Boolean deleted;
}

