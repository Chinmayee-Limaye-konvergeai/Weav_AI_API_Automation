package com.weavapi.testCases.Data_Browser_API;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.weavapi.base.Parse_json_body;
import com.weavapi.utilities.ReadConfig;
import com.weavapi.utilities.Read_excel_utility;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC_003_get_col_stats extends   TC_001_Add_by_path {
	
	
	Response response;
	public static JsonPath js;
	public static Logger logger=LogManager.getLogger(Base.class.getName());
	
	 @BeforeTest(alwaysRun=true)
		void getcolstatsapi() throws IOException
		{
			  
			  
			  
			  logger.info("*********Started TC_003_get_col_stats **********");
	    	
			  ReadConfig readconf=new ReadConfig();
			  RestAssured.baseURI=readconf.getDataBrowserURL();
				
		response=given().log().all().header("Content-Type","application/json")
		.body(Parse_json_body.GetBodyFromPojoGetColStats())
		.when().post("/api/v1/get_col_stats")
		.then().extract().response();
		
		
		System.out.println("**********************************Resonse Data*************************************");
		String string_resp=response.asString();
		
		System.out.println(string_resp);
		js=new JsonPath(string_resp);
		
		}
	 
	 
	 @Test
		void checkStatusCode()
		{
			logger.info("***********  Checking Status Code **************");
			int statuscode =response.getStatusCode();
			Assert.assertEquals(statuscode, 200);
			
		}
		
		
		@Test
		void checkstatusLine()
		{
			logger.info("***********  Checking Status Line **************");
			String statusLine = response.getStatusLine(); // Gettng status Line
			Assert.assertEquals(statusLine, "HTTP/1.0 200 OK");
			
		}
		
		
		
		@Test
		void checkResposeBody()
		{
			logger.info("***********  Checking Respose Body **************");
			String responseBody = response.getBody().asString();
			Assert.assertTrue(responseBody!=null);
			
		}
		
		
		
		
		
		@Test
		void checkResponseTime()
		{
			logger.info("***********  Checking Response Time  *************");
			long responseTime = response.getTime(); // Getting status Line
			//System.out.println(responseTime);
			Assert.assertTrue(responseTime<10000);
			
				
		}
		
		
		
		@Test
		 void checkmessage()
			{
			 logger.info("***********  Checking Message ********************");
				
			 String message=js.get("status.result");
				Assert.assertEquals(message, "success");
				
			}
		
		
		@Test
		void checkcolumns()
		{
			
			logger.info("***********  Checking Column Names **********");
			
			Map<String, Integer> datamap = new HashMap<String, Integer>();
			datamap=(js.get("data."));
			List<String> datacolumnname = new ArrayList<String>();
			for ( String key : datamap.keySet() ) 
			{
				datacolumnname.add(key);
				
				//System.out.println(key); 
			}
	        // System.out.println(datacolumnname);  
				
				  boolean boolval= datacolumnname.containsAll(Parse_json_body.myList);
				  Assert.assertTrue(boolval);
				 
			 
			
		}
		
		
		
		@Test
		void CheckSummary() throws Exception
		{
			
			logger.info("***********  Checking Columns and Rows Count Summary **********");
			
			 Read_excel_utility excelObj = new Read_excel_utility(Parse_json_body.excel_file_name);
		       
		     
		       int rowCount = excelObj.getRowCount();
		     
		       
		       
		       int summary_total_rows=js.getInt("data.Count.total_rows");
		    
		       
		       
		       Assert.assertEquals(summary_total_rows,rowCount);
		       
		       
			
			
			
		}
	
		 
	
	 
	 @AfterTest(alwaysRun=true)
		void tearDown()
		{
			logger.info("*********  Finished TC_003_get_col_stats **********");
		}
	

}
