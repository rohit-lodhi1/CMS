package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.TasksRequest;
import com.dollop.app.entity.payload.TasksResponse;

public interface ITasksService {

	public TasksResponse addTasks(TasksRequest tasks);

	public List<TasksResponse> addMultipleTask(List<TasksRequest> task);

	public TasksResponse updateTasks(TasksRequest tasks);
	
	public TasksResponse getTasksById(Long id);

	public Page<TasksResponse> getAllTasks1(Integer pageNo, Integer pageSize);

	public Boolean deleteTasks(Long id);
	public Boolean updateStatus(Long id,String status);
	
	

	
	public Page<TasksResponse> getAllTasksByProjectAndCurrentUser(Integer pageNo,Integer pageSize,Integer projectId,String currentUsersEmail);
	public Page<TasksResponse> getAllTasksProjectId(Integer pageNo,Integer pageSize,Integer projectId,String status);
	public Page<TasksResponse> getAllTasksProjectId(Integer pageNo,Integer pageSize,Integer projectId);

	public Page<TasksResponse> searchTasks(Integer pageNo, Integer pageSize, TasksRequest tasks);

	TasksResponse updateTasksAssigneToEmployee(Integer userId, Long taskId);
	
	public List<TasksResponse>getAllTaskByUser(String userEmail);
	

	
	
}
