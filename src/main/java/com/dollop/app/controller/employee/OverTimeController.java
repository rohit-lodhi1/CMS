  package com.dollop.app.controller.employee;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

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

import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.OverTimeRequest;
import com.dollop.app.entity.payload.OverTimeresponse;
import com.dollop.app.service.IOverTimeService;

@RestController
@RequestMapping("/rise/employee/overtime")
@CrossOrigin("*")
public class OverTimeController {

	@Autowired
	private IOverTimeService iOverTimeService;

	// create overtime
	@PostMapping("/")
	public ResponseEntity<OverTimeresponse> createOverTime(@RequestBody OverTimeRequest overTimeRequest) {

		OverTimeresponse overTimeresponse = this.iOverTimeService.createOverTime(overTimeRequest);
		ResponseEntity<OverTimeresponse> response = new ResponseEntity<OverTimeresponse>(overTimeresponse,
				HttpStatus.CREATED);
		return response;
	}

	// update overtime
	@PutMapping("/")
	public ResponseEntity<OverTimeresponse> updateOverTime(@RequestBody OverTimeRequest overTimeRequest) {

		OverTimeresponse overTimeresponse = this.iOverTimeService.updateOverTime(overTimeRequest);
		ResponseEntity<OverTimeresponse> response = new ResponseEntity<OverTimeresponse>(overTimeresponse,
				HttpStatus.OK);
		return response;
	}

	// get overtime by id
	@GetMapping("/{id}")
	public ResponseEntity<OverTimeresponse> getOverTimeByID(@PathVariable Integer id) {

		OverTimeresponse overTimeresponse = this.iOverTimeService.getOverTimeById(id);
		ResponseEntity<OverTimeresponse> response = new ResponseEntity<OverTimeresponse>(overTimeresponse,
				HttpStatus.OK);
		return response;
	}

	// get by overtime id
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<OverTimeresponse>> getAllOverTimePagination(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		Page<OverTimeresponse> leaves = this.iOverTimeService.getAllOverTime(pageNo, pageSize);
		ResponseEntity<Page<OverTimeresponse>> response = new ResponseEntity<Page<OverTimeresponse>>(leaves,
				HttpStatus.OK);
		return response;
	}

	// delete overtime
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> softDeleteOverTime(@PathVariable Integer id) {
//System.out.println(id);
		this.iOverTimeService.deleteOvertime(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<OverTimeresponse>> searchLeaveApplication(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @RequestBody OverTimeRequest overTimeRequest) {
		Page<OverTimeresponse> leaves = this.iOverTimeService.searchOverTime(pageNo, pageSize, overTimeRequest);
		ResponseEntity<Page<OverTimeresponse>> response = new ResponseEntity<Page<OverTimeresponse>>(leaves,
				HttpStatus.OK);
		return response;
	}
	

    @GetMapping("/total-worked-hours")
    public ResponseEntity<Map<String, Object>> getTotalWorkedHoursBetweenDates(){
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    	   LocalDate currentDate = LocalDate.now();
    	   YearMonth yearMonthObject = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
           int lastDayOfMonth = yearMonthObject.lengthOfMonth();
          
      
      
        Object summary = iOverTimeService.getTotalOverTimeHours( currentDate.withDayOfMonth(1),  currentDate.withDayOfMonth(lastDayOfMonth));
        Map<String, Object> response = new HashMap<>();
        response.put("summary", summary);
        return ResponseEntity.ok(response);
  }
    
    
 // update update status by id
 	@GetMapping("/status/{status}/{id}")
 	public ResponseEntity<OverTimeresponse> updateOverTimeStatus(@PathVariable Integer id,
 			                                                        @PathVariable String status) {
 		OverTimeresponse updateStatus = this.iOverTimeService.OverTimeStatus(id, status);
 		return new ResponseEntity<OverTimeresponse>(updateStatus, HttpStatus.OK);
 	}
 	
    
    
    
}
