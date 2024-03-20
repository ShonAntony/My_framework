package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	// this method is to read the data from the excel file
	// @param sheetname , rowNo , columnNo
	public String readDataFromExcel(String sheetName, int rowNo, int colNo) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream("");
			Workbook wb = WorkbookFactory.create(fis);
			value = wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	// this method is to write the data into a cell
	// @param sheetname , rowNo , columnNo , data
	public void writeDataFromExcel(String sheetName, int rowNo, int colNo, String data) {
		try {
			FileInputStream fis = new FileInputStream("");
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(data);
			FileOutputStream fos = new FileOutputStream("");
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to get multiple values from the excel file
	// @param sheetName , keyColumn ,valueColumn
	public HashMap<String, String> readMultipleDataFromExcel(String sheetName, int keyCol, int valueCol) {
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			FileInputStream fis = new FileInputStream("");
			Workbook wb = WorkbookFactory.create(fis);
			int count = wb.getSheet(sheetName).getLastRowNum();
			for (int i = 0; i < count; i++) {
				String key = wb.getSheet(sheetName).getRow(i).getCell(keyCol).getStringCellValue();
				String value = wb.getSheet(sheetName).getRow(i).getCell(valueCol).getStringCellValue();
				map.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// this method is to get multiple sets of data
	public Object[][] getMultipleSetsOfData(String sheetName) {
		Object obj[][] = null;
		try {
			FileInputStream fis = new FileInputStream("");
			Workbook wb = WorkbookFactory.create(fis);
			int lastRow = wb.getSheet(sheetName).getLastRowNum();
			int lastCol = wb.getSheet(sheetName).getRow(1).getLastCellNum();
			obj = new Object[lastCol + 1][lastCol];
			for (int i = 0; i < lastRow; i++) {
				for (int j = 0; j < lastCol; j++) {
					obj[i][j] = wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;

	}
}
