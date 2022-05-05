package com.weavapi.testCases.Data_Browser_API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.weavapi.base.Test_Base;
import com.weavapi.utilities.ReadConfig;





public class TC_001_Add_by_path extends Test_Base{
	
	Response response;
	public static String datasetid;
	public static String versionid;
	//JsonPath js;
	
	
	@BeforeClass
	
	void addbypath() throws IOException
	{
	
		
		logger.info("*********Started TC_001_Add_by_path **********");
		ReadConfig readconf=new ReadConfig();
		RestAssured.baseURI=readconf.getDataServiceURL();
		
		
	response=given().log().all().header("Content-Type","application/json")
	.body(new String(Files.readAllBytes(Paths.get("/home/chinmayee/eclipse-workspace/Weav_AI_API_Automation/add_by_path.json"))))
	.when().post("/api/v1/dataset/add_by_path")
	.then().extract().response();
	
	String string_resp=response.asString();
	//System.out.println(string_resp);
	
	JsonPath js=new JsonPath(string_resp);
	
	datasetid=js.getString("data.dataset_id");
	versionid=js.getString("data.version_id");
	//System.out.println(datasetid);
	//System.out.println(versionid);
	
	

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
		logger.info("***********  Checking Respose Body **********");
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
		
	}
	
	
	
	
	
	@Test
	void checkResponseTime()
	{
		logger.info("***********  Checking Response Time **********");
		long responseTime = response.getTime(); // Getting status Line
		Assert.assertTrue(responseTime<2000);
		
			
	}
	
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC_001_Add_by_path **********");
	}
	
	
	
}
