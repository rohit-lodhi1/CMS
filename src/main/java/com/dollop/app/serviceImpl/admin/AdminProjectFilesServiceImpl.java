package com.dollop.app.serviceImpl.admin;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.admin.ProjectFilesRequest;
import com.dollop.app.entity.payload.admin.ProjectFilesResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.ProjectFileRepository;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.IProjectFilesService;
import com.dollop.app.service.admin.IProjectService;

@Service
public class AdminProjectFilesServiceImpl implements IProjectFilesService {

	@Value("${project.file.path}")
	private String DIRECTORY;

	@Autowired
	private ProjectFileRepository projectFileRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override	public ProjectFiles projectFileRequestToProjectFile(ProjectFilesRequest filesRequest) {
		return this.modelMapper.map(filesRequest, ProjectFiles.class);
	}

	@Override
	public ProjectFilesResponse projectFileToProjectFileResponse(ProjectFiles projectFiles) {
		return this.modelMapper.map(projectFiles, ProjectFilesResponse.class);
	}

	@Override
	public List<ProjectFiles> addProjectFile(List<MultipartFile> files, Integer projectId, String uploadedBy) {

		Projects project = this.projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + projectId));
		Users user = this.userRepository.findByEmail(uploadedBy)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_ + uploadedBy));
		List<ProjectFiles> projectFiles = new ArrayList<>();
		if (files != null) {

			for (MultipartFile a : files) {

				ProjectFiles pf = new ProjectFiles();
				pf.setCreatedAt(new Date(System.currentTimeMillis()));
				pf.setOriginalName(a.getOriginalFilename());
				pf.setFileSize((double) a.getSize());
				pf.setProjectId(project);
				pf.setFileName(UUID.randomUUID().toString() + a.getOriginalFilename());
				pf.setUploadedBy(user);
				// system file upload
				String fileName = StringUtils.cleanPath(pf.getFileName());

				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(a.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {

					e.printStackTrace();
				}
				projectFiles.add(pf);

			};
		}
		projectFiles = this.projectFileRepository.saveAll(projectFiles);

		return projectFiles;

	}

	@Override
	public ProjectFilesResponse updateProjectFile(MultipartFile multipartFile, Long id, Integer projectId) {
		Projects project = this.projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + projectId));
		ProjectFiles projectFiles = this.projectFileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_FILE_NOT_FOUND + id));

		projectFiles.setProjectId(project);
		projectFiles.setOriginalName(multipartFile.getOriginalFilename());
		projectFiles.setFileName(System.getProperty("user.dir") + DIRECTORY);
		projectFiles.setFileSize((double) multipartFile.getSize());
		return this.projectFileToProjectFileResponse(this.projectFileRepository.save(projectFiles));

	}

	@Override
	public ProjectFilesResponse getProjectFileById(Long id) {
		ProjectFiles projectFiles = this.projectFileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_FILE_NOT_FOUND + id));
		return this.projectFileToProjectFileResponse(projectFiles);
	}

	@Override
	public Page<ProjectFilesResponse> getAllProjectFiles(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<ProjectFiles> page = this.projectFileRepository.findAll(pageRequest);
		return page.map(f -> this.projectFileToProjectFileResponse(f));
	}

	@Override
	public Page<ProjectFilesResponse> getAllProjectFilesByProjectId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Projects projectId = new Projects();
		projectId.setId(id);
		Page<ProjectFiles> page = this.projectFileRepository.findByProjectIdAndDeleted(pageRequest, projectId, false);
		return page.map(f -> this.projectFileToProjectFileResponse(f));
	}

	@Override
	public Boolean deleteProjectFileById(Long id) {
		ProjectFiles projectFiles = this.projectFileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_FILE_NOT_FOUND + id));

		this.projectFileRepository.delete(projectFiles);

		Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY).toAbsolutePath().normalize()
				.resolve(projectFiles.getFileName()); //
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public ResponseEntity<Resource> downloadFile(Long id) {
		ProjectFiles file = this.projectFileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.FILE_NOT_FOUND + id));
		try {
			Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY).toAbsolutePath().normalize()
					.resolve(file.getFileName()); //

			if (!Files.exists(path))
				throw new ResourceNotFoundException(AppConstants.FILE_NOT_FOUND + path);
			Resource resource = new UrlResource(path.toUri());
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("File-Name", file.getOriginalName());
			httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;File-Name=" + file.getOriginalName());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(path)))
					.headers(httpHeaders).body(resource);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
