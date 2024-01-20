package com.dollop.app.serviceImpl.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.PolicyFiles;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PolicyFilesRepository;
import com.dollop.app.service.employee.IPolicyFileService;

@Service
public class EmployeePolicyFileServiceImpl implements IPolicyFileService{

	@Autowired
	private PolicyFilesRepository fileRepository;
	
	@Value("${policy.file.path}")
	private  String DIRECTORY ;
	
	@Override
	public ResponseEntity<Resource> downloadFile(Long id) {
		PolicyFiles file = this.fileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.FILE_NOT_FOUND+id));
		try {
			Path path = Paths.get(System.getProperty("user.dir")+DIRECTORY).toAbsolutePath().normalize().resolve(file.getFileName()); //
		
		
			if(!Files.exists(path))
			throw new ResourceNotFoundException(AppConstants.FILE_NOT_FOUND+path);
			Resource resource = new UrlResource(path.toUri());
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("File-Name",file.getOriginalFileName());
    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;File-Name="+file.getOriginalFileName());
    return ResponseEntity.ok()
    		.contentType(MediaType.parseMediaType(Files.probeContentType(path)))
    		.headers(httpHeaders)
    		.body(resource);
    		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deletePolicyFileById(Long id) {
		PolicyFiles file = this.fileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.POLICY_NOT_FOUND+id));
		this.fileRepository.delete(file);
		return true;
	}
	

}
