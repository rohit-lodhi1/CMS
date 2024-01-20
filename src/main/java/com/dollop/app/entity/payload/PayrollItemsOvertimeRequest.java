package com.dollop.app.entity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PayrollItemsOvertimeRequest {

	private Integer id;

	private String name;

	private String rateType;

	private Double rate;

	private Boolean isDelete;

}
