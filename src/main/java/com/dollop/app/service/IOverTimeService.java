package com.dollop.app.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.OverTimeRequest;
import com.dollop.app.entity.payload.OverTimeresponse;

public interface IOverTimeService {

	public OverTimeresponse  createOverTime(OverTimeRequest overTimeRequest);

	public 	Page<OverTimeresponse>  getAllOverTime(Integer pageIndex,Integer pageSize);
	
	
	public	String deleteOvertime(Integer id);
	
	public OverTimeresponse getOverTimeById(Integer id);
	
	public OverTimeresponse  updateOverTime(OverTimeRequest overTimeRequest);
	
	public	Page<OverTimeresponse>  searchOverTime(Integer pageIndex,Integer pageSize,OverTimeRequest overTimeRequest);
	
	public	Object getTotalOverTimeHours(LocalDate startDate,LocalDate endDate);

	public OverTimeresponse OverTimeStatus(Integer id, String status);


}
