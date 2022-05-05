package com.weavapi.testCases.Data_Browser_API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.weavapi.base.Parse_json_body;
import com.weavapi.base.Test_Base;
import com.weavapi.utilities.ReadConfig;

public class TC_002_get_row_all_files extends   TC_001_Add_by_path{
	
	Response response;
	JsonPath js;
  
	
    
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
			int count=js.getInt("data[\"tinder.parquet\"].data.size()");
			Assert.assertEquals(count,Parse_json_body.Row_count);
		}
		
		@Test
		void checkcolumns()
		{
			
			logger.info("***********  Checking Column Names **********");
			
			Map<String, Integer> datamap = new HashMap<String, Integer>();
			datamap=(js.get("data[\"tinder.parquet\"].data[0]"));
			List<String> datacolumnname = new ArrayList<String>();
			for ( String key : datamap.keySet() ) 
			{
				datacolumnname.add(key);
			}
	         System.out.println(datacolumnname);  
				
				  boolean boolval= datacolumnname.containsAll(Parse_json_body.myList);
				  Assert.assertTrue(boolval);
				 
			 
			
		}
		
		@AfterClass
		void tearDown()
		{
			logger.info("*********  Finished TC_002_get_row_all_files **********");
		}
}

