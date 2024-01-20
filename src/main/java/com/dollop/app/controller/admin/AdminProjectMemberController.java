package com.dollop.app.controller.admin;

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

import com.dollop.app.entity.payload.admin.ProjectMemberRequest;
import com.dollop.app.entity.payload.admin.ProjectMemberResponse;
import com.dollop.app.service.admin.IProjectMembersService;

@RestController
@RequestMapping("/rise/admin/projectMembers")
@CrossOrigin("*")
public class AdminProjectMemberController {

	@Autowired
	private IProjectMembersService projectMembersService;

	// add project member
	@PostMapping("/")
	public ResponseEntity<List<ProjectMemberResponse>> addProjectMember(@RequestBody List<ProjectMemberRequest> memberRequest) {
		return new ResponseEntity<List<ProjectMemberResponse>>(this.projectMembersService.addProjectMember(memberRequest),
				HttpStatus.CREATED);
	}
	
	

	// update project member
	@PutMapping("/")
	public ResponseEntity<ProjectMemberResponse> updateProjectMember(@RequestBody ProjectMemberRequest memberRequest) {
		return new ResponseEntity<ProjectMemberResponse>(this.projectMembersService.updateProjectMember(memberRequest),
				HttpStatus.CREATED);
	}

	// get project member by id
	@GetMapping("/{id}")
	public ResponseEntity<ProjectMemberResponse> getProjectMemberById(@PathVariable Long id) {
		return new ResponseEntity<ProjectMemberResponse>(this.projectMembersService.getProjectMemberById(id),
				HttpStatus.CREATED);
	}
	
	// get all project members
		@GetMapping("/{pageNo}/{pageSize}")
		public ResponseEntity<Page<ProjectMemberResponse>> getAllProjectMembers(@PathVariable Integer pageNo,
																						@PathVariable Integer pageSize) {
			return new ResponseEntity<Page<ProjectMemberResponse>>(this.projectMembersService.getAllProjectMembers(pageNo, pageSize),
					HttpStatus.OK);
		}
	

	// get project members by project id
	@GetMapping("/project/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<ProjectMemberResponse>> getProjectMembersByProjectId(@PathVariable Integer pageNo,
																					@PathVariable Integer pageSize, 
																					@PathVariable Integer id) {
		return new ResponseEntity<Page<ProjectMemberResponse>>(this.projectMembersService.getProjectMemberByProjectId(pageNo, pageSize, id),
				HttpStatus.OK);
	}

	// get project members by project id
	@GetMapping("/user/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<ProjectMemberResponse>> getProjectMemberByUserId(@PathVariable Integer pageNo,
																				@PathVariable Integer pageSize,
																				@PathVariable Integer id) {
		return new ResponseEntity<Page<ProjectMemberResponse>>(this.projectMembersService.getProjectMemberByUserId(pageNo, pageSize, id),
				HttpStatus.OK);
	}
	
	// mark project member as leader
	@PutMapping("/leader")
	public ResponseEntity<ProjectMemberResponse> markProjectMemberLeader(@RequestBody ProjectMemberRequest memberRequest) {
		return new ResponseEntity<ProjectMemberResponse>(this.projectMembersService.makeLeader(memberRequest),
				HttpStatus.CREATED);
	}
	
	// delete Project member by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProjectMemberById(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.projectMembersService.deleteProjectMember(id),HttpStatus.ACCEPTED);
	}
	
}
