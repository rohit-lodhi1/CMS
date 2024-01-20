package com.dollop.app.serviceImpl.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.LeaveApplications;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.TasksRequest;
import com.dollop.app.entity.payload.TasksResponse;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.repository.TasksRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.ITasksService;
import com.dollop.app.serviceImpl.employee.EmployeeUsersServiceImpl;
import com.dollop.app.utils.PageResponse;

@Service
public class TasksServiceImpl implements ITasksService {
	@Autowired
	private TasksRepository tasksRepository;
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public UsersRepository usersRepository;
	
	@Autowired
	public ProjectRepository proRepository;

	public TasksResponse taskToTasksResponse(Tasks tasks) {
		return this.modelMapper.map(tasks, TasksResponse.class);
	}

	
	public Tasks taskRequestToTasks(TasksRequest taskRequest) {
		return this.modelMapper.map(taskRequest, Tasks.class);
	}

	@Override
	public TasksResponse addTasks(TasksRequest tasks) {
		Tasks task = this.tasksRepository.save(this.taskRequestToTasks(tasks));
		return this.taskToTasksResponse(task);

	}

	@Override
	public TasksResponse updateTasks(TasksRequest tasks) {
		Tasks task = this.tasksRepository.findById(tasks.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TASK_NOT_FOUND + tasks.getId()));
		task.setAssignedTo(task.getAssignedTo());
		task.setCollaborators(task.getCollaborators());
		task.setDeadline(task.getDeadline());
		task.setDeleted(task.getDeleted());
		task.setDescription(task.getDescription());
		task.setPoints(task.getPoints());
		task.setStartDate(task.getStartDate());
		task.setTitle(task.getTitle());
		task.setTasklabels(task.getTasklabels());
		return this.taskToTasksResponse(this.tasksRepository.save(task));
	}

	@Override
	public Boolean deleteTasks(Long id) {
		Tasks task = this.tasksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TASK_NOT_FOUND + id));
		task.setDeleted(true);
		this.tasksRepository.save(task);
		return true;
	}

	@Override
	public TasksResponse getTasksById(Long id) {
		Tasks task = this.tasksRepository.findByIdAndDeleted(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TASK_NOT_FOUND + id));
		return taskToTasksResponse(task);
	}

	@Override
	public List<TasksResponse> addMultipleTask(List<TasksRequest> task) {
		List<Tasks> list = new ArrayList<>();
		task.forEach(a -> {
			list.add(this.taskRequestToTasks(a));
		});
		
		List<Tasks> saved = this.tasksRepository.saveAll(list);
		
		return saved.stream().map(a -> this.taskToTasksResponse(a)).collect(Collectors.toList());

	}

	


	@Override
	public Page<TasksResponse> getAllTasks1(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<Tasks> task = this.tasksRepository.findAllByOrderByIdDesc(page);
		List<TasksResponse> list = task.getContent().stream().map(a -> this.taskToTasksResponse(a))
				.collect(Collectors.toList());
		return new PageResponse<>(list, task, list.size());
	}

	@Override
	public Page<TasksResponse> searchTasks(Integer pageNo, Integer pageSize, TasksRequest tasks) {
		// TODO Auto-generated method stub
		return null;
	}


	// get all tasks of project id
	@Override
	public Page<TasksResponse> getAllTasksProjectId(Integer pageNo, Integer pageSize, Integer projectId) {
		   Projects project = new Projects();
		   project.setId(projectId);
		   PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		   Page<Tasks> page = this.tasksRepository.findByProjectIdAndDeleted(pageRequest, project,false);
//		   List<TasksResponse> allTaskByUser = this.getAllTaskByUser("dollop5@gmail.com");
		  
		return page.map( t -> this.taskToTasksResponse(t));
	}

	@Override
	public Page<TasksResponse> getAllTasksProjectId(Integer pageNo, Integer pageSize, Integer projectId,String status) {
		   Projects project = new Projects();
		   project.setId(projectId);
		   PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		   Page<Tasks> page = this.tasksRepository.findByProjectIdAndDeletedAndStatus(pageRequest, project,false,status);
			return page.map( t -> this.taskToTasksResponse(t));
	}

	@Override
	public Boolean updateStatus(Long id, String status) {
		Tasks task = this.tasksRepository.findByIdAndDeleted(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TASK_NOT_FOUND + id));
		
		task.setStatus(status);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return this.tasksRepository.save(task)!=null?true:false; 
		}


	@Override
	public TasksResponse updateTasksAssigneToEmployee(Integer userId,Long taskId) {
		Users user = this.usersRepository.findByIdAndDeleted(userId,false).orElseThrow(()->new UserNotFoundException(AppConstants.USER_NOT_FOUND_+userId));
		Tasks task = this.tasksRepository.findByIdAndDeleted(taskId,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TASK_NOT_FOUND + taskId));
		task.setAssignedTo(user);
		return this.taskToTasksResponse(this.tasksRepository.save(task));
	}


	@Override
	public List<TasksResponse> getAllTaskByUser(String userEmail) {
		Users user=this.usersRepository.findByEmail(userEmail).orElseThrow(()->new ResourceNotFoundException(AppConstants.USER_NOT_FOUND_+userEmail));
		List<Tasks> findByDeletedAndAssignedToOrCollaborators = this.tasksRepository.findByDeletedAndAssignedToOrCollaborators( false,user,user);
		return findByDeletedAndAssignedToOrCollaborators.stream()
			    .map(ef -> this.taskToTasksResponse(ef))
			    .collect(Collectors.toList());
	}


	@Override
	public Page<TasksResponse> getAllTasksByProjectAndCurrentUser(Integer pageNo, Integer pageSize, Integer projectId,
			String currentUsersEmail) {
		 Projects project = new Projects();
		   project.setId(projectId);
		   
	  Users users=this.usersRepository.findByEmail(currentUsersEmail).orElseThrow(()->new ResourceNotFoundException(AppConstants.USER_NOT_FOUND_+currentUsersEmail));
			 PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
			 Page<Tasks> page = this.tasksRepository.findByProjectIdAndDeletedAndAssignedToOrCollaboratorsAndProjectIdAndDeleted(project,false,users,users,project,false,pageRequest);
				return page.map( t -> this.taskToTasksResponse(t));
			 
		
	}
	
	
	
	
	


	}
