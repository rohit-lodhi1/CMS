package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Designation;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PromotionResponse {

	private Integer id;

	private Users employee;

	private Designation designationTo;

	private String designationFrom;

	private Date promotionDate;



	private Boolean isDeleted;

}
