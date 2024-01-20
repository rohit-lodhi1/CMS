package com.dollop.app.entity.payload;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExperienceInformationsRequest {

	private Integer id;

	private String companyName;

	private String location;

	private String jobPosition;

	private Date periodFrom;

	private Boolean isDelete;

	private Date periodTo;
}
