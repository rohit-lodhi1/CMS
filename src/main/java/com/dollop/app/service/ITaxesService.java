 package com.dollop.app.service;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.TaxesRequest;
import com.dollop.app.entity.payload.TaxesResponse;

public interface ITaxesService {

	public TaxesResponse addTaxes(TaxesRequest taxes); 
	   
	   public TaxesResponse getTaxesById(Integer id);
	   
	   public TaxesResponse updateTaxes(TaxesRequest trainers);
	   
	   public Page<TaxesResponse> getAllTaxes(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteTaxes(Integer id);
	   
	   public TaxesResponse updateTaxesStatus(Integer id,String status);
	   
	   public Page<TaxesResponse> getTaxesByStatus(Integer pageNo,Integer pageSize,String status);
	
}
