package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dollop.app.entity.PerformanceAppraisal;
import com.dollop.app.entity.Users;

public interface PerformanceAppraisalRepository extends JpaRepository<PerformanceAppraisal, Integer>{
	public Optional<PerformanceAppraisal> findByIdAndIsDelete(Integer id, boolean b);

	public Page<PerformanceAppraisal> findByIsDelete(PageRequest page, boolean b);

	public boolean existsByUser(Users u);

	public Page<PerformanceAppraisal> findAllByIsDelete(PageRequest pageRequest,Boolean isDeleted);

}
