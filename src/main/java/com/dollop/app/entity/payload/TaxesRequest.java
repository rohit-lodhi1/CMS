package com.dollop.app.entity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TaxesRequest {

	private Integer id;

	private String title;

	private Double percentage;

	private Boolean deleted;
	
	private String status;
}
