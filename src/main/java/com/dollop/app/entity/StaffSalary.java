package com.dollop.app.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class StaffSalary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	
	private Users staff;
	
	private Double netSalary;
	
	private Double payslip;
	

	private Long basicStaffSalary;

	private Integer da;

	private Integer esi;
	private Integer hra;

	private Integer conveyance;
	
	private Integer allowance;

	private Integer medicalAllowance;
	private Integer labourWelfare;

	private Integer others;

	private Integer others1;

	private Integer tds;

	private Integer pf;

	private Integer profTax;

	private Integer staffLeave;
	
	private Boolean isDeleted;
	private Date paymentDate;
	
	@PrePersist
	public void paymentDate() {
		this.paymentDate = new Date(System.currentTimeMillis());		
	}
		
	}


