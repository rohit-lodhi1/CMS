package com.dollop.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Comments;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tasks;

public interface CommentsRepository extends JpaRepository<Comments,Long> {

	public Page<Comments> findByProjectId(Pageable pageable,Projects projectId);
	
	public Page<Comments> findByTaskId(Pageable pageable,Tasks  taskId);
	
}
