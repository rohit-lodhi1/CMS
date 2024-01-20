package com.dollop.app.service.admin;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.PolicyFiles;

public interface IPolicyFileService {

	public ResponseEntity<Resource> downloadFile(Long id);
	
}
