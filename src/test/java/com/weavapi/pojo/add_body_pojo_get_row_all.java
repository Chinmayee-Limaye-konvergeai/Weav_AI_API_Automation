package com.weavapi.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class add_body_pojo_get_row_all {
	
	private String dataset_id;
	private String version_id;
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
	
	

}
