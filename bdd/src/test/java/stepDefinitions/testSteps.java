package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class testSteps {
	public WebDriver driver;
	@Given("User is on Login Page")
	public void user_is_on_Login_Page() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	   ChromeOptions option = new ChromeOptions();
	   option.addArguments("--disable-notifications");
	   driver = new ChromeDriver(option);
	   driver.get("https://kite.zerodha.com");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   System.out.println("User is on Login Page");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
	   driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("XA0634");
	   driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sarika699!");
	   driver.findElement(By.xpath("//button")).click();
	   System.out.println("User Enters username and password");
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	   System.out.println("User logged in successfully");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
	    System.out.println("User click on Logout");
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
	   System.out.println("user successfully logged out");
	}
	@When("^User enter pin$")
	public void user_enter_pin() throws Throwable {
		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("691991");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button")).click();
	    System.out.println("User enters the pin");
	}
	@When("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 System.out.println("User successfully navigate to home page");
	 System.out.println(driver.getTitle());
	 System.out.println(driver.getCurrentUrl());
	}
	@Then("^user close the web browser$")
	public void user_close_the_web_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

}
