package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PayrollItemsAdditionsResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	private String name;
	
	private String category ;
	
	private Boolean unitCalculation;
	
	private Double unitAmount;
	
	private Boolean isDelete;
	

}
