package com.dollop.app.serviceImpl.admin;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.InvoicePayments;
import com.dollop.app.entity.Invoices;
import com.dollop.app.entity.payload.InvoicePaymentsRequest;
import com.dollop.app.entity.payload.InvoicePaymentsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.InvoicePaymentRepository;
import com.dollop.app.repository.InvoicesRepository;
import com.dollop.app.service.admin.InvoicePaymentsService;

@Service
public class InvoicePaymentsServiceImpl implements InvoicePaymentsService {

	@Autowired
	public InvoicesRepository invoicesRepository;

	@Autowired
	public InvoicePaymentRepository invoicePaymentRepository;

	@Autowired
	private ModelMapper modelMapper;

	public InvoicePaymentsResponse invoicePaymentsToInvoicePaymentsResponse(InvoicePayments invoicePayments) {
		return this.modelMapper.map(invoicePayments, InvoicePaymentsResponse.class);
	}

	public InvoicePayments invoicePaymentsRequestToInvoicePayments(InvoicePaymentsRequest invoicePaymentsRequest) {
		return this.modelMapper.map(invoicePaymentsRequest, InvoicePayments.class);
	}

	@Override
	public InvoicePaymentsResponse addInvoicePayments(InvoicePaymentsRequest invoicePaymentsRequest) {

		Invoices invoice = this.invoicesRepository.findById(invoicePaymentsRequest.getInvoiceId().getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.INVOCICES_NOT_FOUND + invoicePaymentsRequest.getInvoiceId().getId()));

		invoice.setPaidAmount((invoice.getPaidAmount() + invoicePaymentsRequest.getAmount()));
        if(invoice.getPaidAmount().equals(0)) {
        	invoice.setStatus("UnPaid");
        }
        else if(invoice.getPaidAmount().equals(invoice.getGrandTotal())) {
        	invoice.setStatus("Paid");
        }
        else {
        	invoice.setStatus("PartiallyPaid");
        }
		Optional<InvoicePayments> invoicePayment = this.invoicePaymentRepository.findByInvoiceId(invoice);
		
		if (invoicePayment.isPresent()) {
			InvoicePayments ips=invoicePayment.get();
          ips.setPaymentDate(invoicePaymentsRequest.getPaymentDate());
          ips.setStatus(invoicePaymentsRequest.getStatus());;
			ips.setAmount(ips.getAmount() + invoicePaymentsRequest.getAmount());
			this.invoicesRepository.save(invoice);
			return this.invoicePaymentsToInvoicePaymentsResponse(this.invoicePaymentRepository.save(ips));
		}

		else {

			InvoicePayments invoicePayments = this.invoicePaymentsRequestToInvoicePayments(invoicePaymentsRequest);
			this.invoicesRepository.save(invoice);

			return this.invoicePaymentsToInvoicePaymentsResponse(this.invoicePaymentRepository.save(invoicePayments));
		}
	}

	@Override
	public InvoicePaymentsResponse getInvoicePaymentsById(Integer id) {
		InvoicePayments invoicePaymentse = this.invoicePaymentRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.INVOCICES_NOT_FOUND + id));
		return this.invoicePaymentsToInvoicePaymentsResponse(invoicePaymentse);

	}

	@Override
	public InvoicePaymentsResponse updateInvoicePayments(InvoicePaymentsRequest invoicePaymentsRequest) {
		InvoicePayments invoicePaymentse = this.invoicePaymentRepository.findById(invoicePaymentsRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.INOVICE_PAYMENTS_NOT_FOUND + invoicePaymentsRequest.getId()));

		invoicePaymentse.setAmount(invoicePaymentsRequest.getAmount());
		invoicePaymentse.setNote(invoicePaymentsRequest.getNote());
		invoicePaymentse.setStatus(invoicePaymentsRequest.getStatus());
		return this.invoicePaymentsToInvoicePaymentsResponse(this.invoicePaymentRepository.save(invoicePaymentse));

	}

	@Override
	public Page<InvoicePaymentsResponse> getAllInvoicePayments(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<InvoicePayments> page = this.invoicePaymentRepository.findAll(pageRequest);
		return page.map(u -> this.invoicePaymentsToInvoicePaymentsResponse(u));
	}

	@Override
	public Boolean deleteTrainers(Integer id) {
		InvoicePayments invoices = this.invoicePaymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.INVOCICES_NOT_FOUND + id));

		invoices.setDeleted(true);
		this.invoicePaymentRepository.delete(invoices);
		return true;
	}

	@Override
	public Page<InvoicePaymentsResponse> getInvoicePaymentsByStatus(Integer pageNo, Integer pageSize, String status) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<InvoicePayments> originalPage = this.invoicePaymentRepository.findByStatus(page, status);

		return originalPage.map(t -> this.invoicePaymentsToInvoicePaymentsResponse(t));

	}

	@Override
	public Page<InvoicePaymentsResponse> getAllInoicePaymentOrderByDate() {
		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("paymentDate").descending());
		Page<InvoicePayments> page = this.invoicePaymentRepository.findAll(pageRequest);
		return page.map(u -> this.invoicePaymentsToInvoicePaymentsResponse(u));
		
	}

}
