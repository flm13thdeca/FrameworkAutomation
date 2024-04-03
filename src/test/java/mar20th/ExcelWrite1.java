package mar20th;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite1 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("D:\\FLM13thDec\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		
		//case 1 : modifying an existing cell in a row 
		
		//ws.getRow(1).getCell(1).setCellValue("Old");
		
		//case 2: creating a cell in an existing row 
		
		//ws.getRow(1).createCell(3).setCellValue(369);
		
		//case 3: cretaing a row and a cell in it 
		
		ws.createRow(3).createCell(0).setCellValue("Selenium");
		
		FileOutputStream fos=new FileOutputStream("D:\\FLM13thDec\\Book1.xlsx");
		
		wb.write(fos);
		
		wb.close();
		
		System.out.println("End of Program..");
		
		

	}

}
