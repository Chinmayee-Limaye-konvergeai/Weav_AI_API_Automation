package com.weavapi.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class Read_excel_utility {
	
	
		
		
	 public FileInputStream fis = null;
	   public XSSFWorkbook workbook = null;
	   public XSSFSheet sheet = null;
	   public XSSFRow row = null;
	   public XSSFCell cell = null;
	   String xlFilePath;
	   static int int_count;
	   
	  
	 
	   public Read_excel_utility(String xlFilePath) throws Exception
	   {
	       this.xlFilePath = xlFilePath;
	       fis = new FileInputStream(xlFilePath);
	       workbook = new XSSFWorkbook(fis);
	       fis.close();
	   }
	 
	   public int getRowCount()
	   {
	       sheet = workbook.getSheetAt(0);
	       int rowCount = sheet.getLastRowNum();
	       return rowCount;
	   }
	 
	   public int getColumnCount()
	   {
	       sheet = workbook.getSheetAt(0);
	       row = sheet.getRow(1);
	       int colCount = row.getLastCellNum();
	       //System.out.println(row.getCell(0).getCellType());
	       return colCount;
	       
	   }
	   
	   
	   public int checknumerical()
	   {
		   
		   sheet = workbook.getSheetAt(0);
	       int rowCount = sheet.getLastRowNum();
	       System.out.println(rowCount); //453
	       row = sheet.getRow(1);
	       int colCount = row.getLastCellNum();
	       System.out.println(colCount); //8
	       
	       //int total_cells=rowCount*colCount;
	       
		 
		   
		   for (int i=1;i<=rowCount;i++)
		   {
			   
			   row = sheet.getRow(i);
			  // System.out.println(row);
			   
			   for (int j=0;j<colCount;j++)
			   {
				String data_type= (row.getCell(j).getCellType()).toString();
				//System.out.println(data_type);
				
				if (data_type.equalsIgnoreCase("numeric"))
				  {
					int_count++;
				  }
				   
			   }
			   
			   
		   }
		  // System.out.println(int_count);
		  
		   
		   int numerical_columns= (int_count / rowCount);
		   //System.out.println(numerical_columns);
		   
		   return numerical_columns;
		   
	   }
	   
		
		
	   public static void main(String[] args) throws Exception
	   {
		   Read_excel_utility eat = new Read_excel_utility("/home/chinmayee/eclipse-workspace/Weav_AI_API_Automation/DataFiles/homes.xlsx");
	       int colCount = eat.getColumnCount();
	       System.out.println("Total Columns in the Excel : "+colCount);
	       int rowCount = eat.getRowCount();
	       System.out.println("Total Rows in the Excel : "+rowCount);
	       
	       int nc=eat.checknumerical();
	       System.out.println(nc);
	       
	   }	
		
	

}
