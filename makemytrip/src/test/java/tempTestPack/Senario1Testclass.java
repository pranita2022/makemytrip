package tempTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Flites;
import pages.HeaderPage;

public class Senario1Testclass {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\velocity\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		
		HeaderPage headerpage=new HeaderPage(driver);
		headerpage.gotoflite();
		
		String flitesURL=driver.getCurrentUrl();
		if(flitesURL.equals("https://www.makemytrip.com/flights/"))
		{
			System.out.println("Flites page varified");
		}
		else
		{
			System.out.println("Flites page wrong");
		}
		
		Flites flites=new Flites(driver);
		Thread.sleep(3000);
		flites.cancleloginpopup();
		flites.inputfrom();
		flites.inputto();
		flites.selectdepart();
		flites.search();
				
	}
		
		
}
