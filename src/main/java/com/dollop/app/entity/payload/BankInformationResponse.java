package com.dollop.app.entity.payload;

import com.dollop.app.entity.Users;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class BankInformationResponse {

	private Integer id;
	
	private String bankName;
	
	private Long bankAccountNo;
	
	private String ifscCode;
	
	private String panNo;
	
	private Boolean isDelete;
	
	private Integer userId ;
}
