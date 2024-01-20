package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.payload.admin.ProjectFilesRequest;
import com.dollop.app.entity.payload.admin.ProjectFilesResponse;
import com.dollop.app.entity.payload.admin.ProjectResponse;

public interface IProjectFilesService {
	
   public ProjectFiles projectFileRequestToProjectFile(ProjectFilesRequest filesRequest);
   
   public ProjectFilesResponse projectFileToProjectFileResponse(ProjectFiles projectFiles);
	
   public List<ProjectFiles> addProjectFile(List<MultipartFile> files,Integer projectId,String uploadedBy); 
   
   public ProjectFilesResponse  updateProjectFile(MultipartFile multipartFile,Long id,Integer projectId);
   
   public ProjectFilesResponse  getProjectFileById(Long id);
   
   public ResponseEntity<Resource> downloadFile(Long id);
   
   public Page<ProjectFilesResponse> getAllProjectFiles(Integer pageNo,Integer pageSize);
   
   public Page<ProjectFilesResponse> getAllProjectFilesByProjectId(Integer pageNo,Integer pageSize,Integer id);
   
   public Boolean deleteProjectFileById(Long id);
   
   
}
