package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Users;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssetsRequest {

	private Long id;

	
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
   
   private String condition;

   private String description;

	
}
