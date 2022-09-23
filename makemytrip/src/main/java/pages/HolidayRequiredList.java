package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HolidayRequiredList {
	private WebDriver driver;
	
	@FindBy (xpath="(//img[@alt='SliderImage'])[3]")
	private WebElement selectpackage;
	
	public HolidayRequiredList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void selectreriredpackage()
	{
		selectpackage.click();
	}
}
