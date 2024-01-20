package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.PerformanceIndicator;
import com.dollop.app.entity.payload.EstimatesRequest;
import com.dollop.app.entity.payload.EstimatesResponse;
import com.dollop.app.entity.payload.InvoicePaymentsResponse;
import com.dollop.app.entity.payload.PerformanceIndicatorRequest;
import com.dollop.app.entity.payload.PerformanceIndicatorResponse;

public interface PerformanceIndicatorService {
	
	public PerformanceIndicatorResponse createPerformanceIndicator(PerformanceIndicatorRequest performanceIndicator);
     
	public PerformanceIndicatorResponse updatePerformanceIndicator(PerformanceIndicatorRequest performanceIndicator);
	
	public void deletePerformanceIndicator(Integer id);
	
	public Page<PerformanceIndicatorResponse>getallPerformanceIndicator(Integer PagNo,Integer pageSize);
	
	public PerformanceIndicatorResponse getaPerformanceIndicatorById(Integer id);
	
	 public PerformanceIndicatorResponse getPerformanceIndicatorByStatus(Integer id,String status);
		
	

	public Page<PerformanceIndicatorResponse> searchPerformanceIndicator(Integer pageNo, Integer pageSize, PerformanceIndicatorRequest performanceIndicator);

	
}
