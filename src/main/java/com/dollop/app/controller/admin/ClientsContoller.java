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
import com.dollop.app.entity.payload.ClientsRequest;
import com.dollop.app.entity.payload.ClientsResponse;
import com.dollop.app.service.admin.IClientsService;

@RestController
@RequestMapping("/rise/admin/clients")
@CrossOrigin("*")
public class ClientsContoller {
	@Autowired
	private IClientsService clientsService;

	// add clients
	@PostMapping("/")
	public ResponseEntity<ClientsResponse> createClients(@RequestBody ClientsRequest clientsRequest) {
		return new ResponseEntity<ClientsResponse>(this.clientsService.addClients(clientsRequest), HttpStatus.CREATED);
	}

	// update clients
	@PutMapping("/")
	public ResponseEntity<ClientsResponse> updateClients(@RequestBody ClientsRequest clientsRequest) {
		ClientsResponse updateClient = this.clientsService.updateClients(clientsRequest);
		return new ResponseEntity<ClientsResponse>(updateClient, HttpStatus.OK);
	}

	// get clients
	@GetMapping("/{clientsId}")
	public ResponseEntity<ClientsResponse> getSingleClients(@PathVariable Integer clientsId) {
		return ResponseEntity.ok(this.clientsService.getClientsById(clientsId));
	}

	// get all clients
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ClientsResponse>> getAllClients(@PathVariable("pageNo") Integer pageNo,
													   @PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<ClientsResponse>>(this.clientsService.getAllClients(pageNo, pageSize), HttpStatus.OK);
	}
	
	// get all clients By Order 
		@GetMapping("/order")
		public ResponseEntity<Page<ClientsResponse>> getAllClientsByOrder() {
			return new ResponseEntity<Page<ClientsResponse>>(this.clientsService.getAllClientsOrderby(), HttpStatus.OK);
		}

	// delete client by id
	@DeleteMapping("/{clientsId}")
	public ResponseEntity<Boolean> deletedDepartment(@PathVariable Integer clientsId) {

		return ResponseEntity.ok(clientsService.deleteClients(clientsId));
	}
	
	// update client status by id
	@GetMapping("/status/{id}/{status}")
	public ResponseEntity<ClientsResponse> updateClientStatus(@PathVariable Integer id,@PathVariable String status) {
		ClientsResponse updateClient = this.clientsService.updateClientStatus(id,status);
		return new ResponseEntity<ClientsResponse>(updateClient, HttpStatus.OK);
	}
	
	// searching Client
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ClientsResponse>> searchClient(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody ClientsRequest clients) {
		 
		return new ResponseEntity<Page<ClientsResponse>>(this.clientsService.searchClient(pageNo, pageSize, clients),HttpStatus.OK);
	}
}
