package com.weavapi.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class RowFilter {
	
	private String datatype;
	private Filters filters;
	private String col_name;
	
	
	
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public Filters getFilters() {
		return filters;
	}
	public void setFilters(Filters filters) {
		this.filters = filters;
	}
	public String getCol_name() {
		return col_name;
	}
	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	
	

}
