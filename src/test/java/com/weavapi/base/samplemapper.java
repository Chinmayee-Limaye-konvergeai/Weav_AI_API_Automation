package com.weavapi.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weavapi.testCases.Data_Browser_API.TC_001_Add_by_path;

public class samplemapper {

	
	public static  Map<String, Object> mapObject;
	
	//public static String file_name;
	
	public static Map<String, Object> parse_body() {
		// TODO Auto-generated method stub

	//public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();

		 try {

		  File jsonFile = new File("/home/chinmayee/eclipse-workspace/Weav_AI_API_Automation/JSONFiles/get_rows.json");
		  
		 
		  Map<String, Object> mapObject  = mapper.readValue(jsonFile,new TypeReference<Map<String, Object>>() {});
		  
		 mapObject.put("dataset_id", "12345");
		  
		  
		 mapObject.put("version_id", "56789");
		 
		  
			/*
			 * System.out.println("name : " + mapObject.get("dataset_id"));
			 * System.out.println("city : " + mapObject.get("version_id"));
			 * System.out.println("mobile : " + mapObject.get("file_name"));
			 */
			 
			
			/*
			 * List<String> list = (List<String>) mapObject.get("show_cols"); for (String
			 * name : list) { System.out.print(name + " "); }
			 */
			 

		  } catch (JsonGenerationException e) {
		  e.printStackTrace();
		  } catch (JsonMappingException e) {
		  e.printStackTrace();
		  } catch (IOException e) {
		  e.printStackTrace();
		  }

		return mapObject;
		 
		  }

	
	 

		}
	


