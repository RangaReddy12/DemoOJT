package mar24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
WebDriver driver;
ExtentReports report;
ExtentTest test;
@BeforeTest
public void generaeteReport()
{
	report = new ExtentReports("./ExtentReports/Demo.html");
}
@BeforeMethod
public void steUp()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com");
	
}
@Test
public void testcase1()
{
	test= report.startTest("Pass Test");
	test.assignAuthor("Ranga");
	test.assignCategory("Functional");
	String Expected_Title ="Google";
	String Actaul_Title = driver.getTitle();
	if(Expected_Title.equalsIgnoreCase(Actaul_Title))
	{
		test.log(LogStatus.PASS, "Title is Matching:::"+Expected_Title+"       "+Actaul_Title);
	}
	else
	{
		test.log(LogStatus.FAIL, "Title is Not Matching:::"+Expected_Title+"       "+Actaul_Title);
	}
}
@Test
public void testcase2()
{
	test= report.startTest("Fail Test");
	test.assignAuthor("Ranga");
	test.assignCategory("Functional");
	String Expected_Title ="Gmail";
	String Actaul_Title = driver.getTitle();
	if(Expected_Title.equalsIgnoreCase(Actaul_Title))
	{
		test.log(LogStatus.PASS, "Title is Matching:::"+Expected_Title+"       "+Actaul_Title);
	}
	else
	{
		test.log(LogStatus.FAIL, "Title is Not Matching:::"+Expected_Title+"       "+Actaul_Title);
	}
}
@AfterMethod
public void tearDown()
{
	report.endTest(test);
	report.flush();
	driver.quit();
}
}












