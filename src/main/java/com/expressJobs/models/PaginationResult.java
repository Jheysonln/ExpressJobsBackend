package com.expressJobs.models;

import java.util.ArrayList;
import java.util.List;

public class PaginationResult<T> {
    private int totalRecords;
    private int pageNumber;
    private int pageSize;
    private List<T> data;

    public PaginationResult() {
        this.data = new ArrayList<>();
    }  
    
    public PaginationResult(List<T> data, int totalRecords) {
        this.data = data;
        this.totalRecords = totalRecords;
    }

    public PaginationResult(int totalRecords, int pageNumber, int pageSize, List<T> data) {
		super();
		this.totalRecords = totalRecords;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.data = data;
	}



	public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
