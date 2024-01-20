package com.dollop.app.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.service.admin.IProjectFilesService;
import com.dollop.app.service.admin.ITicketsService;

@RestController
@RequestMapping("/rise/admin/projectFiles")
@CrossOrigin("*")
public class AdminProjectFileController {

	@Autowired
	private IProjectFilesService filesService;

	@Autowired
	private ITicketsService ticketsService;

	// add project file with project id and uploaded by
	@PostMapping(path = "/create/{projectId}/{type}", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<List<?>> createTicketProjectFiles(
			@RequestPart(value = "files[]", required = false) List<MultipartFile> file,
			@PathVariable("projectId") Integer projectId, @PathVariable("type") String type, Principal p) {
		if (type.equals("tickets")) {
			return new ResponseEntity<List<?>>(this.ticketsService.addTicketFile(file, projectId, p.getName()),
					HttpStatus.CREATED);
		} else
			return new ResponseEntity<List<?>>(this.filesService.addProjectFile(file, projectId, p.getName()),
					HttpStatus.CREATED);
	}

	// download project file by id
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) {

		return this.filesService.downloadFile(id);

	}

	// delete project file by id
	@DeleteMapping("/{id}/{type}")
	public ResponseEntity<Boolean> deleteProjectTicketFile(@PathVariable Long id, @PathVariable("type") String type) {
		if (type.equals("tickets")) {
			return new ResponseEntity<Boolean>(this.ticketsService.deleteTicketFileById(id), HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Boolean>(this.filesService.deleteProjectFileById(id), HttpStatus.ACCEPTED);
	}

}
