package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.ManageJobs;

public interface ManageJobsRepository extends JpaRepository<ManageJobs,Integer>{

public	 Optional<ManageJobs> findByIdAndIsDeletd(Integer id, boolean b);

public Page<ManageJobs> findByIsDeletd(PageRequest pageRequest, boolean b);

}
