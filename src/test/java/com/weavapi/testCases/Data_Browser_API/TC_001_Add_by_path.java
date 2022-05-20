package com.weavapi.testCases.Data_Browser_API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.weavapi.base.Test_Base;
import com.weavapi.utilities.ReadConfig;





public class TC_001_Add_by_path extends Test_Base{
	
	Response response;
	public static String datasetid;
	public static String versionid;
	JsonPath js;
	public static String message;
	public static Logger logger=LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest(alwaysRun=true)
	
	void addbypath() throws IOException
	{
	
		
		logger.info("*********Started TC_001_Add_by_path **********");
		ReadConfig readconf=new ReadConfig();
		RestAssured.baseURI=readconf.getDataServiceURL();
		
		
	response=given().log().all().header("Content-Type","application/json")
	.body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/JSONFiles/add_by_path.json"))))
	.when().post("/api/v1/dataset/add_by_path")
	.then().extract().response();
	
	String string_resp=response.asString();
	System.out.println(string_resp);
	
	JsonPath js=new JsonPath(string_resp);
	
	datasetid=js.getString("data.dataset_id");
	versionid=js.getString("data.version_id");
	//System.out.println(datasetid);
	//System.out.println(versionid);
	message =js.getString("status.result");
	
	

}
	
	@Test(groups = { "positive_test_case" })
	void checkStatusCode()
	{
		logger.info("***********  Checking Status Code of 1st **********");
		//extent.createTest("checkStatusCode");
		int statuscode =response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	
	
	@Test
	void checkstatusLine()
	{
		logger.info("***********  Checking Status Line of 1st **********");
		//extent.createTest("checkstatusLine");
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.0 200 OK");
		
	}
	
	
	
	@Test
	void checkResposeBody()
	{
		logger.info("***********  Checking Respose Body **********");
		//extent.createTest("checkResposeBody");
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
	
	
	
	@Test
	 void checkmessage()
		{
		 logger.info("***********  Checking Message ***************");
		// extent.createTest("checkmessage");
			
		// String message=js.get("status.result");
		 //System.out.println(message);
		 
			Assert.assertEquals(message, "fail");
			//extent.flush();
			
		}
	
	
	@AfterTest(alwaysRun=true)
	void tearDown()
	{
		logger.info("*********  Finished TC_001_Add_by_path **********");
		
		//extent.flush();
	}
	
	
	
}
