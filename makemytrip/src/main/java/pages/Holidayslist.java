package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Holidayslist {
	
	private WebDriver driver;
	
	@FindBy (xpath="//span[@class='close closeIcon']")
	private WebElement cancle;
	
	@FindBy (xpath="//input[@id='departure_date']")
	private WebElement startdate;
	
	@FindBy (xpath="(//div[text()='23'])[1]")
	private WebElement selectdate;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement search;
	
	public Holidayslist(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void canclepopup()
	{
		cancle.click();
	}
	
	public void selectdateandsearch()
	{
		startdate.click();
		selectdate.click();
		search.click();
	}
}
