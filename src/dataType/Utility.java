package POM_Test_Base_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromExcel(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	
	{
	    FileInputStream Myfile =new FileInputStream("C:\\Users\\Raju bhau ki Rutuja\\Downloads\\testkite.xlsx");
		
		 Sheet MySheet = WorkbookFactory.create(Myfile).getSheet("Sheet1");
		String value = MySheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}
	
	public static void CaptureScreen(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest= new File("C:\\Users\\Raju bhau ki Rutuja\\Pictures\\TestId"+TCID+".png");
		
		FileHandler.copy(src, dest);
	}

}
