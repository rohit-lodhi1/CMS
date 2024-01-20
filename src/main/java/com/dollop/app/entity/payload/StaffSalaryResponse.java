package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StaffSalaryResponse {
	private Integer id;
	
	
	private Users staff;
	
	private Double payslip;
	
	private Long basicStaffSalary;
	
	private Double netSalary;
	
	private Integer da;
	
	private Integer hra;
	
	private Integer allowance;
	
	private Integer conveyance;
	
	private Integer medicalAllowance;
	
	private Integer others;

	private Integer others1;
	
	
	private Integer tds;
	
	private Integer esi;
	
	private Integer pf;
	
	private Integer staffLeave;

	private Integer profTax;
	
	private Integer labourWelfare;
	
	private Boolean isDeleted;

}
