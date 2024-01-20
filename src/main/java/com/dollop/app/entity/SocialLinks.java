package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SocialLinks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    @OneToOne
	private Users userId;

	private String facebook;

	private String twitter;

	private String linkedin;

	private String googleplus;

	private String digg;

	private String youtube;

	private String pinterest;

	private String instagram;

	private String github;

	private String tumblr;

	private String vine;

	private Boolean deleted;
}