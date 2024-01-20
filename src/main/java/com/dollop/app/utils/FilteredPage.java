 package com.dollop.app.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.dollop.app.entity.payload.UsersResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilteredPage<T> extends PageImpl<T> {

    public FilteredPage(List<T> content, Pageable pageable, long total, Page<?> page) {
		super(content, pageable, total);
		this.filteredContent=content;
		this.originalPage=page;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
//	private static final long serialVersionUID = -3513203060321211975L;
//
//	public FilteredPage(List<T> content, Pageable pageable, long total) {
//        super(content, pageable, total);
//    }
//
//    public static <T> FilteredPage<T> from(List<T> content, Page<?> originalPage, long filteredTotal) {
//        return new FilteredPage<>(content, originalPage.getPageable(), filteredTotal);
//    }
	 private  List<T> filteredContent;
	    private   Page<?> originalPage;

	    
	  
	    
	    
//	    public FilteredPage(List<T> filteredContent, Page<?> originalPage) {
//	        this.filteredContent = filteredContent;
//	        this.originalPage = originalPage;
//	    }

	    public void setFilteredContent(List<T> filteredContent) {
			this.filteredContent = filteredContent;
		}

		public void setOriginalPage(Page<?> originalPage) {
			this.originalPage = originalPage;
		}

		public List<?> getFilteredContent() {
			return filteredContent;
		}

		public Page<?> getOriginalPage() {
			return originalPage;
		}

		@Override
        public int getTotalPages() {
            return originalPage.getTotalPages();
        }

        @Override
        public long getTotalElements() {
            return originalPage.getTotalElements();
        }

//        @Override
//        public <U> Page<U> map(Function<? super User, ? extends U> converter) {
//            // Implement this if needed
//            return null;
//        }

        @Override
        public int getNumber() {
            return originalPage.getNumber();
        }

        @Override
        public int getSize() {
            return originalPage.getSize();
        }

        @Override
        public int getNumberOfElements() {
            return filteredContent.size();
        }

        @Override
        public List<T> getContent() {
            return filteredContent;
        }

        // Implement other methods from the Page interface...
   
}