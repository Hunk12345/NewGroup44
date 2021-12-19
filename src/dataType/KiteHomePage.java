package POM_Test_Base_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	@FindBy(xpath = "//span[@class='user-id']")private WebElement UserId;

	@FindBy(xpath = "//a[@target='_self']")private WebElement LogoutButton;
		
		public KiteHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);	
		}
		
		public String userIDValidation()
		{
			String ActualUserid=UserId.getText();
			return ActualUserid;
			
		//	if (ActualUserid.equals(ExpUseriD))
		//	{
		//		System.out.println("Test Case Pass");
		//	}
			
		//	else 
		//	{
			//	System.out.println("Test Case Failed");
		//	}
		}
			
			public void ClickOnUserID()
			{
				UserId.click();
			}
			
			public void ClickOnLogoutButton()
			{
				LogoutButton.click();
			}
}
