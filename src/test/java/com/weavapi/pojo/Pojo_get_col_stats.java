package com.weavapi.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Pojo_get_col_stats {
	
	private String dataset_id;
	private String version_id;
	private String user_id;
	private String session_id;
	
	private String file_name;
	
	private List<String> col_names;
	
	
	
	
	public String getDataset_id() {
		return dataset_id;
	}


	public void setDataset_id(String dataset_id) {
		this.dataset_id = dataset_id;
	}


	public String getVersion_id() {
		return version_id;
	}


	public void setVersion_id(String version_id) {
		this.version_id = version_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getSession_id() {
		return session_id;
	}


	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}


	public String getFile_name() {
		return file_name;
	}


	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}


	

	
	

	public List<String> getCol_names() {
		return col_names;
	}


	public void setCol_names(List<String> col_names) {
		this.col_names = col_names;
	}


	/*
	 * public static void main(String[] args) throws JsonProcessingException { //
	 * TODO Auto-generated method stub
	 * 
	 * Pojo_get_col_stats obj=new Pojo_get_col_stats(); List<String> myList =new
	 * ArrayList<String>(); myList.add("Count"); myList.add("Percentage");
	 * 
	 * obj.setCol_names(myList); obj.setDataset_id("123");
	 * obj.setVersion_id("abcd"); obj.setFile_name("tinder.parquet");
	 * obj.setSession_id("Chinmayee"); obj.setUser_id("limaye");
	 * 
	 * ObjectMapper objectMapper = new ObjectMapper(); String employeeJson =
	 * objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	 * System.out.println("Serialization..."); System.out.println(employeeJson);
	 * 
	 * 
	 * 
	 * }
	 */

}
