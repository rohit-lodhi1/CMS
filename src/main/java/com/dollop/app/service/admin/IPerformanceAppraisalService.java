package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dollop.app.entity.payload.PerformanceAppraisalRequest;
import com.dollop.app.entity.payload.PerformanceAppraisalResponse;
import com.dollop.app.entity.payload.TrainerResponse;

@Service
public interface IPerformanceAppraisalService {
	
	public	PerformanceAppraisalResponse createPerformanceAppraisal(PerformanceAppraisalRequest performanceAppraisalRequest);

	public	PerformanceAppraisalResponse updatePerformanceAppraisal(PerformanceAppraisalRequest performanceAppraisalRequest);
	
	public	PerformanceAppraisalResponse getPerformanceAppraisalById(Integer id);
	
	public	Page<PerformanceAppraisalResponse>getAllPerformanceApraisal(Integer pageNo,Integer pageSize);
	
	public Boolean deletePerformanceApprisal(Integer id);
	
	  
	   public PerformanceAppraisalResponse getPerformanceAppraisalByStatus(Integer id,String status);
	
	
	
	
	
	
	
	
	
	

}
