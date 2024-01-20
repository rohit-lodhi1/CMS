package com.dollop.app.serviceImpl.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Comments;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.payload.admin.CommentsRequest;
import com.dollop.app.entity.payload.admin.CommentsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.CommentsRepository;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.repository.TasksRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.employee.IProjectCommentsService;

@Service
public class EmployeeProjectCommentServiceImpl implements IProjectCommentsService {

	@Value("${project.file.path}")
	public String DIRECTORY;

	@Autowired
	private CommentsRepository commentsRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TasksRepository tasksRepository;
    @Autowired
    private UsersRepository  usersRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	private Comments projectCommentsRequestToProjectComments(CommentsRequest projectCommentsRequest) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return this.modelMapper.map(projectCommentsRequest, Comments.class);
	}

	private CommentsResponse projectCommentsToProjectCommentsResponse(Comments projectComments) {
		return this.modelMapper.map(projectComments, CommentsResponse.class);
	}

	// add project comments
	@Override
	public Comments addComment(List<MultipartFile> files, CommentsRequest commentsRequest) {        
		Comments comments = this.projectCommentsRequestToProjectComments(commentsRequest);
		if (files != null) {
			List<ProjectFiles> projectFiles = new ArrayList<>();
			for (MultipartFile f : files) {
				ProjectFiles pf = new ProjectFiles();

				pf.setOriginalName(f.getOriginalFilename());

				pf.setFileName(UUID.randomUUID().toString() + f.getOriginalFilename());

				pf.setFileSize((double) f.getSize());

				pf.setCreatedAt(new Date(System.currentTimeMillis()));

				pf.setProjectId(comments.getProjectId());

				pf.setUploadedBy(comments.getCreatedBy());

				projectFiles.add(pf);
				String fileName = StringUtils.cleanPath(pf.getFileName());
				
				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(f.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {

					e.printStackTrace();
				}
				projectFiles.add(pf);
			}
			comments.setFileId(projectFiles);
			comments.setType(commentsRequest.getType());
			
			
		}
		comments.setCreatedAt(LocalDateTime.now());	
		comments.setProjectId(projectRepository.findById(commentsRequest.getProjectId()).get());
		comments.setCreatedBy(usersRepository.findById(commentsRequest.getUserId()).get());
		comments = this.commentsRepository.save(comments);
		return comments;
	}

	// update project comments
	@Override
	public CommentsResponse updateProjectComment(CommentsRequest commentsRequest) {

		return null;
	}

	// get project comments by id
	@Override
	public CommentsResponse getProjectCommentById(Long id) {
		Comments comments = this.commentsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + id));

		return this.projectCommentsToProjectCommentsResponse(comments);
	}

	// get project comments by project id
	@Override
	public Page<CommentsResponse> getProjectCommentsByProjectId(Integer pageNo, Integer pageSize, Integer projectId) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Projects projects = new Projects();
		projects.setId(projectId);
		Page<Comments> comments = this.commentsRepository.findByProjectId(pageRequest, projects);

		return comments.map(c -> this.projectCommentsToProjectCommentsResponse(c));
	}

	// get project comments by task id
	@Override
	public Page<CommentsResponse> getProjectCommentsByTaskId(Integer pageNo, Integer pageSize, Long taskId) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Tasks tasks = new Tasks();
		tasks.setId(taskId);
		Page<Comments> comments = this.commentsRepository.findByTaskId(pageRequest, tasks);
		return comments.map(c -> this.projectCommentsToProjectCommentsResponse(c));
	}

	// delete project Comment
	@Override
	public Boolean deleteProjectCommentById(Long id) {
		Comments comments = this.commentsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_NOT_FOUND + id));
		comments.setDeleted(true);
		this.commentsRepository.save(comments);
		return true;
	}

}
