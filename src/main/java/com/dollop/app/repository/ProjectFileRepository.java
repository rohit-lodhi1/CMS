package com.dollop.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Projects;

public interface ProjectFileRepository extends JpaRepository<ProjectFiles, Long>{

	public Page<ProjectFiles> findByProjectIdAndDeleted(Pageable pageable,Projects projectId,Boolean deleted);
	
	
}
