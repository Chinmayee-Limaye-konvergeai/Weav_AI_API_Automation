package com.weavapi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class Defaultfilter {
	
	private String filter_name;
	//@JsonIgnore
	private String col_name;

	public String getFilter_name() {
		return filter_name;
	}

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	public void setFilter_name(String filter_name) {
		this.filter_name = filter_name;
	}

}
