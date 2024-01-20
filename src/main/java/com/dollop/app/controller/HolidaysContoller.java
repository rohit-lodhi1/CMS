package com.dollop.app.controller;

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

import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.payload.employee.EmployeeDashboardResponse;
import com.dollop.app.service.IHolidaysService;

@RestController
@RequestMapping("/rise")
@CrossOrigin("*")
public class HolidaysContoller {
	@Autowired
	private IHolidaysService holidaysService;

	// add holiday
	@PostMapping("/admin/holidays")
	public ResponseEntity<Holidays> createHolidays(@RequestBody Holidays holidays) {
		return new ResponseEntity<Holidays>(this.holidaysService.addHolidays(holidays), HttpStatus.CREATED);
	}

	// update holiday
	@PutMapping("/admin/holidays")
	public ResponseEntity<Holidays> updaateHolidays(@RequestBody Holidays holidays) {
		Holidays updateholidays = this.holidaysService.updateHolidays(holidays);
		return ResponseEntity.ok(updateholidays);
	}

	// get holiday by id
	@GetMapping("/{id}")
	public ResponseEntity<Holidays> getHolidayById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.holidaysService.getHolidaysById(id));
	}

	// get All holidays
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<Holidays>> getAllHolidays(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		Page<Holidays> holidays = this.holidaysService.getAllHolidays(pageNo, pageSize);
		return new ResponseEntity<Page<Holidays>>(holidays, HttpStatus.OK);
	}

	// delete holiday by id
	@DeleteMapping("/admin/holidays/{id}")
	public ResponseEntity<Boolean> deleteHoliday(@PathVariable Integer id) {

		return new ResponseEntity<Boolean>(this.holidaysService.deleteHolidays(id), HttpStatus.ACCEPTED);
	}
	
	

	

}
