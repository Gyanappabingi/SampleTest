package selenium_1.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	public static Workbook book;
	public static Sheet sheet;
	public static String path = "C:\\Users\\VGSL-SW010\\git\\repository\\selenium_1\\src\\main\\java\\selenium_1\\TestData\\TestData.xlsx";

	public static Object[][] getExcelData(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream(path);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}

		return data;

	}

}
