package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.TrainingList;
import com.dollop.app.entity.TrainingType;

public interface TrainingListRepository extends JpaRepository<TrainingList,Integer>{
	public Page<TrainingList>   findByStatus(Pageable pageble,String status);
	

	public Optional<TrainingList> findByIdAndDeleted(Integer id, boolean b);


	public Page<TrainingList> findByDeleted(PageRequest pageRequest, boolean b);


	
}
