package com.dollop.app.controller.admin;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.ManageJobsResponse;
import com.dollop.app.entity.payload.PerformanceAppraisalRequest;
import com.dollop.app.entity.payload.PerformanceAppraisalResponse;
import com.dollop.app.entity.payload.TrainingListResponse;
import com.dollop.app.service.admin.IPerformanceAppraisalService;

@RequestMapping("/rise/admin/performanceApprisal")
@RestController
@CrossOrigin("*")
public class PerformanceAppraisalController {

	@Autowired

	private IPerformanceAppraisalService performanceAppraisalService;

	@PostMapping("/create")

	public ResponseEntity<PerformanceAppraisalResponse> createPerormanceAppraisal(
			@RequestBody PerformanceAppraisalRequest performanceAppraisalRequest) {
		return new ResponseEntity<PerformanceAppraisalResponse>(
				this.performanceAppraisalService.createPerformanceAppraisal(performanceAppraisalRequest),
				HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<PerformanceAppraisalResponse> updatePerformanceAppraisal(
			@RequestBody PerformanceAppraisalRequest performanceAppraisalRequest) {
		return new ResponseEntity<PerformanceAppraisalResponse>(
				this.performanceAppraisalService.updatePerformanceAppraisal(performanceAppraisalRequest),
				HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PerformanceAppraisalResponse> getPerformanceAppraisalById(@PathVariable Integer id) {
		return new ResponseEntity<PerformanceAppraisalResponse>(
				this.performanceAppraisalService.getPerformanceAppraisalById(id), HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deletePerformanceAppraisal(@PathVariable Integer id) {
		this.performanceAppraisalService.deletePerformanceApprisal(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);

	}
	@GetMapping("/getall/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PerformanceAppraisalResponse>> getAllPerformanceAppraisal(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize) {
		return new ResponseEntity<Page<PerformanceAppraisalResponse>>(
				this.performanceAppraisalService.getAllPerformanceApraisal(pageNo, pageSize), HttpStatus.OK);
	}
	
	
	@GetMapping("/status/{status}/{id}")
	public ResponseEntity<PerformanceAppraisalResponse> updatePerformanceAppraisalStatus(@PathVariable Integer id,
			                                                        @PathVariable String status) {
		PerformanceAppraisalResponse training = this.performanceAppraisalService.getPerformanceAppraisalByStatus(id, status);
		return new ResponseEntity<PerformanceAppraisalResponse>(training, HttpStatus.OK);
	}
	 
		

}
