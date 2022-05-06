package com.weavapi.testCases.Data_Browser_API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.weavapi.base.Parse_json_body;
import com.weavapi.base.Test_Base;
import com.weavapi.utilities.Check_sorted_columns;
import com.weavapi.utilities.ReadConfig;
import com.weavapi.utilities.Read_excel_utility;

public class TC_002_get_row_all_files extends   TC_001_Add_by_path{
	
	Response response;
	public static JsonPath js;
	String filename=Parse_json_body.file_name;
	
  
	
    
	  @BeforeClass
	void getrowapi() throws IOException
	{
		  
		  
		  
		  logger.info("*********Started TC_002_get_row_all_files **********");
    	
		  ReadConfig readconf=new ReadConfig();
		  RestAssured.baseURI=readconf.getDataBrowserURL();
			
	response=given().log().all().header("Content-Type","application/json")
	.body(Parse_json_body.GetBodyFromPojo())
	.when().post("/api/v1/get_rows")
	.then().extract().response();
	
	
	System.out.println("**********************************Resonse Data*************************************");
	String string_resp=response.asString();
	
	System.out.println(string_resp);
	js=new JsonPath(string_resp);
	
	}
	  
	  
	  
	 @Test
		void checkStatusCode()
		{
		 logger.info("***********  Checking Status Code **********");
			int statuscode =response.getStatusCode();
			Assert.assertEquals(statuscode, 200);
			
		}
	 
	 
	 @Test
		void checkstatusLine()
		{
		 logger.info("***********  Checking Status Line **********");
			String statusLine = response.getStatusLine(); // Gettng status Line
			Assert.assertEquals(statusLine, "HTTP/1.0 200 OK");
			
		}
	 
	 
	 @Test
		void checkResposeBody()
		{
			
		 logger.info("***********  Checking Response  Body **********");
			String responseBody = response.getBody().asString();
			Assert.assertTrue(responseBody!=null);
			
		}
		
		
		
		
		
		@Test
		void checkResponseTime()
		{
			logger.info("***********  Checking Response  Time **********");
			long responseTime = response.getTime(); // Getting status Line
			Assert.assertTrue(responseTime<7000);
			
				
		}
		
		
		@Test
		void checkRowCount()
		{
			logger.info("***********  Checking Row   Count **********");
			int count=js.getInt("data[\""+filename+"\"].data.size()");
			Assert.assertEquals(count,Parse_json_body.Row_count);
		}
		
		@Test
		void checkcolumns()
		{
			
			logger.info("***********  Checking Column Names **********");
			
			Map<String, Integer> datamap = new HashMap<String, Integer>();
			datamap=(js.get("data[\""+filename+"\"].data[0]"));
			List<String> datacolumnname = new ArrayList<String>();
			for ( String key : datamap.keySet() ) 
			{
				datacolumnname.add(key);
			}
	         //System.out.println(datacolumnname);  
				
				  boolean boolval= datacolumnname.containsAll(Parse_json_body.myList);
				  Assert.assertTrue(boolval);
				 
			 
			
		}
		
		
		@Test
		void checkSortcolumn()
		{
			
			logger.info("***********  Checking Sorted  Columns **********");
			boolean bool;
			
			Check_sorted_columns Check_obj=new Check_sorted_columns();
			bool =Check_obj.check_sorted(js);
			Assert.assertTrue(bool);
			
			
			
			
		}
		
		@Test
		void CheckSummary() throws Exception
		{
			
			logger.info("***********  Checking Columns and Rows Count Summary **********");
			
			 Read_excel_utility excelObj = new Read_excel_utility(Parse_json_body.excel_file_name);
		       int colCount = excelObj.getColumnCount();
		      // System.out.println("Total Columns in the Excel : "+colCount);
		       int rowCount = excelObj.getRowCount();
		       //System.out.println("Total Rows in the Excel : "+rowCount);
		      // int numericalCount=excelObj.checknumerical();
		       
		       int summary_total_column=js.getInt("data[\""+filename+"\"].summary.total_columns");
		       int summary_total_rows=js.getInt("data[\""+filename+"\"].summary.total_rows");
		     //  int summary_total_numerical=js.getInt("data[\""+filename+"\"].summary.numerical_cols");
		       
		       Assert.assertEquals(summary_total_column,colCount);
		       Assert.assertEquals(summary_total_rows,rowCount);
		       //Assert.assertEquals(summary_total_numerical, numericalCount);
		       
			
			
			
		}
		
		
		@AfterClass
		void tearDown()
		{
			logger.info("*********  Finished TC_002_get_row_all_files **********");
		}
}

