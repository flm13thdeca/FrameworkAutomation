package mar20th;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrittingInExcel {

	public static void main(String[] args) throws InterruptedException, IOException, InvalidFormatException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele = driver
				.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody"));
		List<WebElement> elements = ele
				.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr"));
		int Rowlength = elements.size();
		System.out.println(Rowlength);

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("WorldClockData");

		for (int i = 1; i <= Rowlength; i++) {

			Row row = sheet.createRow(i);
			WebElement rowelement = ele.findElement(
					By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[" + i + "]"));
			List<WebElement> colunmlength = rowelement.findElements(
					By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[" + i + "]/td"));
			int cllength = colunmlength.size();

			for (int j = 1; j <= cllength; j++) {

				Cell cell = row.createCell(j);
				WebElement coldata = rowelement.findElement(By.xpath(
						"/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
				cell.setCellValue(coldata.getText());

			}
			System.out.println();

		}
		FileOutputStream fop = new FileOutputStream("prakashyadav.xlsx");
		wb.write(fop);
		fop.close();
		System.out.println("End of program");
		driver.quit();
	}

}