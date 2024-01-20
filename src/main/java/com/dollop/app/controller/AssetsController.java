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

import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.service.IAssetsService;

@RestController
@RequestMapping("/rise/administration/assets")
@CrossOrigin("*")

public class AssetsController {

	@Autowired
	private IAssetsService assetsService;

	
	// add goal assets
	@PostMapping("/")
	public ResponseEntity<AssetsResponse> createAssets(@RequestBody AssetsRequest assetsRequest) {
		return new ResponseEntity<AssetsResponse>(this.assetsService.addAssets(assetsRequest),
				HttpStatus.CREATED);
	}

	// update assets
	@PutMapping("/")
	public ResponseEntity<AssetsResponse> updateGoalList(@RequestBody AssetsRequest assetsRequest) {
		AssetsResponse updateGoalList = this.assetsService.updateAssets(assetsRequest);
		return ResponseEntity.ok(updateGoalList);
	}

	// get all assets
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<AssetsResponse>> getAllGoalList(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<AssetsResponse>>(this.assetsService.getAllAssets(pageNo, pageSize),
				HttpStatus.OK);
	}

	// get assets
	@GetMapping("/{assetsId}")
	public ResponseEntity<AssetsResponse> getAssetsById(@PathVariable Long assetsId) {
		return ResponseEntity.ok(this.assetsService.getAssetsById(assetsId));
	}

	// filter assets
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<AssetsResponse>> searchAssets(@PathVariable Integer pageNo,
			                                                   @PathVariable Integer pageSize, 
			                                                    @RequestBody AssetsRequest assetsRequest) {

		
		Page<AssetsResponse> assets = this.assetsService.searchAssets(pageNo, pageSize, assetsRequest);
		return new ResponseEntity<Page<AssetsResponse>>(assets, HttpStatus.OK);
	}

	// update assets status by id
	@GetMapping("/status/{status}/{id}")
	public ResponseEntity<AssetsResponse> updateAssetsStatus(@PathVariable Long id,
			                                                        @PathVariable String status) {
	
		return new ResponseEntity<AssetsResponse>( this.assetsService.updateAssetsStatus(id, status), HttpStatus.OK);
	}
	
	// delete assets by id
			@DeleteMapping("/{id}")
			public ResponseEntity<Boolean> deleteGoalList(@PathVariable Long id){
			     return new ResponseEntity<Boolean>(this.assetsService.deleteAssets(id),HttpStatus.ACCEPTED);	
			}


}
