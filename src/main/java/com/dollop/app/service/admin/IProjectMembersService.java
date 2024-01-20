package com.dollop.app.service.admin;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.web.ProjectedPayload;

import com.dollop.app.entity.ProjectMembers;
import com.dollop.app.entity.payload.admin.ProjectMemberRequest;
import com.dollop.app.entity.payload.admin.ProjectMemberResponse;

public interface IProjectMembersService {

	public List<ProjectMemberResponse> addProjectMember(List<ProjectMemberRequest> memberRequest);
	
	public ProjectMemberResponse updateProjectMember(ProjectMemberRequest memberRequest);
	
	public ProjectMemberResponse getProjectMemberById(Long id);
	
	public Page<ProjectMemberResponse> getProjectMemberByProjectId(Integer pageNo,Integer pageSize,Integer id);
	
	public Page<ProjectMemberResponse> getProjectMemberByUserId(Integer pageNo,Integer pageSize,Integer id);
	
	public Page<ProjectMemberResponse> getAllProjectMembers(Integer pageNo,Integer pageSize);
	
	public Boolean deleteProjectMember(Long id);
	
	public ProjectMemberResponse makeLeader(ProjectMemberRequest memberRequest);
	
	
}
