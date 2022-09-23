package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flites {
	@FindBy (xpath="//li[@data-cy='account']")
	private WebElement loginbutton;
	
	@FindBy (xpath="//label[@for='fromCity']")
	private WebElement from;
	
	@FindBy (xpath="//input[@autocomplete='off']")
	private WebElement frominput;
	
	@FindBy (xpath="//p[text()='Mumbai, India']")
	private WebElement fromopt;
	
	@FindBy (xpath="//label[@for='toCity']")
	private WebElement toinput;
	
	@FindBy (xpath="//p[text()='Pune, India']")
	private WebElement toopt;
	
	@FindBy (xpath="//label[@for='departure']")
	private WebElement departure;
	
	@FindBy (xpath="(//p[text()='30'])[1]")
	private WebElement depart;
	
	@FindBy (xpath="//a[text()='Search']")
	private WebElement search1;
	
	public Flites(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cancleloginpopup()
	{
		loginbutton.click();  
	}
	
	public void inputfrom(String fromcity)
	{
		from.click();
		frominput.sendKeys(fromcity);
		fromopt.click();
	}
	
	public void inputto(String tocity)
	{
		toinput.sendKeys(tocity);
		toopt.click();
	}
	
	public void selectdepart()
	{
		departure.click();
		depart.click();
	}
	
	public void search()
	{
		search1.click();
	}
	
}
