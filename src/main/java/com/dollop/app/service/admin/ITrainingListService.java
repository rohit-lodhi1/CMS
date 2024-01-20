package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.TrainingList;
import com.dollop.app.entity.payload.TrainingListRequest;
import com.dollop.app.entity.payload.TrainingListResponse;

public interface ITrainingListService {
	public TrainingListResponse addTrainingList(TrainingListRequest trainingListRequest); 
	   
	   public TrainingListResponse getTrainingListById(Integer id);
	   
	   public TrainingListResponse updateTrainingList(TrainingListRequest trainingListRequest);
	   
	   public Page<TrainingListResponse> getAllTrainingList(Integer pageNo,Integer pageSize);
	   
	   public Boolean  deleteTrainingList(Integer id);
	   
	   public TrainingListResponse getTrainingListByStatus(Integer id,String status);
			
}
