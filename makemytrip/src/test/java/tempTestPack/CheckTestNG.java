package tempTestPack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckTestNG {
	@BeforeClass 
	public void beforeClass()
	{
		System.out.println("Before class");
	}
	
	@BeforeMethod 
	public void beforemethod()
	{
		System.out.println("Before method");
	}
	
	@Test 
	public void test123()
	{
		System.out.println("test");
	}
}
