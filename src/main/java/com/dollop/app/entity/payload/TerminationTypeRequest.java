package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.TerminationType;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TerminationTypeRequest {
	private Integer id;

	private String terminationType;
}
