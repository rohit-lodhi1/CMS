package com.dollop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.PromotionRequest;
import com.dollop.app.entity.payload.PromotionResponse;
import com.dollop.app.service.IPromotionService;

@RestController
@RequestMapping("/rise/promotion")
@CrossOrigin("*")
public class PromotionController {


	@Autowired
	private IPromotionService promotionService;

	// add promotion
	@PostMapping("/")
	public ResponseEntity<PromotionResponse> createPromotion(@RequestBody PromotionRequest promotionRequest) {
		return new ResponseEntity<PromotionResponse>(this.promotionService.addPromotion(promotionRequest),
				HttpStatus.CREATED);
	}

	// update promotion
	@PutMapping("/")
	public ResponseEntity<PromotionResponse> updatePromotion(@RequestBody PromotionRequest promotionRequest) {
		return ResponseEntity.ok(this.promotionService.updatePromotion(promotionRequest));
	}

	// get all promotions pagination
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PromotionResponse>> getAllPromotions(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<PromotionResponse>>(this.promotionService.getAllPromotions(pageNo, pageSize),
				HttpStatus.OK);
	}

		// get promotion by id
	@GetMapping("/{promotionId}")
	public ResponseEntity<PromotionResponse> getPromotionById(@PathVariable Integer promotionId) {
		return ResponseEntity.ok(this.promotionService.getPromotionById(promotionId));
	}

	// filter searching promotion by example
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PromotionResponse>> searchPromotionByExample(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @RequestBody PromotionRequest promotionRequest) {

		Page<PromotionResponse> promotionList = this.promotionService.serchPromotions(pageNo, pageSize, promotionRequest);
		return new ResponseEntity<Page<PromotionResponse>>(promotionList, HttpStatus.OK);
	}

	// Softdelete promotion by id
	@DeleteMapping("/{promotionId}")
	public ResponseEntity<Boolean> deleteGoalType(@PathVariable Integer promotionId) {
		return new ResponseEntity<Boolean>(this.promotionService.deletePromotion(promotionId), HttpStatus.ACCEPTED);
	}
}
