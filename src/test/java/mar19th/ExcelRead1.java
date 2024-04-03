package mar19th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1 {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis=new FileInputStream("D:\\FLM13thDec\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		//.out.println("getLastRowNum    "+ws.getLastRowNum());
		//System.out.println("getPhysicalNumberOfRows     "+ws.getPhysicalNumberOfRows());
		
		//System.out.println(ws.getRow(1).getLastCellNum());
		//System.out.println(ws.getRow(1).getPhysicalNumberOfCells());
		
		XSSFRow row=null;
		XSSFCell cell=null;
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			
			for(int j=0;j<=row.getLastCellNum()-1;j++)
			{
				cell=row.getCell(j);
				
								
				if(cell.getCellType()==CellType.NUMERIC)
				{
					System.out.println(cell.getNumericCellValue()+" is a Number");
				}
				else if(cell.getCellType()==CellType.STRING)
				{
					System.out.println(cell.getStringCellValue()+" is a String");
				}
				else if(cell.getCellType()==CellType.BOOLEAN)
				{
					System.out.println(cell.getBooleanCellValue()+" is a Boolean");
				}
			}
			
		}

	}

}
