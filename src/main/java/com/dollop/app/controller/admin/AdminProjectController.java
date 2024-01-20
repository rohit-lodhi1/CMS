package com.dollop.app.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.extrapayload.ProjectResponseList;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.ManageJobsResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;
import com.dollop.app.service.admin.IProjectService;

@RestController
@RequestMapping("/rise/admin/projects")
@CrossOrigin("*")
public class AdminProjectController {

	@Autowired
	private IProjectService projectService;

	@PostMapping(path = "/create", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<ProjectResponse> createProject(
			@RequestPart(value = "files[]", required = false) List<MultipartFile> file,
			@RequestPart("data") ProjectRequest projectRequest, Principal p) {

		return new ResponseEntity<ProjectResponse>(this.projectService.addProject(projectRequest, file, p.getName()),
				HttpStatus.CREATED);

	}

	// update project
	@PutMapping("/")
	public ResponseEntity<ProjectResponse> updateProject(
			@RequestPart(value = "files[]", required = false) List<MultipartFile> file,
			@RequestPart("data") ProjectRequest projectRequest) {
		return new ResponseEntity<ProjectResponse>(this.projectService.updateProject(projectRequest, file),
				HttpStatus.CREATED);
	}

	// get all project
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ProjectResponse>> getAllProjects(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		Page<ProjectResponse> projects = this.projectService.getAllProjects(pageNo, pageSize);

		ResponseEntity<Page<ProjectResponse>> response = new ResponseEntity<Page<ProjectResponse>>(projects,
				HttpStatus.OK);
		return response;
	}

	// get all project
	@GetMapping("/assignedProjects")
	public ResponseEntity<List<ProjectResponseList>> getAllProjects(Principal p) {
		List<ProjectResponseList> projects = this.projectService.getAllProjectsByCurrentUser(p.getName());

		ResponseEntity<List<ProjectResponseList>> response = new ResponseEntity<List<ProjectResponseList>>(projects,
				HttpStatus.OK);
		return response;
	}

	// get all project For DashBoard by Order
	@GetMapping("/order")
	public ResponseEntity<Page<ProjectResponse>> getAllProjectsOrderByDate() {
		Page<ProjectResponse> projects = this.projectService.getAllProjectsByOrderBy();
		ResponseEntity<Page<ProjectResponse>> response = new ResponseEntity<Page<ProjectResponse>>(projects,
				HttpStatus.OK);
		return response;
	}

	// get project by id
	@GetMapping("/{id}")
	public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Integer id) {
		return new ResponseEntity<ProjectResponse>(this.projectService.getProjectById(id), HttpStatus.CREATED);
	}

	// get project by client id
	@GetMapping("/client/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<ProjectResponse>> getProjectByClientId(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @PathVariable Integer id) {
		return new ResponseEntity<Page<ProjectResponse>>(
				this.projectService.getAllProjectsByClientId(pageNo, pageSize, id), HttpStatus.OK);
	}

	// update status by id
	@PutMapping("/update")
	public ResponseEntity<?> updatePriorityAndStatus(@RequestParam("id")Integer id,@RequestParam("status")String status ,@RequestParam("priority")String priority) {
		return this.projectService.updateProjectStatus(id,status,priority);
	}

	// delete project by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProjectById(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.projectService.deleteProject(id), HttpStatus.ACCEPTED);
	}

	// filter assets
	@PostMapping("/search")
	public ResponseEntity<List<ProjectResponse>> searchProject(@RequestBody ProjectRequest projectRequest) {
		return new ResponseEntity<List<ProjectResponse>>(this.projectService.searchProjects(projectRequest),
				HttpStatus.OK);

	}

}
