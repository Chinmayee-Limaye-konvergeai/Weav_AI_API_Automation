package com.weavapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class Test_Base {
	
public Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("WEAVAIAPI");//added Logger
		PropertyConfigurator.configure("log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);

}
}
