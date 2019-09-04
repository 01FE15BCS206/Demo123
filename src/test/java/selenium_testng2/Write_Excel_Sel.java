package selenium_testng2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Write_Excel_Sel {

	@Test
	public void write_Excel() throws IOException
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\training_b6b.01.07\\Desktop\\drivers\\selenium1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet1=wb.getSheetAt(0);
		sheet1.getRow(0).createCell(3).setCellValue("valid_user");
		sheet1.getRow(1).createCell(3).setCellValue("sum");
		FileOutputStream fs1=new FileOutputStream("C:\\Users\\training_b6b.01.07\\Desktop\\drivers\\selenium1.xlsx");
		
		wb.write(fs1);
		
	}
}
