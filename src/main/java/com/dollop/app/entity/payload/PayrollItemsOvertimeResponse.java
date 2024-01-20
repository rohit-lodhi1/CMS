package com.dollop.app.entity.payload;

import java.util.Date;

import com.dollop.app.entity.Users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayrollItemsOvertimeResponse {
private Integer id;

	private String name;

	private String rateType;

	private Double rate;

	private Boolean isDelete;

}
