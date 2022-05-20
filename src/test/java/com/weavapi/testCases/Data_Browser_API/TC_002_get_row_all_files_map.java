package com.weavapi.testCases.Data_Browser_API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
//import com.weavapi.base.Parse_json_body;
import com.weavapi.base.Test_Base;
import com.weavapi.base.samplemapper;
import com.weavapi.utilities.Check_sorted_columns;
import com.weavapi.utilities.ReadConfig;
import com.weavapi.utilities.Read_excel_utility;

public class TC_002_get_row_all_files_map extends   TC_001_Add_by_path{
	
	Response response;
	public static JsonPath js;
	
	 Map<String, Object> mapObject;
	//String filename=Parse_json_body.file_name;
	//String filename=parse_body
	/*
	 * public static Map<String, Object> mapObject1=samplemapper.parse_body();
	 * 
	 * String filename;
	 * 
	 * List<String> mylist = (List<String>) mapObject1.get("show_cols");
	 * 
	 * int rowcount= (int) mapObject1.get("file_name");
	 */
	
	String excel_file_name=System.getProperty("user.dir")+"/DataFiles/tinder.xlsx";
	
	public static String filename;
	
	public static int rowcount;
	
	public static List<String> mylist;
	
	public static String sort_column;
	
	public static String order;
	
	public static Logger logger=LogManager.getLogger(Base.class.getName());
	
	public static List<String> operation_col_name;
	
	 
	
    
	  @SuppressWarnings("unchecked")
	@BeforeTest(alwaysRun=true)
	void getrowapi() throws IOException
	{
		  
		
		  File jsonFile = new File(
				  System.getProperty("user.dir")+"/JSONFiles/get_rows.json" );
		  
		  ObjectMapper mapper = new ObjectMapper();
		  
		  mapObject = mapper.readValue(jsonFile,new
		  TypeReference<Map<String, Object>>() {});
		  
		  mapObject.put("dataset_id", TC_001_Add_by_path.datasetid);
		  
		 mapObject.put("version_id", TC_001_Add_by_path.versionid);
		  
		  //mapObject.put("dataset_id", "18e71442-4b55-46a6-bbb0-3a263a14cb36");
		 // mapObject.put("version_id", "1.0.1652776082");
		  
		  
		  logger.info("*********Started TC_002_get_row_all_files **********");
    	
		  ReadConfig readconf=new ReadConfig();
		  RestAssured.baseURI=readconf.getDataBrowserURL();
			
	response=given().log().all().header("Content-Type","application/json")
	.body(mapObject)
	.when().post("/api/v1/get_rows")
	.then().extract().response();
	
	
	System.out.println("**********************************Resonse Data*************************************");
	String string_resp=response.asString();
	
	System.out.println(string_resp);
	js=new JsonPath(string_resp);
	
	
	
	try
	{
	
	filename=(String) mapObject.get("file_name");
	rowcount= (int) mapObject.get("row_count");
	mylist = (List<String>) mapObject.get("show_cols");
	
	
	Map<String, Object>sortobj=(Map<String, Object>) mapObject.get("sort_obj");
	
	sort_column=(String) sortobj.get("col_name");
	
	order=(String) sortobj.get("order");
	
	
	
	
	
	
	}
	
	catch(NullPointerException e) {
		System.out.println("NullPointerException thrown!");
	}
	
	
	
	
	}
	  
	  
	  
	 @Test(groups = { "positive_test_case" })
		void checkStatusCode()
		{
		 logger.info("***********  Checking Status Code **********");
			int statuscode =response.getStatusCode();
			Assert.assertEquals(statuscode, 200);
			
		}
	 
	 
	 @Test(groups = { "positive_test_case" })
		void checkstatusLine()
		{
		 logger.info("***********  Checking Status Line **********");
			String statusLine = response.getStatusLine(); // Gettng status Line
			Assert.assertEquals(statusLine, "HTTP/1.0 200 OK");
			
		}
	 
	 
	 @Test(groups = { "positive_test_case" })
		void checkResposeBody()
		{
			
		 logger.info("***********  Checking Response  Body **********");
			String responseBody = response.getBody().asString();
			Assert.assertTrue(responseBody!=null);
			
		}
		
		@Test(groups = { "positive_test_case" })
	 void checkmessage()
		{
		 logger.info("***********  Checking Message ***************");
			
		 String message=js.get("status.result");
			Assert.assertEquals(message, "success");
			
		}
		
		
		@Test(groups = { "positive_test_case" })
		void checkResponseTime()
		{
			logger.info("***********  Checking Response  Time **********");
			long responseTime = response.getTime(); // Getting status Line
			Assert.assertTrue(responseTime<7000);
			
				
		}
		
		
		
		  @Test (groups = { "positive_test_case" })
		  void checkRowCount() 
		  {
			  
		  logger.info("***********  Checking Row   Count **********"); 
		  int  count=js.getInt("data[\""+filename+"\"].data.size()");
		  Assert.assertEquals(count,rowcount); 
		  
		  }
		  
		  @Test (groups = { "positive_test_case" })
		  void checkcolumns() {
		  
		  logger.info("***********  Checking Column Names **********");
		  
		  Map<String, Integer> datamap = new HashMap<String, Integer>();
		  datamap=(js.get("data[\""+filename+"\"].data[0]")); 
		  List<String> datacolumnname = new ArrayList<String>(); 
		  for ( String key : datamap.keySet() ) 
		  { 
			  datacolumnname.add(key); 
		  } //System.out.println(datacolumnname);
		  
		  boolean boolval= datacolumnname.containsAll(mylist);
		  Assert.assertTrue(boolval);
		  
		  
		  
		  }
		 
		
		
		  @Test (groups = { "positive_test_case" })
		  void checkSortcolumn() 
		  {
		  
		  logger.info("***********  Checking Sorted  Columns **********"); 
		  boolean bool;
		  
		  Check_sorted_columns Check_obj=new Check_sorted_columns(); 
		  bool=Check_obj.check_sorted(js); 
		  Assert.assertTrue(bool);
		  
		  
		  
		  
		  }
		 
		
		
		  @Test (groups = { "positive_test_case" })
		  void CheckSummary() throws Exception {
		  
		  logger.info("***********  Checking Columns and Rows Count Summary **********"
		  );
		  
		  Read_excel_utility excelObj = new Read_excel_utility(excel_file_name); 
		  int colCount = excelObj.getColumnCount(); //
		  System.out.println("Total Columns in the Excel : "+colCount); 
		  int row_Count =excelObj.getRowCount();
		  //System.out.println("Total Rows in the Excel : "+rowCount);
		//  int numericalCount=excelObj.checknumerical();
		  
		  int summary_total_column=js.getInt("data[\""+filename+"\"].summary.total_columns"); 
		  int summary_total_rows=js.getInt("data[\""+filename+"\"].summary.total_rows"); //
		  //int summary_total_numerical=js.getInt("data[\""+filename+"\"].summary.numerical_cols");
		  
		  Assert.assertEquals(summary_total_column,colCount);
		  Assert.assertEquals(summary_total_rows,row_Count);
		  //Assert.assertEquals(summary_total_numerical, numericalCount);
		  
		  
		  
		  
		  }
		  
		  
		  
		  @SuppressWarnings("unchecked")
		@Test (groups = { "positive_test_case" })
		  void CheckAutofillMissing() throws Exception {
		  
		  logger.info("***********  Checking Columns should not be null **********");
		  
		  int datasize=js.getInt("data[\""+filename+"\"].data.size()");
		  
		  List<Map<String,Object>> operationobj = (List<Map<String, Object>>) mapObject.get("operations");
			int size=operationobj.size();
			for(int i=0;i<size;i++)
	{
				operation_col_name=(List<String>) operationobj.get(i).get("col_names");
				
				
				//System.out.println(operation_col_name);
				
	try {
				
			for(int j=0;j<operation_col_name.size();j++)
			{
				for(int k=0;k<datasize;k++)
				{
					String columnname=operation_col_name.get(j);
					Object strAr1=js.get("data[\""+filename+"\"].data["+k+"][\""+columnname+"\"]");
					Assert.assertTrue(strAr1!=null);
					
				}
			}
			
		}
				
				catch(NullPointerException e) {
					System.out.println("NullPointerException thrown!");
				}
				
	}
		  
		  
		  
		  
		  
		  
		  }
		  
		  @Test (groups = { "negative_test_case" })
		  void CheckBadRequest()
		  {
			  
			  logger.info("***********  Checking required field **********");
			  int statuscode =response.getStatusCode();
				Assert.assertEquals(statuscode, 400);
				Assert.assertEquals(js.get("status.result"), "fail");
			  
			  
		  }
		 
		  
		  @Test (groups = { "negative_test_case" })
		  void CheckFileNotFound()
		  {
			  
			  logger.info("***********  Checking file  is present **********");
			  int statuscode =response.getStatusCode();
				Assert.assertEquals(statuscode, 500);
				Assert.assertEquals(js.get("data"), "File Not Found");
			  
			  
		  }
		
		
		@AfterTest(alwaysRun=true)
		void tearDown()
		{
			logger.info("*********  Finished TC_002_get_row_all_files **********");
		}
}

