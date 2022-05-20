package com.weavapi.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class add_body_pojo_get_row_all {
	
	private String dataset_id;
	private String version_id;
	
	private String user_id;
	private String session_id;
	
	private List<String> show_cols;
	//@JsonIgnore
	private List<RowFilter> row_filter;
	//@JsonIgnore
    private SortObj sort_obj;
	//@JsonIgnore
	private List<Defaultfilter> default_filter;
	private String file_name;
	//@JsonIgnore
	private int row_count;
	//@JsonIgnore
	private int start_row;
	
	private List<Operations> operations;
	
	
	
	public List<Operations> getOperations() {
		return operations;
	}
	public void setOperations(List<Operations> operations) {
		this.operations = operations;
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
	public List<String> getShow_cols() {
		return show_cols;
	}
	public void setShow_cols(List<String> show_cols) {
		this.show_cols = show_cols;
	}
	public List<RowFilter> getRow_filter() {
		return row_filter;
	}
	public void setRow_filter(List<RowFilter> row_filter) {
		this.row_filter = row_filter;
	}
	public SortObj getSort_obj() {
		return sort_obj;
	}
	public void setSort_obj(SortObj sort_obj) {
		this.sort_obj = sort_obj;
	}
	public List<Defaultfilter> getDefault_filter() {
		return default_filter;
	}
	public void setDefault_filter(List<Defaultfilter> default_filter) {
		this.default_filter = default_filter;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getRow_count() {
		return row_count;
	}
	public void setRow_count(int row_count) {
		this.row_count = row_count;
	}
	public int getStart_row() {
		return start_row;
	}
	public void setStart_row(int start_row) {
		this.start_row = start_row;
	}
	
	
	
	/**
	 * @param args
	 * @throws JsonProcessingException
	 */
	public static void main(String[] args) throws JsonProcessingException {
		
		add_body_pojo_get_row_all obj=new add_body_pojo_get_row_all();
		List<String> myList =new ArrayList<String>();
		
		myList.add("Single");
		myList.add("Question");
		obj.setShow_cols(myList);
		obj.setDataset_id("e43e9210-d8d7-4c8e-b1f2-7bad73ae74f8");
		obj.setVersion_id("1.0.1651552866");
		obj.setFile_name("tinder.parquet");
		obj.setRow_count(10);
		obj.setStart_row(2);
		
		RowFilter r=new RowFilter();
		Bet b=new Bet();
		
		b.setLowlt(5);
		b.setUpplt(10);
		b.setInclusive("both");
		
		
		
		  Filters f=new Filters(); 
		  f.setBet(b); 
		  f.setOpr("xyz"); 
		  f.setVal("abc");
		  
		  r.setFilters(f); 
		  r.setCol_name("Count"); 
		  r.setDatatype("int");
		 
		
		  List<RowFilter> rf=new ArrayList<>();
		  rf.add(r);
		  obj.setRow_filter(rf);
		
		//obj.setRow_filter(rf);
		
		SortObj so=new SortObj();
		so.setCol_name("count");
		so.setOrder("asc");
		
		
		obj.setSort_obj(so);
		
		Defaultfilter d=new Defaultfilter();
		d.setFilter_name("abc");
		d.setCol_name("order");
		
		List<Defaultfilter> df=new ArrayList<>();
		//List<String> myList =new ArrayList<String>();
		df.add(d);
		obj.setDefault_filter(df);
		
		List<Operations> array_op=new ArrayList<>();
		
		

		Operations op =new Operations();
		op.setOpr_name("autofill");
		op.setMethod("autofill");
		
		List <String> col_names =new  ArrayList<String>();
		col_names.add("order");
		col_names.add("age");
		
		op.setCol_names(col_names);
		
		
		Operations op1 =new Operations();
		op1.setOpr_name("missing");
		op.setMethod("leftfill");
		
		List <String> col_names1=new  ArrayList<String>();
		col_names1.add("bath");
		col_names1.add("sell");
		
		op1.setCol_names(col_names1);
		
		
		
		array_op.add(op);
		array_op.add(op1);
		
		obj.setOperations(array_op);
		
		
		
		
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		System.out.println("Serialization...");
		System.out.println(employeeJson);
		
		
		
		
		
		
		
	}
	

}
