package com.dollop.app.entity;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Assets {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="asset_user_id")
	private Users assetUser;
	
	private String assetName;
	
	private Boolean isDelete=false;
	
	private String assetWarrenty;
	
	private Long  amount;
	
	private String status;
	
	private Date purchaseDate;
	
	private Date purchaseFromDate;
	
	private String manufacturer;

   private String  model;
   
   private Long serialNumber;
   
   private String  supplier;
   
   @Column(name="asset_condition")
   private String condition;

   private String description;
}
