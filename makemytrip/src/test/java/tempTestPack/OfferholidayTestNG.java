package tempTestPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HolidayRequiredList;
import pages.Holidaysindiapage;
import pages.Holidayslist;
import pages.HotelList;
import pages.Offers;
import setupbrowser.Base;

public class OfferholidayTestNG extends Base {
	private WebDriver driver;
	private Offers offer;
	private Holidaysindiapage holidaysindiapage;
	private Holidayslist holidayslist;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browsername)
	{
		if(browsername.equals("chrome"))
		{
			driver=openchrome();
		}
		if(browsername.equals("firefox"))
		{
			driver=openfirefox();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
	}
	
	@BeforeClass
	public void creatpomobjects()
	{
		offer=new Offers(driver);
		holidaysindiapage=new Holidaysindiapage(driver);
		holidayslist=new Holidayslist(driver);
	}
	
	@BeforeMethod
	public void getoffer() throws InterruptedException
	{
		
		
		Thread.sleep(3000);
		offer.booknowholidy();
		
		ArrayList<String> listofadd=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(listofadd.get(1));
		
		
		holidaysindiapage.setfromcity();
		holidaysindiapage.settocity();
		holidaysindiapage.search();
		
		
		Thread.sleep(3000);
		holidayslist.canclepopup();
		holidayslist.selectdateandsearch();
	}
	
	@Test
	public void getrequiredlist()
	{
		HolidayRequiredList holidayRequiredList=new HolidayRequiredList(driver);
		holidayRequiredList.selectreriredpackage();
	}
	
	@AfterClass
	public void cleanpomobjects()
	{
		offer=null;
		holidaysindiapage=null;
		holidayslist=null;
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	

}
