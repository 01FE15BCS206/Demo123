package selenium_testng2;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Excel_sel2 {
@Test
	
	public static Object[][] read_data() throws IOException
	{
		FileInputStream f1=new FileInputStream("C:\\Users\\training_b6b.01.07\\Desktop\\selenium1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sheet1=wb.getSheetAt(0);
		int rc=sheet1.getPhysicalNumberOfRows();
		XSSFRow row1=sheet1.getRow(0);
		int cc=row1.getPhysicalNumberOfCells();
		int i,j;
		
		Object[][] data=new Object[rc][cc];
		for(i=0;i<rc;i++)
		{
			for(j=0;j<cc;j++)
			{
							
					data[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
			
		return data;
		
	}
}
