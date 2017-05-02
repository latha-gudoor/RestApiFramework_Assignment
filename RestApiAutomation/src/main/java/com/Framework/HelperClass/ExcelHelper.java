package com.Framework.HelperClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelHelper {

	static Logger logger = LogManager.getLogger(ExcelHelper.class);

	public static Object[][] getExcelData(String fileName,String sheetName){
		Object[][] data = null;
		XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(IConstants.LOCATION+fileName));
			XSSFSheet sheet = wb.getSheet(sheetName);
			int noOfRows = sheet.getLastRowNum();
			data= new Object[noOfRows][];
			for(int i=1;i<=noOfRows;i++){
				XSSFRow row =sheet.getRow(i);
				int noOfColumns=row.getLastCellNum();

				String [] strData = new String[noOfColumns];
				System.out.println("number of columns : " + noOfColumns);
				for (int j=0;j<noOfColumns;j++){
					System.out.println("Column Data: " +  row.getCell(j).getStringCellValue());
					strData[j]=row.getCell(j).getStringCellValue();
				}
				data[i-1]=strData;
			}

		} catch (IOException e) {
			logger.error("issue reading file");
		}finally{
			if(null!=wb){
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			

		return data;
	}

}