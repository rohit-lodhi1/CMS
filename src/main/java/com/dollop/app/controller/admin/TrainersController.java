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
import com.dollop.app.entity.payload.TrainerRequest;
import com.dollop.app.entity.payload.TrainerResponse;
import com.dollop.app.entity.payload.TrainingListResponse;
import com.dollop.app.service.admin.ITrainersService;

@RestController
@RequestMapping("/rise/admin/trainers")
@CrossOrigin("*")
public class TrainersController {
	
	@Autowired
	private ITrainersService trainersService;

    // create trainers
	@PostMapping("/")
	public ResponseEntity<TrainerResponse> createTrainers(@RequestBody TrainerRequest trainers) {
		return new ResponseEntity<TrainerResponse>(this.trainersService.addTrainers(trainers), HttpStatus.CREATED);
	}

    // update trainers
	@PutMapping("/")
	public ResponseEntity<TrainerResponse> updateTrainers(@RequestBody TrainerRequest trainers) {
		TrainerResponse updateTrainers = this.trainersService.updateTrainers(trainers);
		return ResponseEntity.ok(updateTrainers);
	}

	//  get trainers by id
	@GetMapping("/{id}")
	public ResponseEntity<TrainerResponse> getSingleTrainers(@PathVariable Integer id) {
		return ResponseEntity.ok(this.trainersService.getTrainersById(id));
	}

    // get all trainers
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TrainerResponse>> getAllTrainers(@PathVariable Integer pageNo, 
																@PathVariable Integer pageSize) {
		Page<TrainerResponse> trainers = this.trainersService.getAllTrainers(pageNo, pageSize);
		return new ResponseEntity<Page<TrainerResponse>>(trainers, HttpStatus.OK);
	}

	
	
	@GetMapping("/status/{status}/{id}")
	public ResponseEntity<TrainerResponse> updateTrainingListStatus(@PathVariable Integer id,
			                                                        @PathVariable String status) {
		TrainerResponse training = this.trainersService.getTrainingListByStatus(id, status);
		return new ResponseEntity<TrainerResponse>(training, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTrainer(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.trainersService.deleteTrainers(id),HttpStatus.ACCEPTED);	
	}


}
