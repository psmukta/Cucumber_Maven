package Helpers;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {
	HashMap<String,String>storeValue=new HashMap();
	public static List<HashMap<String,String>>data (String filePath,String sheetName) throws IOException{
	List<HashMap<String,String>> myData=new ArrayList();


	FileInputStream fis=new FileInputStream(filePath);
	Workbook wb=new XSSFWorkbook(fis);
	Sheet ws=wb.getSheet(sheetName);
	Row HeaderRow=ws.getRow(0);
	for(int i=1;i<ws.getLastRowNum();i++) {
		Row CurrentRow=ws.getRow(i);
		HashMap<String,String>currentHash=new HashMap<String,String>();
		for(int j=0;j<CurrentRow.getPhysicalNumberOfCells();j++) {
			Cell CurrentCell= CurrentRow.getCell(j);
			switch(CurrentCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				currentHash.put(HeaderRow.getCell(j).getStringCellValue(),CurrentCell.getStringCellValue());
				break;
			}
		}
		myData.add(currentHash);

	}
	return myData;
}
}



