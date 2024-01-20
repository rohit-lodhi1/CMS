package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.TicketsFiles;

@Service
public interface ITicketsFilesService {

	
	 public List<TicketsFiles> addTicketsFiles(List<MultipartFile> files,Integer TicketsId,Integer uploadedBy); 
}
