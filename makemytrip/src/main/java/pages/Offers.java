package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Offers {
	
	private WebDriver driver;
	
	@FindBy (xpath="(//a[text()='BOOK NOW'])[4]")
	private WebElement booknow;
	
	@FindBy (xpath="(//a[text()='BOOK NOW'])[3]")
	private WebElement forscroll;
	
	@FindBy (xpath="//span[@class='langCardClose']")
	private WebElement canclepopup;
	
	public Offers(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void booknowholidy() throws InterruptedException
	{
		canclepopup.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",forscroll);
		Thread.sleep(3000);
		booknow.click();
	}

}
