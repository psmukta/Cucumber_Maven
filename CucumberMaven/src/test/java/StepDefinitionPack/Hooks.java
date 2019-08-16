package StepDefinitionPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C://ITTraining//AllDriver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.manage().window().setSize(new Dimension(700,700));
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	@AfterTest
	public void TearDown() {
		driver.close();
	}
	

}
