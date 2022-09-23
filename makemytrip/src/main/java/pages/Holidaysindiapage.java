package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Holidaysindiapage {
	@FindBy (xpath="//label[@for='fromCity']")
	private WebElement fromcity;
	
	@FindBy (xpath="//input[@placeholder='From']")
	private WebElement inputfromcity;
	
	@FindBy (xpath="//span[text()='Pune']")
	private WebElement selectfromcity;
	
	@FindBy (xpath="//input[@placeholder='To']")
	private WebElement inputtocity;
	
	@FindBy (xpath="//span[text()='New Delhi']")
	private WebElement selecttocity;
	
	@FindBy (xpath="//button[@id='search_button']")
	private WebElement search;
	
	public Holidaysindiapage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setfromcity()
	{
		fromcity.click();
		inputfromcity.sendKeys("pune");
		selectfromcity.click();
	}
	
	public void settocity()
	{
		inputtocity.sendKeys("delhi");
		selecttocity.click();
	}
	
	public void search()
	{
		search.click();
	}

}
