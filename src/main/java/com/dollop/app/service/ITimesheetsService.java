package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.TimeSheetRequest;
import com.dollop.app.entity.payload.TimeSheetResponse;


public interface ITimesheetsService {

	   public TimeSheetResponse addTimeSheet(TimeSheetRequest timeSheets, String userEmailCurrent) ; 
	   
	   public TimeSheetResponse getTimeSheetBy(Integer id);
	   
	   public TimeSheetResponse updateTimeSheet(TimeSheetRequest timeSheets);
	   
	   public Page<TimeSheetResponse> getAllTimeSheets(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteTimeSheet(Integer id);	
	   
	   public Page<TimeSheetResponse> getAllTimeSheetsByClientId(Integer pageNo,Integer pageSize,Integer id);
	   
	   public Page<TimeSheetResponse>getAllTimeSheetsByProjectId(Integer PageNo,Integer pageSize,Integer id);
	     
	   public Page<TimeSheetResponse>getAllTimeSheetsByTaskId(Integer PageNo,Integer pageSize,Long id);
	   
	   
	   
	
}
