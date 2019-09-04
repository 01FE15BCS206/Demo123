package selenium_testng2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel_selenium {
	@Test
public void excel_sel() throws IOException
{

	FileInputStream f1=new FileInputStream("C:\\Users\\training_b6b.01.07\\Desktop\\drivers\\selenium1.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(f1);
	XSSFSheet sheet1=wb.getSheetAt(0);
	int rc=sheet1.getPhysicalNumberOfRows();
	XSSFRow row1=sheet1.getRow(0);
	int cc=row1.getPhysicalNumberOfCells();
	
	int i,j;
	for(i=0;i<rc;i++)
	{
		for(j=0;j<cc;j++)
		{
			String value=sheet1.getRow(i).getCell(j).getStringCellValue();
			System.out.println(value);
		}
	}
}	
}
