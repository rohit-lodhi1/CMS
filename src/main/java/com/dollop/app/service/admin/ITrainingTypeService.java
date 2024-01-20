package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;



import com.dollop.app.entity.payload.TrainingTypeRequest;
import com.dollop.app.entity.payload.TrainingTypeResponse;

public interface ITrainingTypeService {
	public TrainingTypeResponse addTrainingType(TrainingTypeRequest trainingTypeRequest); 
	   
	   public TrainingTypeResponse getTrainingTypeById(Integer id);
	   
	   public TrainingTypeResponse updateTrainingType(TrainingTypeRequest trainingTypeRequest);
	   
	   public Page<TrainingTypeResponse> getAllTrainingType(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteTrainingType(Integer id);
	   
	   public TrainingTypeResponse getTrainingTypeByStatus(Integer id,String status);
		
}
