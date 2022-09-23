package tempTestPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Flites;
import pages.HeaderPage;
import pages.HotelList;
import pages.Hotelpearl;
import pages.Hotels;
import pages.ReviewHotelBooking;
import setupbrowser.Base;
import utils.Utilityforproject;

public class Senario1and2TestNG extends Base {
	
	private WebDriver driver;
	private HeaderPage headerpage;
	private Flites flites;
	private Hotels hotels;
	private HotelList hotelList;
	private Hotelpearl hotelpearl;
	private ReviewHotelBooking reviewHotelBooking;
	private int testid;
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
		headerpage=new HeaderPage(driver);
		flites=new Flites(driver);
		hotels=new Hotels(driver);
		hotelList=new HotelList(driver);
		hotelpearl=new Hotelpearl(driver);
		reviewHotelBooking=new ReviewHotelBooking(driver);
	}
	
	
	@Test (enabled=false)
	public void verifydisplaysecifiedflitelist() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		//headerpage.cancleloginpopup();
		headerpage.verifyflitemenu();
		headerpage.gotoflite();
		String flitesURL=driver.getCurrentUrl();
		System.out.println(flitesURL); 
		if(flitesURL.equals("https://www.makemytrip.com/flights/"))
		{
			System.out.println("Flites page varified");
		}
		else
		{
			System.out.println("Flites page wrong");
		}
		
		String city=Utilityforproject.getdata("velocity", 2, 1);
		String city2=Utilityforproject.getdata("velocity", 2, 2);
		//Thread.sleep(3000);
		flites.cancleloginpopup();
		flites.inputfrom(city);
		flites.inputto(city2);
		flites.selectdepart();
		flites.search();
	}
	
	@Test 
	public void verifybookhotel() throws InterruptedException
	{
		testid=1022;
		headerpage.verifyhotelmenu();
		headerpage.gotohotel();
		
		//Thread.sleep(3000);
		//hotels.cancleloginpopup();
		hotels.bookroom();
		
		String hotellistURL=driver.getCurrentUrl();
		System.out.println(hotellistURL);		
		if(hotellistURL.equals("https://www.makemytrip.com/hotels/hotel-listing/?checkin=09082022&city=CTXT1&checkout=09132022&roomStayQualifier=2e0e&locusId=CTXT1&country=IN&locusType=city&searchText=Thane,%20Maharashtra,%20India&visitorId=d18fc97e-abf3-4a9c-a395-ec24f9bf4c06&regionNearByExp=3"))
		{
			System.out.println("Hotellist page varified");
		}
		else
		{
			System.out.println("Hotellist page wrong");
		}
		
		
		Thread.sleep(3000);
		hotelList.choosepayathotel();
		Thread.sleep(5000);
		hotelList.choosehotel();
		
		ArrayList<String> addlist=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addlist.get(1));
		
		String hotelpearlURL=driver.getCurrentUrl();
		if(hotelpearlURL.equals("https://www.makemytrip.com/hotels/hotel-details/?hotelId=20161004113659444&_uCurrency=INR&checkin=09082022&checkout=09132022&city=CTNVM&country=IN&filterData=PAY_AT_HOTEL_AVAIL%7CPAH_AVAIL&lat=19.08249&lng=73.01148&locusId=CTXT1&locusType=city&rank=5&regionNearByExp=3&roomStayQualifier=2e0e&searchText=Thane%2C%20Maharashtra%2C%20India&viewType=BUDGET&visitorId=af9636d3-cdb7-42ba-ac1d-badcfe0c034c&mtkeys=defaultMtkey"))
		{
			System.out.println("Hotelpearl page varified");
		}
		else
		{
			System.out.println("Hotelpearl page wrong");
		}
		
		
		hotelpearl.selectroom();
		String reviewHotelBookingURL=driver.getCurrentUrl();
		if(reviewHotelBookingURL.equals("https://www.makemytrip.com/hotels/hotel-review?_uCurrency=INR&checkin=09082022&checkout=09132022&city=CTNVM&country=IN&filterData=PAY_AT_HOTEL_AVAIL%7CPAH_AVAIL&hotelId=20161004113659444&lat=19.08249&lng=73.01148&locusId=CTXT1&locusType=city&mtKey=0-_20161004113659444-_2e0e-_2022-09-08-_2022-09-13-_312165-_bb4895c6-8839-456b-a45c-cb28d81cd5f3-_t-_1662077316057-_HOTEL-_210075-_45000288481-_org%2523b2c%2523nil%2523mob%2523b2c-_.-_990000622179%253AMSE%253A1121%253AMSE%253AINGO-_08-Sep-2022%2B12%253A00-_EP-_INGO-_.-_367F-_JaP-_9Iq-_eo0-_8A0-_yh-_.-_2TQo-_RuV-_0-_INR-_.-_.-_.&mtkeys=defaultMtkey&payMode=PAH_WITHOUT_CC&rank=5&regionNearByExp=3&roomCriteria=210075~%7C~990000622179%3AMSE%3A1121%3AMSE%3AINGO~%7C~2e0e&roomStayQualifier=2e0e&searchText=Thane%2C%20Maharashtra%2C%20India&searchType=E&suppDetail=INGO&viewType=BUDGET&visitorId=af9636d3-cdb7-42ba-ac1d-badcfe0c034c"))
		{
			System.out.println("ReviewHotelBooking page varified");
		}
		else
		{
			System.out.println("ReviewHotelBooking page wrong");
		}
		Thread.sleep(3000);
		
		reviewHotelBooking.reviewform();
	}
	@AfterTest
	
	public void capturefailtestcase(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utilityforproject.captureimage(driver,testid);
		}
	}
	@AfterClass
	public void cleanpomobjects()
	{
		headerpage=null;
		flites=null;
		hotels=null;
		hotelList=null;
		hotelpearl=null;
		reviewHotelBooking=null;
	}
	
	@AfterTest
	public void closetab()
	{
		driver.close();
		driver=null;
		System.gc();
	}

}
