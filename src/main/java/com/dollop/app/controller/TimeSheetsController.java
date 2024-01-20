package com.dollop.app.controller;

import java.security.Principal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.PromotionRequest;
import com.dollop.app.entity.payload.PromotionResponse;
import com.dollop.app.entity.payload.TimeSheetRequest;
import com.dollop.app.entity.payload.TimeSheetResponse;
import com.dollop.app.service.ITimesheetsService;

@RestController
@RequestMapping("/rise/employee/timesheets")
@CrossOrigin("*")
public class TimeSheetsController {
	@Autowired
	private ITimesheetsService timesheetsService;

	// createTimesheets
	@PostMapping("/")
	         public ResponseEntity<TimeSheetResponse> createtimesheets(@RequestBody TimeSheetRequest timeSheets,Principal p)  {
		     
				return new ResponseEntity<TimeSheetResponse>(this.timesheetsService.addTimeSheet(timeSheets,p.getName()), HttpStatus.CREATED);
			
			 }
	
	
	
	

	// updateTimeSheets
	@PutMapping("/")
	public ResponseEntity<TimeSheetResponse> updaateTimesheets(@RequestBody TimeSheetRequest timeSheets) {
		return new ResponseEntity<TimeSheetResponse>(timesheetsService.updateTimeSheet(timeSheets), HttpStatus.OK);
	}
	// getTimesheetsById

	@GetMapping("/{id}")
	public ResponseEntity<TimeSheetResponse> getTimeSheetById(@PathVariable Integer id) {
		return new ResponseEntity<>(timesheetsService.getTimeSheetBy(id), HttpStatus.OK);

	}

	// deleteTimeSheets
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTimeSheet(@PathVariable Integer id) {
		return new ResponseEntity<>(timesheetsService.deleteTimeSheet(id), HttpStatus.OK);
	}

	// getAllTimeSheets
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TimeSheetResponse>> getAllTimeSheet(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize) {
		Page<TimeSheetResponse> timesheet = this.timesheetsService.getAllTimeSheets(pageNo, pageSize);
		return new ResponseEntity<Page<TimeSheetResponse>>(timesheet, HttpStatus.OK);

	}

	// get TimeSheets by client id
	@GetMapping("/client/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<TimeSheetResponse>> getAllTimeSheetsByclients(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("id") Integer id) {
		Page<TimeSheetResponse> timeSheet = this.timesheetsService.getAllTimeSheetsByClientId(pageNo, pageSize, id);
		ResponseEntity<Page<TimeSheetResponse>> response = new ResponseEntity<Page<TimeSheetResponse>>(timeSheet,
				HttpStatus.OK);
		return response;}









	
	@GetMapping("/project/{pageNo}/{pageSize}/{id}")

	public ResponseEntity<Page<TimeSheetResponse>> getAllTimeSheetsByprojects(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("id") Integer id) {
		Page<TimeSheetResponse> timeSheet = this.timesheetsService.getAllTimeSheetsByProjectId(pageNo, pageSize, id);
		ResponseEntity<Page<TimeSheetResponse>> response = new ResponseEntity<Page<TimeSheetResponse>>(timeSheet,
				HttpStatus.OK);
		return response;
	}

	// get TimeSheets by task id
	@GetMapping("/task/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<TimeSheetResponse>> getAllTimeSheetsByTaskId(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("id") Long id) {
		Page<TimeSheetResponse> timeSheet = this.timesheetsService.getAllTimeSheetsByTaskId(pageNo, pageSize, id);
		ResponseEntity<Page<TimeSheetResponse>> response = new ResponseEntity<Page<TimeSheetResponse>>(timeSheet,
				HttpStatus.OK);
		return response;

	}

}
