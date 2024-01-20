package com.dollop.app.controller.admin;

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
import com.dollop.app.entity.TrainingType;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.TrainingTypeRequest;
import com.dollop.app.entity.payload.TrainingTypeResponse;
import com.dollop.app.service.admin.ITrainingTypeService;

@RestController
@RequestMapping("/rise/admin/trainingType")
@CrossOrigin("*")

public class TrainingTypeController {
	@Autowired
	private ITrainingTypeService iTrainingTypeService;

   // create training type
	@PostMapping("/")
	public ResponseEntity<TrainingTypeResponse> createTrainers(@RequestBody TrainingTypeRequest trainingTypeRequest) {
		return new ResponseEntity<TrainingTypeResponse>(this.iTrainingTypeService.addTrainingType(trainingTypeRequest),
				HttpStatus.CREATED);
	}

    // update training type
	@PutMapping("/")
	public ResponseEntity<TrainingTypeResponse> updateTrainers(@RequestBody TrainingTypeRequest trainingTypeRequest) {
		 TrainingTypeResponse updateTrainingType = this.iTrainingTypeService.updateTrainingType(trainingTypeRequest);
		return ResponseEntity.ok(updateTrainingType);
	}

	 // training type by id
	@GetMapping("/{id}")
	public ResponseEntity<TrainingTypeResponse> getTrainerTypeById(@PathVariable Integer id) {
		return new ResponseEntity<TrainingTypeResponse>(this.iTrainingTypeService.getTrainingTypeById(id), HttpStatus.OK);

	}

   // get all training type
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TrainingTypeResponse>> getAllTrainers(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize) {
		Page<TrainingTypeResponse> trainers = this.iTrainingTypeService.getAllTrainingType(pageNo, pageSize);
		return new ResponseEntity<Page<TrainingTypeResponse>>(trainers, HttpStatus.OK);
	}
	
	@GetMapping("/status/{status}/{id}")
	public ResponseEntity<TrainingTypeResponse> updateTrainerTypeStatus(@PathVariable Integer id,
			                                                        @PathVariable String status) {
		TrainingTypeResponse training = this.iTrainingTypeService.getTrainingTypeByStatus(id, status);
		return new ResponseEntity<TrainingTypeResponse>(training, HttpStatus.OK);
	}

	// delete assets by id
				@DeleteMapping("/{id}")
				public ResponseEntity<Boolean> deleteGoalList(@PathVariable Integer id){
				     return new ResponseEntity<Boolean>(this.iTrainingTypeService.deleteTrainingType(id),HttpStatus.ACCEPTED);	
				}

}
