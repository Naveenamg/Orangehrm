package www.rcb.abd;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class step {
	
	
	
	WebDriver driver;
	
	@Given("user open browser")
	public void user_open_browser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	   
	}

	@When("user enter url")
	public void user_enter_url() {
	driver.get("https://admin-demo.nopcommerce.com/login");
	   
	}

	@When("enter email and password")
	public void enter_email_and_password() {
WebElement ab=driver.findElement(By.id("Email"));
ab.clear();
ab.sendKeys("admin@yourstore.com");
WebElement bc=driver.findElement(By.id("Password"));
bc.clear();
bc.sendKeys("admin");

	}

	@When("login")
	public void login() {
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("verify")
	public void verify() {
	String nv=	driver.getTitle();
	Assert.assertEquals("Dashboard / nopCommerce administration",nv);	
	   
	}

	@Then("close")
	public void close() {
	    driver.close();
	}


}
