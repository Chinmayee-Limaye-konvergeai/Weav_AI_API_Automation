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
import com.weavapi.utilities.ReadConfig;

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
			
			String columnname=Parse_json_body.sort_column;
			System.out.println(columnname);
			String sortorder=Parse_json_body.order;
			boolean bool;
			int size=js.getInt("data[\""+filename+"\"].data.size()");
			
			
			//Object value=js.get("data[\""+filename+"\"].data[0]."+columnname+"");
			
			Object value=js.get("data[\""+filename+"\"].data[0][\""+columnname+"\"]");
			//js.get("data[\"tinder.parquet\"].data[0].Count")
			
			System.out.println(value);
			
			String dataType = value.getClass().getSimpleName();
			System.out.println(dataType);
			
			if(dataType.equalsIgnoreCase("Integer"))
			{
			int strAr1;
			List<Integer> columnlist = new ArrayList<Integer>();
			
			for (int i=0;i<size;i++)
			{
				//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
				strAr1=js.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			
				
			
				
				columnlist.add(strAr1);
		   }
			
			List <Integer> copy = new ArrayList<Integer>(columnlist);
			if(sortorder =="ASC")
			{
			Collections.sort(copy);
			}
			else if(sortorder =="DSC")
			{
				Collections.sort(copy, Collections.reverseOrder());
			}
			bool=copy.equals(columnlist);
			Assert.assertTrue(bool);
			
			}
			
			else if (dataType.equalsIgnoreCase("String"))
			{
			String strAr1;
			List<String> columnlist = new ArrayList<String>();
			
			for (int i=0;i<size;i++)
			{
				//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
				strAr1=js.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			
				
				columnlist.add(strAr1);
		   }
			
			System.out.println(columnlist);
			List <String> copy = new ArrayList<String>(columnlist);
			if (sortorder =="ASC")
			{
			Collections.sort(copy);
			
			}
			else if(sortorder =="DSC")
			{
				Collections.sort(copy, Collections.reverseOrder());
				System.out.println(copy);
			}
			    bool=copy.equals(columnlist);
			    Assert.assertTrue(bool);
			
			}
			
			
			else if(dataType.equalsIgnoreCase("Boolean"))
			{
				boolean strAr1;
			List<Boolean> columnlist = new ArrayList<Boolean>();
			
			for (int i=0;i<size;i++)
			{
				//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
				strAr1=js.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			
				
			
				
				columnlist.add(strAr1);
		   }
			
			List <Boolean> copy = new ArrayList<Boolean>(columnlist);
			System.out.println(columnlist);
			if(sortorder =="ASC")
			{
			Collections.sort(copy);
			}
			else if(sortorder =="DSC")
			{
				Collections.sort(copy, Collections.reverseOrder());
				System.out.println(columnlist);
			}
			bool=copy.equals(columnlist);
			Assert.assertTrue(bool);
			
			}
			
			
			else if(dataType.equalsIgnoreCase("Float"))
			{
				float strAr1;
			List<Float> columnlist = new ArrayList<Float>();
			
			for (int i=0;i<size;i++)
			{
				//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
				strAr1=js.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			
				
			
				
				columnlist.add(strAr1);
		   }
			
			List <Float> copy = new ArrayList<Float>(columnlist);
			System.out.println(columnlist);
			if(sortorder =="ASC")
			{
			Collections.sort(copy);
			}
			else if(sortorder =="DSC")
			{
				Collections.sort(copy, Collections.reverseOrder());
				System.out.println(columnlist);
			}
			bool=copy.equals(columnlist);
			Assert.assertTrue(bool);
			
			}
			
			
		}
		
		
		@AfterClass
		void tearDown()
		{
			logger.info("*********  Finished TC_002_get_row_all_files **********");
		}
}

