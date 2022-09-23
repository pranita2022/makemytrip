package tempTestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trail {
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\velocity\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.makemytrip.com");
	}
}
