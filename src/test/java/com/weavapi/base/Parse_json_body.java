package com.weavapi.base;

import java.util.ArrayList;
import java.util.List;

import com.weavapi.pojo.Bet;
import com.weavapi.pojo.Defaultfilter;
import com.weavapi.pojo.Filters;
import com.weavapi.pojo.Pojo_get_col_stats;
import com.weavapi.pojo.RowFilter;
import com.weavapi.pojo.SortObj;
import com.weavapi.pojo.add_body_pojo_get_row_all;
import com.weavapi.testCases.Data_Browser_API.TC_001_Add_by_path;
import com.weavapi.utilities.ReadConfig;

public class Parse_json_body {
	 
	public static int Row_count = 50;
	public static String file_name = "tinder1.parquet";
	static int start_row=1;
	
	
	static String default_filter_name="remove_missing_values";
	static String default_filter_name_col="Sell";
	
	
	public static List<String> myList = new ArrayList<String>();
	
	//static String[] columnarray = new String[] { "Single", "Question", "Count", "Segment Description", "Answer",
			//"Percentage", "Segment Type", "timestamp" };
	
	static String[] columnarray = new String[] { "Sell", "List", "Living", "Rooms", "Beds",
			"Baths", "Age", "Acres","Taxes"};
	static int sizes = columnarray.length;
	
	
	static int lowerlimit =1;
	static int upperlimit=500;
	static String row_filter_columon="Living";
	static String datatype_rowfiltercolumn ="float";
	
	public static String sort_column="Living";
	public static String order="ASC";
	
	
	public static String excel_file_name="/home/chinmayee/eclipse-workspace/Weav_AI_API_Automation/DataFiles/tinder.xlsx";
	
	
	static String[] Get_col_stats_columnarray = new String[] {"Count","Percentage","Segment Type"};

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
		//pojoobj.setDataset_id("58edd115-f7eb-436f-b9b9-303783a80a00");
		pojoobj.setVersion_id(TC_001_Add_by_path.versionid);
		
		//pojoobj.setVersion_id("1.0.1652097194");
		
		pojoobj.setUser_id("Sheshan01");
		pojoobj.setSession_id("session007");
		

		for (int i = 0; i < sizes; i++) {
			myList.add(columnarray[i]);

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
		d.setFilter_name(default_filter_name);
		d.setCol_name(default_filter_name_col);

		List<Defaultfilter> df = new ArrayList<>();
		df.add(d);

		pojoobj.setDefault_filter(df);
		pojoobj.setFile_name(file_name);
		pojoobj.setRow_count(Row_count);
		pojoobj.setStart_row(start_row);

		return pojoobj;
	}
	
	
	public static Pojo_get_col_stats GetBodyFromPojoGetColStats() 
	
	{
		
		        Pojo_get_col_stats obj1=new Pojo_get_col_stats(); 
		        
		        for (int i = 0; i < Get_col_stats_columnarray.length; i++) {
					myList.add(Get_col_stats_columnarray[i]);

				}
		        
		         obj1.setCol_names(myList);
				// obj1.setDataset_id(TC_001_Add_by_path.datasetid);
		         
		         obj1.setDataset_id("5c9167cd-005c-4411-b5b3-e31ac589eea5");
		         obj1.setVersion_id("1.0.1652271894"); 
				 //obj1.setVersion_id(TC_001_Add_by_path.versionid); 
				 obj1.setFile_name(file_name);
				 obj1.setSession_id("session007"); 
				 obj1.setUser_id("Sheshan01");
				 
				 return obj1;
		
	}
	
	
	
	
}
