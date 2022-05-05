package com.weavapi.base;

import java.util.ArrayList;
import java.util.List;

import com.weavapi.pojo.Bet;
import com.weavapi.pojo.Defaultfilter;
import com.weavapi.pojo.Filters;
import com.weavapi.pojo.RowFilter;
import com.weavapi.pojo.SortObj;
import com.weavapi.pojo.add_body_pojo_get_row_all;
import com.weavapi.testCases.Data_Browser_API.TC_001_Add_by_path;

public class Parse_json_body {

	public static int Row_count = 10;
	static String file_name = "tinder.parquet";
	static String filter_name="remove_missing_values";
	
	public static List<String> myList = new ArrayList<String>();
	static String[] strAr1 = new String[] { "Single", "Question", "Count", "Segment Description", "Answer",
			"Percentage", "Segment Type", "timestamp" };
	static int sizes = strAr1.length;
	static int lowerlimit =1;
	static int upperlimit=50;
	static String row_filter_columon="Count";
	static String sort_column="Count";
	static String datatype_rowfiltercolumn ="int";
	static String order="ASC";
	static int start_row=1;

	/*
	 * public static String GetBodyGetRow()
	 * 
	 * 
	 * {
	 * 
	 * String dataset_id=TC_001_Add_by_path.datasetid; String
	 * version_id=TC_001_Add_by_path.versionid; // String user_id="Sheshan01";
	 * //String session_id="session007";
	 * 
	 * 
	 * //Add_body_get_row_all_files obj=new Add_body_get_row_all_files();
	 * 
	 * //String[] strAr1=new String[] {"Single", "Question",
	 * "Segment","Count","Segment Description","Answer","Percentage","timestamp"};
	 * 
	 * String body= "{\n" + "    \"dataset_id\": \""+dataset_id+"\",\n" +
	 * "    \"version_id\": \""+version_id+"\",\n" +
	 * "    \"user_id\": \""+user_id+"\",\n" +
	 * "    \"session_id\": \""+session_id+"\",\n" +
	 * "    \"file_name\": \""+file_name+"\"\n" + "   \n" + "    \n" + "}";
	 * 
	 * 
	 * String body="{\n" + "    \"dataset_id\": \""+dataset_id+"\",\n" +
	 * "    \"version_id\": \""+version_id+"\",\n" + "    \"show_cols\": [\n" +
	 * "        \"Single\",\n" + "        \"Question\",\n" +
	 * "        \"Segment Type\",\n" + "        \"Count\",\n" +
	 * "        \"Segment Description\",\n" + "        \"Answer\",\n" +
	 * "        \"Percentage\",\n" + "        \"timestamp\"\n" + "    ],\n" +
	 * "    \"row_filter\": [],\n" + "    \"sort_obj\": {},\n" +
	 * "    \"default_filter\": [\n" + "        {\n" +
	 * "            \"filter_name\": \""+filter_name+"\"\n" + "        }\n" +
	 * "    ],\n" + "    \"file_name\": \""+file_name+"\",\n" +
	 * "    \"row_count\":"+Row_count+ ",\n" + "    \"start_row\": 20\n" + "}";
	 * return body;
	 * 
	 * 
	 * }
	 */

	public static add_body_pojo_get_row_all GetBodyFromPojo() 
	{
		
		add_body_pojo_get_row_all pojoobj = new add_body_pojo_get_row_all();
		pojoobj.setDataset_id(TC_001_Add_by_path.datasetid);
		pojoobj.setVersion_id(TC_001_Add_by_path.versionid);

		for (int i = 0; i < sizes; i++) {
			myList.add(strAr1[i]);

		}
		pojoobj.setShow_cols(myList);

		Bet b = new Bet();
		b.setLowlt(lowerlimit);
		b.setUpplt(upperlimit);
		b.setInclusive("both");

		Filters f = new Filters();
		f.setOpr(null);
		f.setVal(null);
		f.setBet(b);

		RowFilter r = new RowFilter();
		r.setDatatype(datatype_rowfiltercolumn);
		r.setFilters(f);
		r.setCol_name(row_filter_columon);

		List<RowFilter> rf = new ArrayList<>();
		rf.add(r);

		pojoobj.setRow_filter(rf);

		SortObj so = new SortObj();
		so.setCol_name(sort_column);
		so.setOrder(order);

		pojoobj.setSort_obj(so);

		Defaultfilter d = new Defaultfilter();
		d.setFilter_name(filter_name);

		List<Defaultfilter> df = new ArrayList<>();
		df.add(d);

		pojoobj.setDefault_filter(df);
		pojoobj.setFile_name(file_name);
		pojoobj.setRow_count(Row_count);
		pojoobj.setStart_row(start_row);

		return pojoobj;
	}
}
