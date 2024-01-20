package com.dollop.app.serviceImpl.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.ProjectMembers;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.admin.ProjectMemberRequest;
import com.dollop.app.entity.payload.admin.ProjectMemberResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.ProjectMembersRepository;
import com.dollop.app.service.admin.IProjectMembersService;
import com.dollop.app.service.admin.IProjectService;
import com.dollop.app.service.admin.IUsersService;

@Service
public class AdminProjectMemberServiceImpl implements IProjectMembersService {

	@Autowired
	private ProjectMembersRepository projectMembersRepository;

	@Autowired
	private IProjectService projectService;

	@Autowired
	private IUsersService usersService;

	@Autowired
	private ModelMapper modelMapper;

	public ProjectMemberResponse projectMemberToProjectMemberResponse(ProjectMembers projectMembers) {
		ProjectMemberResponse pr = new ProjectMemberResponse();
		pr.setProjectId(projectMembers.getProjectId());
		pr.setUserId(projectMembers.getUserId());
		pr.setDeleted(projectMembers.getDeleted());
		pr.setId(projectMembers.getId());
		pr.setIsLeader(projectMembers.getIsLeader());
		return pr;
	}

	public ProjectMembers projectMemberRequestToProjectMember(ProjectMemberRequest memberRequest) {
		return this.modelMapper.map(memberRequest, ProjectMembers.class);
	}

	// add project member
	@Override
	public List<ProjectMemberResponse> addProjectMember(List<ProjectMemberRequest> memberRequest) {

		List<ProjectMembers> list = memberRequest.stream().map(m -> this.projectMemberRequestToProjectMember(m))
				.collect(Collectors.toList());
		List<ProjectMembers> projectMember = new ArrayList<>();
		for (ProjectMembers l : list) {
			Projects project = new Projects();
			project.setId(l.getProjectId().getId());
			Users employee = new Users();
			employee.setId(l.getUserId().getId());
			Optional<ProjectMembers> memb = this.projectMembersRepository.findByProjectIdAndUserId(project, employee);
			if (memb.isEmpty())
				projectMember.add(l);
		}
		projectMember = this.projectMembersRepository.saveAll(projectMember);
		return projectMember.stream().map(m -> this.projectMemberToProjectMemberResponse(m))
				.collect(Collectors.toList());
	}

	// update project member
	@Override
	public ProjectMemberResponse updateProjectMember(ProjectMemberRequest memberRequest) {
		ProjectMembers member = this.projectMembersRepository.findById(memberRequest.getId()).orElseThrow(
				() -> new ResourceNotFoundException(AppConstants.PROJECT_MEMBER_NOT_FOUND + memberRequest.getId()));
		member.setIsLeader(memberRequest.getIsLeader());
		member.setProjectId(memberRequest.getProjectId());
		member.setUserId(memberRequest.getUserId());
		return this.projectMemberToProjectMemberResponse(this.projectMembersRepository.save(member));
	}

	// get project member by id
	@Override
	public ProjectMemberResponse getProjectMemberById(Long id) {
		ProjectMembers member = this.projectMembersRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_MEMBER_NOT_FOUND + id));

		return this.projectMemberToProjectMemberResponse(member);
	}

	// get project members by project id
	@Override
	public Page<ProjectMemberResponse> getProjectMemberByProjectId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Projects projects = new Projects();
		projects.setId(id);
		Page<ProjectMembers> members = this.projectMembersRepository.findByProjectIdAndDeleted(pageRequest, projects,false);

		return members.map(m -> this.projectMemberToProjectMemberResponse(m));
	}

	// get project members by user id
	@Override
	public Page<ProjectMemberResponse> getProjectMemberByUserId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Users user = new Users();
		user.setId(id);
		Page<ProjectMembers> members = this.projectMembersRepository.findByUserId(pageRequest, user);
		return members.map(m -> this.projectMemberToProjectMemberResponse(m));
	}

	// get all project members
	@Override
	public Page<ProjectMemberResponse> getAllProjectMembers(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<ProjectMembers> members = this.projectMembersRepository.findAll(pageRequest);
		return members.map(m -> this.projectMemberToProjectMemberResponse(m));
	}

	// delete project member by id
	@Override
	public Boolean deleteProjectMember(Long id) {
		ProjectMembers member = this.projectMembersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_MEMBER_NOT_FOUND + id));
	member.setDeleted(true);
		this.projectMembersRepository.save(member);
		return true;
	}

	// make project member leader
	@Override
	public ProjectMemberResponse makeLeader(ProjectMemberRequest memberRequest) {
		Projects project = new Projects();
		project.setId(memberRequest.getProjectId().getId());
		Users employee = new Users();
		employee.setId(memberRequest.getUserId().getId());
		ProjectMembers projectMember = this.projectMembersRepository.findByProjectIdAndUserId(project, employee)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROJECT_MEMBER_NOT_FOUND
						+ memberRequest.getProjectId().getId() + " and user id :" + memberRequest.getUserId().getId()));
		projectMember.setIsLeader(memberRequest.getIsLeader());
		projectMember = this.projectMembersRepository.save(projectMember);
		return this.projectMemberToProjectMemberResponse(projectMember);
	}

}
