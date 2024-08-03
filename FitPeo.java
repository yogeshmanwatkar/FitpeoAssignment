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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FitPeo {

	private static final int WebElement = 0;
	public static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.fitpeo.com/home");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		WebElement revenueCal = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		revenueCal.click();
		
		WebElement slideBar = driver.findElement(By.xpath("//span[contains(text(),'Patients should be between 0 to 2000')]"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(slideBar).perform();
		
		//WebElement textBox = driver.findElement(By.xpath("//input[@type='number']"));
		//textBox.clear();
		
		//WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		//act.clickAndHold(slider).moveByOffset(93, 0).build().perform();
		
		WebElement textBox = driver.findElement(By.xpath("//input[@type='number']"));
		//textBox.clear();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
		js. executeScript("arguments[0]. value='560';", textBox);
		
		//textBox.clear();
		
		//act.sendKeys(textBox, "560").perform();
		//String textBoxValue = textBox.getText();
		
		WebElement sliderValue = driver.findElement(By.xpath("//input[@type='range']"));
		
		String expectedValue = sliderValue.getAttribute("value");
		System.out.println(expectedValue);
		
	//	assertEquals(textBoxValue, sliderValue);
		
		
		//WebElement checkbox = driver.findElements(By.xpath(//input[@class='PrivateSwitchBase-input css-1m9pwf3']);
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
		int numberOfElements =3;
		int requiredElements =  Math.min(numberOfElements, checkbox.size());
		for(int i = 0; i< requiredElements; i++) {
			
			WebElement elementToClick = checkbox.get(i);
			elementToClick.click();
		}
		
		
		
	}

}
