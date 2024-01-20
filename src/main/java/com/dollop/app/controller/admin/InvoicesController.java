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

import com.dollop.app.entity.payload.ClientsResponse;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.InvoicesResponse;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.service.admin.IInvoicesService;
import com.dollop.app.service.admin.IUsersService;

@RestController
@RequestMapping("/rise/admin/hr/invoices")
@CrossOrigin("*")

public class InvoicesController {

	@Autowired
	private IInvoicesService iInvoicesService;

	// add invoices
	@PostMapping("/")
	public ResponseEntity<InvoicesResponse> createInvoices(@RequestBody InvoicesRequest invoicesRequest) {
		System.out.println(invoicesRequest);
		return new ResponseEntity<InvoicesResponse>(this.iInvoicesService.addInvoices(invoicesRequest), HttpStatus.CREATED);
	}
	
	// update invoices
	@PutMapping("/")
	public ResponseEntity<InvoicesResponse> updateInvoices(@RequestBody InvoicesRequest invoicesRequest){
			InvoicesResponse updateinvoices = this.iInvoicesService.updateInvoices(invoicesRequest);
	return ResponseEntity.ok(updateinvoices);
	}
	
	
	
	// get all invoices
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<InvoicesResponse>> getAllInvoices(@PathVariable("pageNo") Integer pageNo,
                                                   @PathVariable("pageSize") Integer pageSize){
		return new ResponseEntity<Page<InvoicesResponse>>(this.iInvoicesService.getAllInvoices(pageNo,pageSize),HttpStatus.OK);
	}
	
	// get all invoices For DashBoard Order By Date
		@GetMapping("/order")
		public ResponseEntity<Page<InvoicesResponse>> getAllInvoicesByOrder(){
			return new ResponseEntity<Page<InvoicesResponse>>(this.iInvoicesService.getAllInvoicesOrderByDate(),HttpStatus.OK);
		}
	// get invoices
		@GetMapping("/{invoicesId}")
		public ResponseEntity<InvoicesResponse> getInvoicesById(@PathVariable Integer invoicesId) {
			return ResponseEntity.ok(this.iInvoicesService.getInvoicesById(invoicesId));
		}


	// filter searching 
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<InvoicesResponse>> searchInvoices(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody InvoicesRequest invoicesRequest){
			Page<InvoicesResponse> invoices = this.iInvoicesService.searchInvoices(pageNo, pageSize, invoicesRequest);
		return new ResponseEntity<Page<InvoicesResponse>>(invoices,HttpStatus.OK);
	}
	
	// delete invoices by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteInvoices(@PathVariable Integer id){
	     return new ResponseEntity<Boolean>(this.iInvoicesService.deleteInvoices(id),HttpStatus.ACCEPTED);	
	}

	
	
}
