package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.InvoicePayments;
import com.dollop.app.entity.Invoices;

public interface InvoicePaymentRepository extends JpaRepository<InvoicePayments,Integer>{

	Optional<InvoicePayments> findByIdAndDeleted(Integer id, boolean b);

	Page<InvoicePayments> findByStatus(PageRequest page, String status);

	Optional<InvoicePayments> findByInvoiceId(Invoices invoice);



}
