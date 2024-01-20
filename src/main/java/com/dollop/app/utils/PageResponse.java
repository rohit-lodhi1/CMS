package com.dollop.app.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class PageResponse<T> extends PageImpl<T>{

	private static final long serialVersionUID = -624043072592586260L;

	public PageResponse(List<T> content) {
		super(content);
		
	}

	public PageResponse(List<T> content,Page originalPage,long contentSize) {
		super(content);
		this.pageable = originalPage.getPageable();
		this.content = content;
		this.number = originalPage.getNumber();
		this.numberOfElements = originalPage.getNumberOfElements();
		this.sort = originalPage.getSort();
		this.totalElements = originalPage.getTotalElements();
		this.totalPages = originalPage.getTotalPages();
	}
	
	private List<T> content;
	
	private Pageable pageable;
	
	private int number;
	
	private int numberOfElements;
	
	private Sort sort;
	
	private long totalElements;
	
	private int totalPages;

}
