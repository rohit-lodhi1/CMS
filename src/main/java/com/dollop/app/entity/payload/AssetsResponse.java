package com.dollop.app.entity.payload;

import java.util.Date;
import java.util.List;

import com.dollop.app.entity.Users;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssetsResponse {

	private Long id;

	@ManyToOne
	private Users assetUser;
	
	private String assetName;
	
	private String assetWarrenty;
	
	private Long  amount;
	
	private String status;
	
	private Date purchaseDate;
	
	private Date purchaseFromDate;
	
	private String manufacturer;
	
	private Boolean isDelete=false;

   private String  model;
   
   private Long serialNumber;
   
   private String  supplier;
   
   private String condition;

   private String description;


}
