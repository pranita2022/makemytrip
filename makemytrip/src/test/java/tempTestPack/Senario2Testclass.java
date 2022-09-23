package tempTestPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HeaderPage;
import pages.HotelList;
import pages.Hotelpearl;
import pages.Hotels;
import pages.ReviewHotelBooking;

public class Senario2Testclass {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\velocity\\selenium\\new chrome version\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		
		HeaderPage headerpage=new HeaderPage(driver);
		headerpage.gotohotel();
		
		Hotels hotels=new Hotels(driver);
		//Thread.sleep(3000);
		//hotels.cancleloginpopup();
		hotels.bookroom();
		
		String hotellistURL=driver.getCurrentUrl();
		if(hotellistURL.equals("https://www.makemytrip.com/hotels/hotel-listing/?checkin=09082022&city=CTXT1&checkout=09132022&roomStayQualifier=2e0e&locusId=CTXT1&country=IN&locusType=city&searchText=Thane,%20Maharashtra,%20India&visitorId=d18fc97e-abf3-4a9c-a395-ec24f9bf4c06&regionNearByExp=3"))
		{
			System.out.println("Hotellist page varified");
		}
		else
		{
			System.out.println("Hotellist page wrong");
		}
		
		HotelList hotelList=new HotelList(driver);
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
		
		Hotelpearl hotelpearl=new Hotelpearl(driver);
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
		
		ReviewHotelBooking reviewHotelBooking=new ReviewHotelBooking(driver);
		reviewHotelBooking.reviewform();
	}

}
