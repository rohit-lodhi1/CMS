package com.dollop.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.ExpensesRequest;
import com.dollop.app.entity.payload.ExpensesResponse;
import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;
import com.dollop.app.service.IExpensesService;

@RestController
@RequestMapping("/rise/hr/expenses")
@CrossOrigin("*")

public class ExpensesController {
	@Autowired
	private IExpensesService expensesService;

	@PostMapping(path = "/create", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<ExpensesResponse> createProject(
			@RequestPart(value = "files[]", required = false) List<MultipartFile> file,
			@RequestPart("data") ExpensesRequest expensesRequest) {
		
		
		return new ResponseEntity<ExpensesResponse>(this.expensesService.addExpenses(expensesRequest, file),
				HttpStatus.CREATED);

	}

	// update project
	@PutMapping("/")
	public ResponseEntity<ExpensesResponse> updateProject(@RequestPart(value = "files[]", required = false) List<MultipartFile> file,
														 @RequestPart("data") ExpensesRequest expensesRequest) {
		return new ResponseEntity<ExpensesResponse>(this.expensesService.updateExpense(expensesRequest,file),
				HttpStatus.CREATED);
	}


	// get all expenses
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ExpensesResponse>> getAllExpense(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		Page<ExpensesResponse> projects = this.expensesService.getAllExpenses(pageNo, pageSize);

		ResponseEntity<Page<ExpensesResponse>> response = new ResponseEntity<Page<ExpensesResponse>>(projects,
				HttpStatus.OK);
		return response;
	}

	// get expenses by id
	@GetMapping("/{id}")
	public ResponseEntity<ExpensesResponse> getExpenseById(@PathVariable Integer id) {
		return new ResponseEntity<ExpensesResponse>(this.expensesService.getExpensesById(id), HttpStatus.CREATED);
	}


	// update status by id
	@PutMapping("/status/{id}")
	public ResponseEntity<ExpensesResponse> updateExpenseStatus( @PathVariable Integer id,@RequestBody String status) {

		return new ResponseEntity<ExpensesResponse>(this.expensesService.updateExpensesStatus( id,status), HttpStatus.OK);
	}

	// delete project by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteExpenseById(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.expensesService.deleteExpenses(id), HttpStatus.ACCEPTED);
	}
	// filter searching
		@PostMapping("/search/{pageNo}/{pageSize}")
		public ResponseEntity<Page<ExpensesResponse>> searchExpenset(@PathVariable Integer pageNo,
				                                                   @PathVariable Integer pageSize, 
				                                                    @RequestBody ExpensesRequest expensesRequest) {
	Page<ExpensesResponse> goalList = this.expensesService.searchExpenses(pageNo, pageSize,expensesRequest );
			return new ResponseEntity<Page<ExpensesResponse>>(goalList, HttpStatus.OK);
		}
}
