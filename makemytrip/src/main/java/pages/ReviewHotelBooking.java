package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReviewHotelBooking {
	
	private WebDriver driver;
	
	@FindBy (xpath="//select[@id='title']")
	private WebElement title;
	
	@FindBy (xpath="//input[@id='fName']")
	private WebElement firstname;
	
	@FindBy (xpath="//input[@id='lName']")
	private WebElement lastname;
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement emailid;
	
	@FindBy (xpath="//input[@id='mNo']")
	private WebElement mobnumber;
	
	@FindBy (xpath="//a[text()='RESERVE NOW']")
	private WebElement reviewbutton;
	
	@FindBy (xpath="//span[text()='GUEST DETAILS']")
	private WebElement forscroll;
	
	public ReviewHotelBooking(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void reviewform()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",forscroll);
		title.click();
		Select s=new Select(title);
		s.selectByVisibleText("Mr");
		
		firstname.sendKeys("abc");
		lastname.sendKeys("xyz");
		emailid.sendKeys("abc@gmail.com");
		mobnumber.sendKeys("9343425436");
		reviewbutton.click(); 
	}
}
