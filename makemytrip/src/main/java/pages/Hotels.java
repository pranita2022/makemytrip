package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotels {
	@FindBy (xpath="//li[@data-cy='account']")
	private WebElement loginbutton;
	
	@FindBy (xpath="//label[@for='city']")
	private WebElement city;
	
	@FindBy (xpath="//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	private WebElement searchcity;
	
	@FindBy (xpath="//p[text()='Thane, Maharashtra, India']")
	private WebElement selectc;
	
	//@FindBy (xpath="//label[@for='checkin']")
	//private WebElement checkin;
	

	@FindBy (xpath="(//div[text()='9'])[1]")
	private WebElement indate;
	
	@FindBy (xpath="(//div[text()='14'])[1]")
	private WebElement outdate;
	
	@FindBy (xpath="//li[@data-cy='adults-2']")
	private WebElement room;
	
	@FindBy (xpath="//button[text()='APPLY']")
	private WebElement apply;
	
	@FindBy (xpath="//button[@id='hsw_search_button']")
	private WebElement search;
	
	public Hotels(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cancleloginpopup()
	{
		loginbutton.click();
	}
	
	public void bookroom()
	{
		city.click();
		searchcity.sendKeys("mumbai");
		selectc.click();
		//checkin.click();
		indate.click();
		outdate.click();
		room.click();
		apply.click();
		search.click();
	}

}

