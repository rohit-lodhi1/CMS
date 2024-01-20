package com.dollop.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.AppliedCandidate;
import com.dollop.app.entity.ManageJobs;

public interface AppliedCandidateRepository extends JpaRepository<AppliedCandidate, Long> {

	Page<AppliedCandidate> findByManageJobs(PageRequest pageRequest, ManageJobs manageJobs);

}
