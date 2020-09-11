package com.dataDriven.test;

import com.excel.lib.util.Xls_Reader;

public class ExcelOperation {

	public static void main(String[] args) {
		
		Xls_Reader reader=new Xls_Reader("C:\\my java\\SeleniumSession\\src\\com\\testData\\halfEbeyTestData.xlsx");
		
		if(!reader.isSheetExist("HomePage")) {
		reader.addSheet("searchData");
		}
		
		int colcount=reader.getColumnCount("RegTestData");
		System.out.println(" no of column present are " +colcount);
		
		int rowcount=reader.getRowCount("RegTestData");
		System.out.println("No of rows are "+rowcount);
	}

}
