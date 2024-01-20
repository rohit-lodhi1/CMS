package com.dollop.app.controller.employee;

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

import com.dollop.app.entity.Comments;
import com.dollop.app.entity.payload.admin.CommentsRequest;
import com.dollop.app.entity.payload.admin.CommentsResponse;
import com.dollop.app.service.employee.IProjectCommentsService;

@RestController
@RequestMapping("/rise/employee/projectComments")
@CrossOrigin("*")
public class ProjectCommentsController {

	@Autowired
	private IProjectCommentsService commentsService;

	// add project comments
	@PostMapping(path = "/", consumes = { "multipart/form-data", "application/octet-stream" })

	public ResponseEntity<Comments> addProjectComments(
			@RequestPart(value = "files[]", required = false) List<MultipartFile> files,
			@RequestPart("data") CommentsRequest commentsRequest) {

		return new ResponseEntity<Comments>(this.commentsService.addComment(files, commentsRequest),
				HttpStatus.CREATED);
	}

	// update project comments
	@PutMapping("/")
	public ResponseEntity<CommentsResponse> updateProjectComments(@RequestBody CommentsRequest commentsRequest) {

		return new ResponseEntity<CommentsResponse>(this.commentsService.updateProjectComment(commentsRequest),
				HttpStatus.OK);
	}

	// get project comments by id
	@GetMapping("/{id}")
	public ResponseEntity<CommentsResponse> getProjectCommentsById(@PathVariable Long id) {

		return new ResponseEntity<CommentsResponse>(this.commentsService.getProjectCommentById(id), HttpStatus.OK);
	}

	// get project comments by project Id
	@GetMapping("/project/{pageNo}/{pageSize}/{projectId}")
	public ResponseEntity<Page<CommentsResponse>> getProjectCommentsByProjectsId(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("projectId") Integer projectId) {

		return new ResponseEntity<Page<CommentsResponse>>(
				this.commentsService.getProjectCommentsByProjectId(pageNo, pageSize, projectId), HttpStatus.OK);
	}

	// get project comments by task id
	@PostMapping("/project/{taskId}")
	public ResponseEntity<Page<CommentsResponse>> getProjectCommentsByTasksId(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("taskId") Long taskId) {

		return new ResponseEntity<Page<CommentsResponse>>(
				this.commentsService.getProjectCommentsByTaskId(pageNo, pageSize, taskId), HttpStatus.OK);
	}

	// delete project comments by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProjectCommentsById(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.commentsService.deleteProjectCommentById(id), HttpStatus.ACCEPTED);
	}

}
