package com.dollop.app.serviceImpl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Promotion;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.PromotionRequest;
import com.dollop.app.entity.payload.PromotionResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.PromotionRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IPromotionService;

@Service
public class PromotionServiceImpl implements IPromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public PromotionResponse promotionToPromotionResponse(Promotion promotion) {
		return this.modelMapper.map(promotion, PromotionResponse.class);
	}

	public Promotion promotionRequestToPromotion(PromotionRequest promotionRequest) {
		return this.modelMapper.map(promotionRequest, Promotion.class);
	}

	@Override
	public PromotionResponse addPromotion(PromotionRequest promotionRequest) {
		Promotion  promotion = this.promotionRequestToPromotion(promotionRequest);
		Users user = this.usersRepository.findByIdAndDeleted(promotion.getEmployee().getId(),false).orElseThrow(()->new UserNotFoundException(AppConstants.USER_NOT_FOUND_+promotion.getEmployee().getId()));
		
		user.setDesignation(promotion.getDesignationTo());
		this.usersRepository.save(user);
		return this.promotionToPromotionResponse(this.promotionRepository.save(promotion));
}

	@Override
	public PromotionResponse updatePromotion(PromotionRequest promotionRequest) {
		Promotion promotion = this.promotionRepository.findById(promotionRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROMOTION_NOT_FOUND + promotionRequest.getId()));
		promotion.setDesignationFrom(promotion.getDesignationTo().getTitle());
		promotion.setIsDeleted(false);
		promotion.setDesignationTo(promotionRequest.getDesignationTo());
		//promotion.setPromotionDate(promotionRequest.getPromotionDate());
		promotion.setPromotionDate(promotionRequest.getPromotionDate());
		return this.promotionToPromotionResponse(this.promotionRepository.save(promotion));

	}

	@Override
	public Page<PromotionResponse> getAllPromotions(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Promotion> page = this.promotionRepository.findByIsDeleted(pageRequest, false);
//	System.out.println(page.getContent());
		return page.map(promotions -> this.promotionToPromotionResponse(promotions));
	}

	@Override
	public Boolean deletePromotion(Integer id) {
		Promotion promotion = this.promotionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROMOTION_NOT_FOUND + id));
		promotion.setIsDeleted(true);
		this.promotionRepository.save(promotion);
		return true;
	}

	@Override
	public Page<PromotionResponse> serchPromotions(Integer pageNo, Integer pageSize, PromotionRequest promotionRequest) {
		
		
		promotionRequest.getEmployee();
		promotionRequest.getEmployee().setIsAdmin(null);
		promotionRequest.getEmployee().setIsPrime(null);
		promotionRequest.getEmployee().setEnableWebNotification(null);
		promotionRequest.getEmployee().setEnableEmailNotification(null);
		promotionRequest.getEmployee().setDisableLogin(null);
		
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))) // for
		.withMatcher("designationTo.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))) // for
		.withMatcher("employee.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for

		Example<Promotion> example = Example.of(this.promotionRequestToPromotion(promotionRequest), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<Promotion> page = this.promotionRepository.findAll(example, pageable);
		
		 return page.map( u -> this.promotionToPromotionResponse(u));
}

	@Override
	public PromotionResponse getPromotionById(Integer promotionId) {
		Promotion promotion = this.promotionRepository.findByIdAndIsDeleted(promotionId,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PROMOTION_NOT_FOUND + promotionId));
		return this.promotionToPromotionResponse(promotion);
}

}
