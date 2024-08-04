package assignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.w3.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FitPeo {

	private static final int WebElement = 0;
	public static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		//Navigate to fitpeo Home page
		driver.get("https://www.fitpeo.com/home");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 // Navigate to Revenue Calculator page
		
		WebElement revenueCal = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		revenueCal.click();
		
		// Adjust Slider
		WebElement slideBar = driver.findElement(By.xpath("//span[contains(text(),'Patients should be between 0 to 2000')]"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(slideBar).perform();
		
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		act.clickAndHold(slider).moveByOffset(93, 0).build().perform();
		
		//	Update the Text Field:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='number']")));
						
		act.moveToElement(textBox).keyDown(textBox, Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE)
		.keyDown(Keys.BACK_SPACE).build().perform();
		
		act.keyUp(Keys.BACK_SPACE).build().perform();
		textBox.sendKeys("560");
		
		//	Validate Slider Value:
		WebElement sliderValue = driver.findElement(By.xpath("//input[@type='range']"));
		
		String actualValue = textBox.getAttribute("value");
		String expectedValue = sliderValue.getAttribute("value");
	
		System.out.println(expectedValue);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedValue);
		
		//	Select CPT Codes:
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
		int[] numberOfElements = {0,1,2,7};
		
		for(int index : numberOfElements) {
			
			if(index < checkbox.size()) {
				checkbox.get(index).click();
			}
		}
		
		//Verify Header Display
		
		WebElement headerValue = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']"));
		String actualText = headerValue.getText();
		String expectedText = "Total Recurring Reimbursement for all Patients Per Month:\r\n"
				+ "$75600";
		System.out.println("Actual text : "+actualText);
		System.out.println("Expected text : "+expectedText);
		
		SoftAssert assertText =new SoftAssert();
		assertText.assertEquals(actualText, expectedText);
		assertText.assertAll();
		
	}
	
}
