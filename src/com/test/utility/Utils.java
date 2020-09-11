package com.test.utility;

import java.util.ArrayList;

import com.excel.lib.util.Xls_Reader;

public class Utils {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		try {
			reader=new Xls_Reader("C:\\my java\\SeleniumSession\\src\\com\\testData\\halfEbeyTestData.xlsx");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int rowcount=reader.getRowCount("RegTestData");
		for(int rowNum=2;rowNum<=rowcount;rowNum++) {
			System.out.println();
			String firstname=reader.getCellData("RegTestData", "firstname", rowNum);
			
			String lastname=reader.getCellData("RegTestData", "lastname",rowNum);
			
			String emailaddress=reader.getCellData("RegTestData", "emailaddress", rowNum);
			
			String password=reader.getCellData("RegTestData", "password", rowNum);
			
			Object[] ob = {firstname, lastname, emailaddress, password};
			myData.add(ob);
	}
		return myData;
}
	
}
