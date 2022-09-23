package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilityforproject {
	public static String getdata(String sheetname,int row,int cell) throws IOException
	{
		String path="E:\\\\velocity\\\\auto out\\\\student.xlsx";
		FileInputStream file=new FileInputStream(path);
		try {
			String str=WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return str;
		}
		catch(IllegalStateException e) {
			double num=WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			String str1=String.valueOf(num);
			return str1;
		}
		catch(NullPointerException e)
		{
			String str2="No Data";
			return str2;
		}
	}
	public static void captureimage(WebDriver driver,int id) throws IOException
	{
		Date d=new Date();
		String filename=id+" "+d.toString().replace(":", "_").replace(" ","-")+".jpeg";
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\velocity\\auto output\\"+filename);
		FileHandler.copy(src, dest);
	}
}
