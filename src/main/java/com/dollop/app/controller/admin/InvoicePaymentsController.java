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

import com.dollop.app.entity.payload.InvoicePaymentsRequest;
import com.dollop.app.entity.payload.InvoicePaymentsResponse;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.InvoicesResponse;
import com.dollop.app.service.admin.IInvoicesService;
import com.dollop.app.service.admin.InvoicePaymentsService;

@RestController
@RequestMapping("/rise/admin/hr/invoicePayments")
@CrossOrigin("*")

public class InvoicePaymentsController {

	@Autowired
	private InvoicePaymentsService invoicePaymentsService;

	// add invoicePayments
	@PostMapping("/")
	public ResponseEntity<InvoicePaymentsResponse> createInvoicePayments(
			@RequestBody InvoicePaymentsRequest invoicePaymentsRequest) {

		return new ResponseEntity<InvoicePaymentsResponse>(
				this.invoicePaymentsService.addInvoicePayments(invoicePaymentsRequest), HttpStatus.CREATED);
	}

	// update invoicePayments
	@PutMapping("/")
	public ResponseEntity<InvoicePaymentsResponse> updateInvoicePayments(
			@RequestBody InvoicePaymentsRequest invoicePaymentsRequests) {
		InvoicePaymentsResponse updateinvoices = this.invoicePaymentsService.updateInvoicePayments(invoicePaymentsRequests);
		return ResponseEntity.ok(updateinvoices);
	}

	// get all invoicePayments
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<InvoicePaymentsResponse>> getAllInvoicePayments(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return new ResponseEntity<Page<InvoicePaymentsResponse>>(
				this.invoicePaymentsService.getAllInvoicePayments(pageNo, pageSize), HttpStatus.OK);
	}
	
	// get all invoicePayments
		@GetMapping("/order")
		public ResponseEntity<Page<InvoicePaymentsResponse>> getAllInvoicePaymentsByOrder() {
			return new ResponseEntity<Page<InvoicePaymentsResponse>>(
					this.invoicePaymentsService.getAllInoicePaymentOrderByDate(), HttpStatus.OK);
		}
	
	@GetMapping("/")
	public ResponseEntity<Page<InvoicePaymentsResponse>> getAllInVoicePaymentByOrder() {
		return new ResponseEntity<Page<InvoicePaymentsResponse>>(
				this.invoicePaymentsService.getAllInoicePaymentOrderByDate(), HttpStatus.OK);
	}

	// get invoicePayments
	@GetMapping("/{invoicesId}")
	public ResponseEntity<InvoicePaymentsResponse> getInvoicePaymentsById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.invoicePaymentsService.getInvoicePaymentsById(Id));
	}

	// delete invoicePayments by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteInvoicePayments(@PathVariable Integer id) {
		return new ResponseEntity<Boolean>(this.invoicePaymentsService.deleteTrainers(id), HttpStatus.ACCEPTED);
	}

}
