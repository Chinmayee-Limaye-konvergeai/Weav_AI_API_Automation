package com.weavapi.pojo;

import java.util.List;

public class Operations {

	
	private String opr_name;
	private String method;
	private List <String> col_names;
	
	
	//private Argument args;
	public String getOpr_name() {
		return opr_name;
	}
	public void setOpr_name(String opr_name) {
		this.opr_name = opr_name;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<String> getCol_names() {
		return col_names;
	}
	public void setCol_names(List<String> col_names) {
		this.col_names = col_names;
	}
}
