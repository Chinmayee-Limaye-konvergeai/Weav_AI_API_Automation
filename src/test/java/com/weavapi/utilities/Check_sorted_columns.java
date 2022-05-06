package com.weavapi.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

import com.weavapi.base.Parse_json_body;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Check_sorted_columns {
	
	JsonPath json;
	String columnname=Parse_json_body.sort_column;
	String sortorder=Parse_json_body.order;
	boolean flag;
	String filename=Parse_json_body.file_name;
	
	
	public  boolean check_sorted(JsonPath json)
	
	
	{
		
	
		int size=json.getInt("data[\""+filename+"\"].data.size()");
		//System.out.println(size);
		
		
		//Object value=js.get("data[\""+filename+"\"].data[0]."+columnname+"");
		
		Object value=json.get("data[\""+filename+"\"].data[0][\""+columnname+"\"]");
		//js.get("data[\"tinder.parquet\"].data[0].Count")
		
		//System.out.println(value);
		
		String dataType = value.getClass().getSimpleName();
		//System.out.println(dataType);
		
		if(dataType.equalsIgnoreCase("Integer"))
		{
		int strAr1;
		List<Integer> columnlist = new ArrayList<Integer>();
		
		for (int i=0;i<size;i++)
		{
			//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
			
			try
			{
			strAr1=json.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			columnlist.add(strAr1);
			}
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
	   }
		
		List <Integer> copy = new ArrayList<Integer>(columnlist);
		if(sortorder =="ASC")
		{
			
		try
		{
		Collections.sort(copy);
		}
		
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		}
		else if(sortorder =="DSC")
		{
			try
			{
			Collections.sort(copy, Collections.reverseOrder());
			}
			
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
		}
		flag=copy.equals(columnlist);
		Assert.assertTrue(flag);
		
		}
		
		else if (dataType.equalsIgnoreCase("String"))
		{
		String strAr1;
		List<String> columnlist = new ArrayList<String>();
		
		for (int i=0;i<size;i++)
		{
			//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
			try
			{
			strAr1=json.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			
             columnlist.add(strAr1);
			}
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
	   }
		
		//System.out.println(columnlist);
		List <String> copy = new ArrayList<String>(columnlist);
		
		
		if (sortorder =="ASC")
		{
			
			try
			{
		Collections.sort(copy);
			}
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
		
		}
		else if(sortorder =="DSC")
		{
			try
			{
			Collections.sort(copy, Collections.reverseOrder());
			}
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
			//System.out.println(copy);
		}
		    
		    flag=copy.equals(columnlist);
		   // System.out.println(flag);
		    Assert.assertTrue(flag);
		
		}
		
		
		else if(dataType.equalsIgnoreCase("Boolean"))
		{
			boolean strAr1;
		List<Boolean> columnlist = new ArrayList<Boolean>();
		
		for (int i=0;i<size;i++)
		{
			//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
			try
			{
			strAr1=json.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
		
			
		
			
			columnlist.add(strAr1);
			}
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
	   }
		
		List <Boolean> copy = new ArrayList<Boolean>(columnlist);
		//System.out.println(columnlist);
		if(sortorder =="ASC")
		{
			try
			{
			
		Collections.sort(copy);
			}
		
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		}
		else if(sortorder =="DSC")
		{
			try
			{
			Collections.sort(copy, Collections.reverseOrder());
			}
			
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
			//System.out.println(columnlist);
		}
		flag=copy.equals(columnlist);
		Assert.assertTrue(flag);
		
		}
		
		
		else if(dataType.equalsIgnoreCase("Float"))
		{
			float strAr1;
			//int  tempstr;
			
			//strAr1 =js.get("data[\"homes.parquet\"].data[0].Rooms");
			//System.out.println(strAr1);
		List<Float> columnlist = new ArrayList<Float>();
		
		for (int i=0;i<size;i++)
		{
			//strAr1=(js.get("data[\""+filename+"\"].data["+i+"]."+columnname+""));
			
			try
			{
			strAr1=json.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			//strAr1= js.get("data[\"homes.parquet\"].data["+i+"].Rooms");
			//tempstr=js.get("data[\""+filename+"\"].data["+i+"][\""+columnname+"\"]");
			
			//strAr1=(tempstr);
			
		    columnlist.add(strAr1);
			}
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
	   }
		
		List <Float> copy = new ArrayList<Float>(columnlist);
		//System.out.println(columnlist);
		if(sortorder =="ASC")
		{
			
			try
			{
		Collections.sort(copy);
			}
		
		
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		//System.out.println(copy);
		}
		else if(sortorder =="DSC")
		{
			
			try
			{
			Collections.sort(copy, Collections.reverseOrder());
			}
			//System.out.println(copy);
			
			catch(NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
		}
		flag=copy.equals(columnlist);
		//System.out.println(flag);
		//Assert.assertTrue(flag);
		
		}
		
		
		 return flag;
		
	}
	

}
