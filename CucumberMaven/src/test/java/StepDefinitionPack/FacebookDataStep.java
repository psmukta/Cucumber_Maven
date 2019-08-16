package StepDefinitionPack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Helpers.DataHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookDataStep {
	WebDriver driver;
	List<HashMap<String,String>>datamap;
	public FacebookDataStep() throws IOException {
		driver=Hooks.driver;
		datamap=DataHelper.data(System.getProperty("user.dir")+"//src//test//resources//testdata/Book1.xlsx", "Data1");
	}
	
	@Given("^user is on facebook signup page$")
	public void user_is_on_facebook_signup_page() {
		driver.get("https://www.facebook.com/");
		
	    
	}

	@When("^User will enter and select \"([^\"]*)\"$")
	public void user_will_enter_and_select(String stringvalue) {//stringvalue ta Index 
		int index=Integer.parseInt(stringvalue)-1;
		driver.findElement(By.name("firstname")).sendKeys(datamap.get(index).get("First Name"));
        driver.findElement(By.name("lastname")).sendKeys(datamap.get(index).get("Last Name"));
        driver.findElement(By.name("reg_email__")).sendKeys(datamap.get(index).get("Email"));
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(datamap.get(index).get("AgEmail"));
        driver.findElement(By.name("reg_passwd__")).sendKeys(datamap.get(index).get("Password"));
        
        Select Monthselect=new Select(driver.findElement(By.id("month")));
        Monthselect.selectByVisibleText(datamap.get(index).get("Month"));
        
        Select DaySelect=new Select(driver.findElement(By.id("day")));
        DaySelect.selectByVisibleText(datamap.get(index).get("Day"));
        
        Select YearSelect=new Select(driver.findElement(By.id("year")));
        YearSelect.selectByVisibleText(datamap.get(index).get("Year"));
        
        if(datamap.get(index).get("Sex").equalsIgnoreCase("Female")){
            driver.findElement(By.xpath(".//*[@id='u_0_9']")).click();
        }
        else if(datamap.get(index).get("Sex").equalsIgnoreCase("Male")){
            driver.findElement(By.xpath(".//*[@id='u_0_a']")).click();
        }
        
    }

	    


	@When("^user will click on submit button$")
	public void user_will_click_on_submit_button() {
		 driver.findElement(By.name("websubmit")).click();
		
	    
	}

	@Then("^user will create new account successfully$")
	public void user_will_create_new_account_successfully() {
	    
	}

}
