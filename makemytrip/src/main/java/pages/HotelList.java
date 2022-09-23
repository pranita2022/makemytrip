package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelList {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath="//span[text()='Pay @ Hotel Available']")
	private WebElement ckeckpayathotel;
	
	@FindBy (xpath="(//div[@class='flexOne appendLeft20'])[6]")
	private WebElement hotelpearl;
	
	@FindBy (xpath="//span[text()='Locality']")
	private WebElement forscroll;
	
	public HotelList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void choosepayathotel()
	{
		ckeckpayathotel.click();
		
	}
	public void choosehotel()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", forscroll);
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(hotelpearl));
		hotelpearl.click();
	}
}
