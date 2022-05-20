package com.weavapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test_Base {
	
//public Logger logger;
public ExtentReports extent;
	
/*
 * @BeforeClass public void setup() {
 * 
 * logger=Logger.getLogger("WEAVAIAPI");//added Logger
 * PropertyConfigurator.configure(
 * "/home/chinmayee/eclipse-workspace/Weav_AI_API_Automation/resource/log4j.properties"
 * ); //added logger logger.setLevel(Level.DEBUG);
 * 
 * }
 */
	

	
	public ExtentReports config()

	{

	// ExtentReports , ExtentSparkReporter

	//String path =System.getProperty("user.dir")+"\\reports\\index.html";
		
			
	String path=System.getProperty("user.dir")+"/Reports/index.html";	

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	reporter.config().setReportName("WEAV AI API Automation Results");

	reporter.config().setDocumentTitle("Test Results");

	extent =new ExtentReports();

	extent.attachReporter(reporter);
	
	extent.setSystemInfo("Host Name", "Local Host");
	
	extent.setSystemInfo("Environment", "QA");
	
	extent.setSystemInfo("WEAV AI QA", "Chinmayee Limaye");
	
	return extent;

	}
	
	
}
