package com.dollop.app.serviceImpl.admin;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.ResourceEncoder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Clients;
import com.dollop.app.entity.InvoicePayments;
import com.dollop.app.entity.Invoices;
import com.dollop.app.entity.InvoicesItems;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.InvoicesResponse;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.InvoicePaymentRepository;
import com.dollop.app.repository.InvoicesRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.IInvoicesService;

@Service
public class InvoicesServiceImpl implements IInvoicesService {

	@Autowired
	public InvoicesRepository invoicesRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public InvoicePaymentRepository invoicePaymentRepository;

	public InvoicesResponse ivoicesToInvoicesResponse(Invoices invoices) {
		return this.modelMapper.map(invoices, InvoicesResponse.class);
	}

	public Invoices ivoicesRequestToInvoices(InvoicesRequest invoicesRequest) {
		return this.modelMapper.map(invoicesRequest, Invoices.class);
	}

	@Override
	public InvoicesResponse addInvoices(InvoicesRequest invoices) {

		Invoices invoice = this.ivoicesRequestToInvoices(invoices);
		invoice.setIId(UUID.randomUUID().toString());
		invoice.setPaidAmount(0L);

		invoice = this.invoicesRepository.save(invoice);
		InvoicePayments invoicePayments = new InvoicePayments();
		invoicePayments.setInvoiceId(invoice);
		invoicePayments.setAmount(0L);
		invoicePayments.setDeleted(false);
		invoicePayments.setPaymentDate(invoice.getBillDate());
		invoicePaymentRepository.save(invoicePayments);
		InvoicesResponse invoiceResponse = this.ivoicesToInvoicesResponse(invoice);

		return invoiceResponse;
	}

	@Override
	public InvoicesResponse updateInvoices(InvoicesRequest invoices) {

		Invoices invoice = this.invoicesRepository.findById(invoices.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.INVOCICES_NOT_FOUND + invoices.getId()));
		// invoice.setBillDate(invoices.getBillDate());
		invoice.setClientId(invoices.getClientId());
		invoice.setDeleted(invoices.getDeleted());
		invoice.setDueDate(invoices.getDueDate());
		invoice.setNote(invoices.getNote());
		invoice.setProjectId(invoices.getProjectId());
		invoice.setStatus(invoices.getStatus());
		invoice.setTaxId(invoices.getTaxId());
		invoice.setInvoicesItems(invoices.getInvoicesItems());
		invoice.setBillDate(invoices.getBillDate());
		invoice.setDiscount(invoices.getDiscount());
		invoice.setDiscountPercentage(invoices.getDiscountPercentage());
		invoice.setGrandTotal(invoices.getGrandTotal());
		invoice.setTotal(invoices.getTotal());
		invoice.setTaxCost(invoices.getTaxCost());
		return this.ivoicesToInvoicesResponse(this.invoicesRepository.save(invoice));

	}

	@Override
	public Page<InvoicesResponse> getAllInvoices(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Invoices> page = this.invoicesRepository.findAll(pageRequest);
		return page.map(u -> this.ivoicesToInvoicesResponse(u));

	}

	@Override

	public Boolean deleteInvoices(Integer id) {
		Invoices invoices = this.invoicesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.INVOCICES_NOT_FOUND + id));

		invoices.setDeleted(true);
		this.invoicesRepository.save(invoices);
		return true;

	}

	@Override
	public InvoicesResponse getInvoicesById(Integer id) {
		Invoices invoices = this.invoicesRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.INVOCICES_NOT_FOUND + id));
		return this.ivoicesToInvoicesResponse(invoices);

	}

	@Override
	public Page<InvoicesResponse> searchInvoices(Integer pageNo, Integer pageSize, InvoicesRequest invoices) {

		invoices.setInvoicesItems(null);
		invoices.setDiscountPercentage(null);
		// invoices.setId(null);
		invoices.setClientId(null);
		invoices.setProjectId(null);
		invoices.setDiscount(null);
		invoices.setDiscountPercentage(null);
		invoices.setGrandTotal(null);
		invoices.setIId(null);
		invoices.setInvoicesItems(null);
		invoices.setId(null);
		invoices.setInvoicesItems(null);
		invoices.setTaxCost(null);
		invoices.setTaxId(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); // contains for string
		// for

		Example<Invoices> example = Example.of(this.ivoicesRequestToInvoices(invoices), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<Invoices> page = this.invoicesRepository.findAll(example, pageable);
		return page.map(u -> this.ivoicesToInvoicesResponse(u));

	}

	@Override
	public InvoicesResponse createInvoiceItemByInvoiceItems(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<InvoicesResponse> getAllInvoicesOrderByDate() {
		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("billDate").descending());
		Page<Invoices> page = this.invoicesRepository.findAll(pageRequest);
		return page.map(u -> this.ivoicesToInvoicesResponse(u));

	}

//	public InvoicesResponse createInvoiceItemByInvoiceItems(Integer id) {
//		
//		Invoices invoice=this.invoicesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(" invoices Not Found with id : "+id ));
//	InvoicesItems invoicesItems=new InvoicesItems();
//	invoicesItems.getQuantity()
//	
//		return null;
//	}

}
