package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.PromotionRequest;
import com.dollop.app.entity.payload.PromotionResponse;

public interface IPromotionService {
	public PromotionResponse addPromotion(PromotionRequest promotionRequest);

	public PromotionResponse updatePromotion(PromotionRequest promotionRequest);

	public Page<PromotionResponse> getAllPromotions(Integer pageNo, Integer pageSize);

	public PromotionResponse getPromotionById(Integer promotionId);

	public Boolean deletePromotion(Integer id);

	public Page<PromotionResponse> serchPromotions(Integer pageNo, Integer pageSize, PromotionRequest promotionRequest);

	
	
	
}
