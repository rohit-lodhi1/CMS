package com.dollop.app.service.admin;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Projects;
import com.dollop.app.entity.extrapayload.ProjectResponseList;
import com.dollop.app.entity.payload.TicketTypeRequest;
import com.dollop.app.entity.payload.TicketTypeResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;

public interface IProjectService {

	public  ProjectResponse projectToProjectResponse(Projects project);

	public  Projects projectRequestToProject(ProjectRequest projectRequest);
			
	public ProjectResponse addProject(ProjectRequest projectRequest,List<MultipartFile> multi,String email);
	
	public ProjectResponse updateProject(ProjectRequest projectRequest,List<MultipartFile> files);
	
	public ProjectResponse getProjectById(Integer id);
	
	public Page<ProjectResponse> getAllProjects(Integer pageNo,Integer pageSize);
	public Page<ProjectResponse> getAllProjectsByOrderBy();
	
	public Page<ProjectResponse> getAllProjectsByClientId(Integer pageNo,Integer pageSize,Integer id);
	
	
	public List<ProjectResponseList> getAllProjectsByCurrentUser(String email);
	
	
	public Boolean deleteProject(Integer id);
	
	public Page<ProjectResponse> getLeadsOfProjects(Integer pageNo,Integer pageSize);
	
	 public List<ProjectResponse> searchProjects(ProjectRequest projectRequest);

	public ResponseEntity<?> updateProjectStatus(Integer id, String status, String priority);
		
	
}
