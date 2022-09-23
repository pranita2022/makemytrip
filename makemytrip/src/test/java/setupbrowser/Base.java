package setupbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openchrome()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\velocity\\selenium\\new chrome version\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openfirefox()
	{
		System.setProperty("webdriver.gecko.driver","E:\\velocity\\selenium\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
}
