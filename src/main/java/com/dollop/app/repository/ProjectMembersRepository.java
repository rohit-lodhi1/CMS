package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.PerformanceIndicator;
import com.dollop.app.entity.ProjectMembers;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;

public interface ProjectMembersRepository extends JpaRepository<ProjectMembers, Long>{

	public Page<ProjectMembers> findByProjectIdAndDeleted(Pageable pageable,Projects projectId,Boolean condition);
	
	public Page<ProjectMembers> findByUserId(Pageable pageable,Users userId);
	
	public Optional<ProjectMembers> findByProjectIdAndUserId(Projects projectId,Users userId);
	

    public Optional<ProjectMembers> findByIdAndDeleted(Long id, boolean b);
    
    @Query(value ="select  p.id  , p.title from `projects` p where id in (Select pm.project_id_id from `project_members` pm where pm.user_id_id=1)",nativeQuery =true) 
    public List<Object[]> findBYUserId(Integer userId);

    
}
