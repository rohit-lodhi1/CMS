
package com.dollop.app.serviceImpl.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Expenses;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.extrapayload.ProjectResponseList;
import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.admin.ProjectForAllResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.ProjectFileRepository;
import com.dollop.app.repository.ProjectMembersRepository;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.IClientsService;
import com.dollop.app.service.admin.IProjectFilesService;
import com.dollop.app.service.admin.IProjectService;

@Service
public class AdminProjectServiceImpl implements IProjectService {

	@Value("${project.file.path}")
	public String DIRECTORY;

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectMembersRepository  projeMembersRepository;

	@Autowired
	private IClientsService clientsService;

	@Autowired
	private ProjectFileRepository projectFileRepository;

	@Autowired
	private IProjectFilesService filesService;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ProjectResponse projectToProjectResponse(Projects project) {
		// modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return this.modelMapper.map(project, ProjectResponse.class);
	}

	public Projects projectRequestToProject(ProjectRequest projectRequest) {
		return this.modelMapper.map(projectRequest, Projects.class);
	}

	public ProjectForAllResponse projectToProjectForAllResponse(Projects project) {
		return this.modelMapper.map(project, ProjectForAllResponse.class);
	}

	// add project
	@Override
	public ProjectResponse addProject(ProjectRequest projectRequest, List<MultipartFile> files, String email) {
		Projects project = this.projectRequestToProject(projectRequest);
		Users user = this.userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		project.setCreatedBy(user);
		List<ProjectFiles> projectFiles = new ArrayList<>();
		if (files != null)
			files.forEach(a -> {
				ProjectFiles pf = new ProjectFiles();
				pf.setCreatedAt(new Date(System.currentTimeMillis()));
				pf.setOriginalName(a.getOriginalFilename());
				pf.setFileSize((double) a.getSize());
				pf.setUploadedBy(user);
				pf.setFileName(UUID.randomUUID().toString() + a.getOriginalFilename());

				// system file upload
				String fileName = StringUtils.cleanPath(pf.getFileName());

				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(a.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				projectFiles.add(pf);

			});
		project.setProjectFiles(projectFiles);
		project.setCreatedBy(user);
		project = this.projectRepository.save(project);

		return this.projectToProjectResponse(project);
	}

	// update project
	@Override
	public ProjectResponse updateProject(ProjectRequest projectRequest, List<MultipartFile> files) {
		Projects project = this.projectRepository.findById(projectRequest.getId()).orElseThrow(
				() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + projectRequest.getId()));
		project.setClientId(this.clientsService.clientsRequestToClients(projectRequest.getClientId()));
		project.setStartDate(projectRequest.getStartDate());
		project.setDeadline(projectRequest.getDeadline());
		project.setDescription(projectRequest.getDescription());
		project.setLabels(projectRequest.getLabels());
		project.setPrice(projectRequest.getPrice());
		project.setTitle(projectRequest.getTitle());
		project.setStatus(projectRequest.getStatus());

		List<ProjectFiles> projectFiles = projectRequest.getProjectFiles().stream()
				.map(p -> this.filesService.projectFileRequestToProjectFile(p)).collect(Collectors.toList());
		if (files != null) {
			files.forEach(a -> {

				ProjectFiles pf = new ProjectFiles();
				pf.setCreatedAt(new Date(System.currentTimeMillis()));
				pf.setOriginalName(a.getOriginalFilename());
				pf.setFileSize((double) a.getSize());

				pf.setFileName(UUID.randomUUID().toString() + a.getOriginalFilename());

				// system file upload
				String fileName = StringUtils.cleanPath(pf.getFileName());
				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(a.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {

					e.printStackTrace();
				}
				projectFiles.add(pf);

			});
		}
		project.setProjectFiles(projectFiles);
		project = this.projectRepository.save(project);

		return this.projectToProjectResponse(project);
	}

	// get project by id
	@Override
	public ProjectResponse getProjectById(Integer id) {
		Projects project = this.projectRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + id));
		List<ProjectFiles> images = project.getProjectFiles().parallelStream().filter(f -> {
			if (f.getOriginalName().endsWith(".png") || f.getOriginalName().endsWith(".jpg")
					|| f.getOriginalName().endsWith(".jpeg")) {
				project.getProjectFiles().remove(f);
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		ProjectResponse projectResponse = this.projectToProjectResponse(project);
		projectResponse.setImages(images);

		return projectResponse;
	}

	// get all projects
	@Override
	public Page<ProjectResponse> getAllProjects(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Projects> page = this.projectRepository.findByDeleted(pageRequest, false);
		page.getContent().parallelStream().forEach(a -> {
			a.setProjectFiles(null);
		});

		return page.map(p -> this.projectToProjectResponse(p));
	}

	// get all projects of client by client id
	@Override
	public Page<ProjectResponse> getAllProjectsByClientId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Clients client = this.clientsService.clientsResponseToClients(this.clientsService.getClientsById(id));
		Page<Projects> page = this.projectRepository.findByClientId(pageRequest, client);

		return page.map(p -> this.projectToProjectResponse(p));
	}

	

	// delete project by id
	@Override
	public Boolean deleteProject(Integer id) {
		Projects project = this.projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + id));
		project.setDeleted(true);
		this.projectRepository.save(project);
		return true;
	}
	
	

	@Override
	public Page<ProjectResponse> getLeadsOfProjects(Integer pageNo, Integer pageSize) {

		return null;
	}

	// for system upload
	public ProjectResponse systemUpload(ProjectRequest projectRequest, List<MultipartFile> files) {
		// save only path of file and save the file in local folder

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
			try {
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ResponseEntity<Resource> downloadFile(Long id) {
		ProjectFiles file = this.projectFileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.FILE_NOT_FOUND + id));

		try {
			Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY).toAbsolutePath().normalize()
					.resolve("flipkart-app.zip"); //

			if (!Files.exists(path))
				throw new ResourceNotFoundException("FIle not Found " + path);
			Resource resource = new UrlResource(path.toUri());
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("File-Name", "example1.zip");
			httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(path)))
					.headers(httpHeaders).body(resource);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Page<ProjectResponse> getAllProjectsByOrderBy() {
		PageRequest pageRequest = PageRequest.of(0, 6, Sort.by("createdDate").descending());
		Page<Projects> page = this.projectRepository.findAll(pageRequest);
		return page.map(u -> this.projectToProjectResponse(u));

	}

	@Override
	public List<ProjectResponseList> getAllProjectsByCurrentUser(String email) {
		Users user = this.userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		List<Object[]> projectsList = this.projeMembersRepository.findBYUserId(user.getId());
		List<ProjectResponseList> responseList = projectsList.stream()
			    .map(array -> new ProjectResponseList((Integer) array[0], (String) array[1])) // adjust the casting based on your actual types
			    .collect(Collectors.toList());
		
		if (responseList.isEmpty()) {
			throw new ResourceNotFoundException(AppConstants.NO_PROJECTS_ASSIGNED + "with email => "+email );
		}
		
		return responseList;
	}

	@Override
	public List<ProjectResponse> searchProjects(ProjectRequest projectRequest) {
		projectRequest.setPrice(null);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withIgnoreNullValues()
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)));// for
		
		Example<Projects> proExample=Example.of(this.projectRequestToProject(projectRequest),exampleMatcher);
		
	List<Projects> projects=this.projectRepository.findAll(proExample);
		
		return projects.stream().map(u->this.projectToProjectResponse(u)).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<?> updateProjectStatus(Integer id, String status,String priority) {
		Map<String, Object> response = new HashMap<>();
		Projects projects=this.projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND+ id));
	    if(!priority.isEmpty())
		projects.setPriority(priority);
	    if(!status.isEmpty())
	    projects.setStatus(status);
	    Projects projects2 = this.projectRepository.save(projects);
	    if(Objects.nonNull(projects2)) {
	    	response.put("message", "Update SuccessFully");
	    	return new ResponseEntity<>(response,HttpStatus.OK);
	    }
	    response.put("message", "Update Failed");
    	return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

	

	
}
