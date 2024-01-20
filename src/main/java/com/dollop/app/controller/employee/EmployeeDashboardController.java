package com.dollop.app.controller.employee;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dollop.app.entity.payload.employee.EmployeeDashboardResponse;
import com.dollop.app.service.employee.IEmployeeDashboardService;

@RestController
@RequestMapping("/rise/employee/dashboard")
@CrossOrigin("*")

public class EmployeeDashboardController {
	
	
	
	@Autowired
	private IEmployeeDashboardService employeeDashboardService;
	
	@GetMapping("/details")
	public ResponseEntity<EmployeeDashboardResponse> fetchDetails(Principal p,@RequestParam(value="status",defaultValue = "Pending") String status){
		return new ResponseEntity<EmployeeDashboardResponse>(this.employeeDashboardService.fetchDetails(p.getName(),status),HttpStatus.OK);
	}
	
	
	
	


}
