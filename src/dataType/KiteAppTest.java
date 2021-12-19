package POM_Test_Base_Utility;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;



public class KiteAppTest extends Base
{
	KiteLoginPage login;//declaration
	KitePinPage pin;
	KiteHomePage home;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		Reporter.log("Initailising browser",true);
		browserintialise();
		login=new KiteLoginPage(driver);
		pin=new KitePinPage(driver);
		home=new KiteHomePage(driver);
		
	}
	
	@BeforeMethod
	public void loginToKite() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("entering UseriD and Password",true);
		login.enterUserid(Utility.getDataFromExcel(0, 0));
		login.enterpassword(Utility.getDataFromExcel(0, 1));
		login.ClickOnLoginButton();
		Thread.sleep(3000);
		
		Reporter.log("Enterning pin",true);
		
		pin.enterPin(Utility.getDataFromExcel(0, 2));
		
		pin.ClickContinueButton();
		
	}
	
  @Test
  public void ValidateUserID() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  int TCID=10;
	  Thread.sleep(3000);
	  String ActualUserID = home.userIDValidation();
	  String ExpextedUserID = Utility.getDataFromExcel(0, 0);
	  
	  Reporter.log("validating UserID",true);
	  Thread.sleep(2000);
	  Assert.assertEquals(ActualUserID,ExpextedUserID, "UserId is not matching tc failed");
	  
	  Reporter.log("User ID MAtching tc"+TCID+"is Passed",true);
	  
	  Reporter.log("takating screenshot",true);
	  Thread.sleep(4000);
	  Utility.CaptureScreen(driver, TCID);
	  
	}
  @AfterMethod
  public void LogOutFromKite() throws InterruptedException
  
  {
	  Thread.sleep(2000);
	  Reporter.log("logging out...",true);
	  home.ClickOnUserID();
	  Thread.sleep(1000);
	  home.ClickOnLogoutButton();
	  Thread.sleep(1000);
	  
  }
  
  @AfterClass
  public void CloseBrowser() throws InterruptedException
  {
	  Thread.sleep(2000);
	  Reporter.log("closing browser",true);
	  driver.close();
	  
  }
  
  

}
