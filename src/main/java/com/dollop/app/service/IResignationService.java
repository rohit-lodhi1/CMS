package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.PromotionRequest;
import com.dollop.app.entity.payload.PromotionResponse;
import com.dollop.app.entity.payload.ResignationRequest;
import com.dollop.app.entity.payload.ResignationResponse;

public interface IResignationService {

	 public ResignationResponse addResignation(ResignationRequest resignationRequest); 
	   
	   public ResignationResponse updateResignation(ResignationRequest resignationRequest);
	   
	   public ResignationResponse getResignationById(Integer id);
	   
	   public Page<ResignationResponse> getAllResignation(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteResignation(Integer id);
	  
	  
	   public Page<ResignationResponse> searchResignation(Integer pageNo, Integer pageSize, ResignationRequest promotionRequest);

}
