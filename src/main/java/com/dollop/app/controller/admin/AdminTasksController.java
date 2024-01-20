package com.dollop.app.controller.admin;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.TasksRequest;
import com.dollop.app.entity.payload.TasksResponse;
import com.dollop.app.service.ITasksService;

@RestController
@RequestMapping("/rise/admin/Tasks")
@CrossOrigin("*")
public class AdminTasksController {
	@Autowired
	private ITasksService iTasksService;

	// addtask
	@PostMapping("/")
	public ResponseEntity<TasksResponse> createTask(@RequestBody TasksRequest tasks) {
		TasksResponse task = this.iTasksService.addTasks(tasks);
		ResponseEntity<TasksResponse> response = new ResponseEntity<TasksResponse>(task, HttpStatus.CREATED);

		return response;
	}

	// DeleteTask
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {

		return new ResponseEntity<Boolean>(this.iTasksService.deleteTasks(id), HttpStatus.ACCEPTED);
	}

	// UpdateTask
	@PutMapping("/")

	public ResponseEntity<TasksResponse> updateTasks(@RequestBody TasksRequest tasksRequest) {
		TasksResponse task = this.iTasksService.updateTasks(tasksRequest);
		ResponseEntity<TasksResponse> response = new ResponseEntity<TasksResponse>(task, HttpStatus.OK);
		return response;

	}

	@GetMapping("/updateAssigneTo/{uId}/{tId}")
	public ResponseEntity<TasksResponse> updateTasksAssigneTo(@PathVariable Integer uId, @PathVariable Long tId) {
		TasksResponse task = this.iTasksService.updateTasksAssigneToEmployee(uId, tId);
		ResponseEntity<TasksResponse> response = new ResponseEntity<TasksResponse>(task, HttpStatus.FOUND);
		return response;

	}

	@GetMapping("/updateStatus/{id}/{status}")
	public ResponseEntity<Boolean> updateTasksStatus(@PathVariable Long id, @PathVariable String status) {
		this.iTasksService.updateStatus(id, status);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		return response;

	}

	// gettasksbyid
	@GetMapping("/{id}")
	public ResponseEntity<TasksResponse> getTaskByid(@PathVariable Long id) {
		TasksResponse task = this.iTasksService.getTasksById(id);
		ResponseEntity<TasksResponse> response = new ResponseEntity<TasksResponse>(task, HttpStatus.OK);
		return response;
	}

	// getAllTask
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TasksResponse>> getAllTasks1(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize) {
		Page<TasksResponse> task = this.iTasksService.getAllTasks1(pageNo, pageSize);
		return new ResponseEntity<Page<TasksResponse>>(task, HttpStatus.OK);
	}

	// AddMultipleTask
	@PostMapping("/multipletask")
	public ResponseEntity<List<TasksResponse>> addMultipleTask(@RequestBody List<TasksRequest> task) {
		ResponseEntity<List<TasksResponse>> resp = new ResponseEntity<List<TasksResponse>>(
				this.iTasksService.addMultipleTask(task), HttpStatus.OK);
		return resp;

	}

	// get all tasks by project id
	@GetMapping("/project/{pageNo}/{pageSize}/{projectId}")
	public ResponseEntity<Page<TasksResponse>> getAllTasksByProjectId(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @PathVariable Integer projectId) {
		ResponseEntity<Page<TasksResponse>> response = new ResponseEntity<Page<TasksResponse>>(
				this.iTasksService.getAllTasksProjectId(pageNo, pageSize, projectId), HttpStatus.OK);
		return response;
	}

	@GetMapping("/project/{pageNo}/{pageSize}/{projectId}/{status}")
	public ResponseEntity<Page<TasksResponse>> getAllTasksByProjectId(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @PathVariable Integer projectId, @PathVariable String status) {
		ResponseEntity<Page<TasksResponse>> response = new ResponseEntity<Page<TasksResponse>>(
				this.iTasksService.getAllTasksProjectId(pageNo, pageSize, projectId, status), HttpStatus.OK);
		return response;
	}

	@GetMapping("/task/{pageNo}/{pageSize}/{projectId}")
	public ResponseEntity<Page<TasksResponse>> getAllTaskByProjectAndAssignCollabrators(Principal p,@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @PathVariable Integer projectId) {

		ResponseEntity<Page<TasksResponse>> response = new ResponseEntity<Page<TasksResponse>>(
				this.iTasksService.getAllTasksByProjectAndCurrentUser(pageNo, pageSize, projectId, p.getName()),
				HttpStatus.OK);
		return response;

	}

}
