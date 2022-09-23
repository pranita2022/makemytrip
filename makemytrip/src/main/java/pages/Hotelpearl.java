package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotelpearl {
	
	private WebDriver driver;
	
	@FindBy (xpath="(//p[text()='SELECT ROOM'])[3]")
	private WebElement selectr;
	
	@FindBy (xpath="//div[@id='room1']")
	private WebElement forscroll;
	public Hotelpearl(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void selectroom()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",forscroll);
		selectr.click();
		
	}
}
