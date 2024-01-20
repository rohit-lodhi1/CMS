package com.dollop.app.entity.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TerminationTypeResponse {
	private Integer id;

	private String terminationType;
}
