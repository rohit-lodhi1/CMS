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

import com.dollop.app.entity.TrainingList;
import com.dollop.app.entity.payload.TrainingListRequest;
import com.dollop.app.entity.payload.TrainingListResponse;
import com.dollop.app.entity.payload.TrainingTypeRequest;
import com.dollop.app.entity.payload.TrainingTypeResponse;
import com.dollop.app.service.admin.ITrainingListService;

@RestController
@RequestMapping("/rise/admin/trainingList")
@CrossOrigin("*")
public class TrainingListController {
	@Autowired
	private ITrainingListService iTrainingListService;

	   // create training list
		@PostMapping("/")
		public ResponseEntity<TrainingListResponse> createTrainers(@RequestBody TrainingListRequest trainingTypeListRequest) {
			
			return new ResponseEntity<TrainingListResponse>(this.iTrainingListService.addTrainingList(trainingTypeListRequest),
					HttpStatus.CREATED);
		}

	    // update training List
		@PutMapping("/")
		public ResponseEntity<TrainingListResponse> updateTrainers(@RequestBody TrainingListRequest trainingTypeListRequest) {
			TrainingListResponse updateTrainingList = this.iTrainingListService.updateTrainingList(trainingTypeListRequest);
			return ResponseEntity.ok(updateTrainingList);
		}

		 // training List by id
		@GetMapping("/{id}")
		public ResponseEntity<TrainingListResponse> getTrainerListById(@PathVariable Integer id) {
			return new ResponseEntity<TrainingListResponse>(this.iTrainingListService.getTrainingListById(id), HttpStatus.OK);

		}

	   // get all training List
		@GetMapping("/{pageNo}/{pageSize}")
		public ResponseEntity<Page<TrainingListResponse>> getAllTrainingList(@PathVariable Integer pageNo,
				@PathVariable Integer pageSize) {
			Page<TrainingListResponse> trainers = this.iTrainingListService.getAllTrainingList(pageNo, pageSize);
			return new ResponseEntity<Page<TrainingListResponse>>(trainers, HttpStatus.OK);
		}
		
		@GetMapping("/status/{status}/{id}")
		public ResponseEntity<TrainingListResponse> updateTrainingListStatus(@PathVariable Integer id,
				                                                        @PathVariable String status) {
			TrainingListResponse training = this.iTrainingListService.getTrainingListByStatus(id, status);
			return new ResponseEntity<TrainingListResponse>(training, HttpStatus.OK);
		}

		// delete assets by id
					@DeleteMapping("/{id}")
					public ResponseEntity<Boolean> deleteTrainingList(@PathVariable Integer id){
					     return new ResponseEntity<Boolean>(this.iTrainingListService.deleteTrainingList(id),HttpStatus.ACCEPTED);	
					}
}
