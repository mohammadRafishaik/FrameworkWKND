package com.seleweb;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatareader {
	
	
	public XSSFWorkbook xsw;
		XSSFSheet xss;
		public  Exceldatareader() {
			File src=new File("E:\\Dp\\MBS_PROJECT\\TestDataFIle\\TestData.xlsx");
			try {
				FileInputStream fis=new FileInputStream(src);
				
					xsw	=new XSSFWorkbook(fis);
			} 
			catch (Exception e) 
			{
				System.out.println("Excel is not loaded "+e.getMessage());
			}
		
				
			
			
		}

	
		public String getstringgetdata(String sheetname ,int rownum,int cellnum) {
		return xsw.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		
		}
		public double getnumericdata(String sheetname ,int rownum,int cellnum) {
			return xsw.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}
	}

