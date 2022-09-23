package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	@FindBy (xpath="//li[@data-cy='account']")
	private WebElement loginbutton;
	
	@FindBy (xpath="(//span[text()='Flights'])[1]")
	private WebElement flite;
	
	@FindBy (xpath="(//span[text()='Hotels'])[1]")
	private WebElement hotel;
	
	public HeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cancleloginpopup()
	{
		loginbutton.click();  
	}
	
	public void verifyflitemenu()
	{
		boolean result=flite.isEnabled();
		if(result==true)
		{
			System.out.println("flite menu is enable");
			
		}
		else
		{
			System.out.println("flite menu is disable");
		}
	}
	
	public void gotoflite()
	{
		flite.click();
	}
	
	public void verifyhotelmenu()
	{
		boolean result=hotel.isEnabled();
		if(result==true)
		{
			System.out.println("Hotels menu is enable");
			
		}
		else
		{
			System.out.println("Hotels menu is disable");
		}
	}
	
	public void gotohotel()
	{
		hotel.click();
	}

}
