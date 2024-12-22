package TestNG;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Junit {

	  static WebDriver driver;

	  @BeforeClass
	  public static void setup() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	  

	//  @BeforeClass
	 // public void visitURL() {
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  }
	  //}
	  @Test
	  public void handleCheckbox() {
	   
	    WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
	    checkBox.click();

	    // Verify and check selected checkbox is active
	    System.out.println(checkBox.getDomAttribute("value") + " is selected: " + checkBox.isSelected());
	  }

	  @Test
	  public void handleRadioButton() {
	    
		  
	    WebElement radioBtn = driver.findElement(By.xpath("(//input[@class='radioButton'])[1]"));
	    radioBtn.click();

	    // Verify and check selected Checkbox  active
	    System.out.println(radioBtn.getDomAttribute("value") + " is selected: " + radioBtn.isSelected());
	  }

	  @Test
	  public void handleMultipleCheckboxes() {
	    List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkBoxOption2"));

	    for (WebElement checkbox : checkboxes) {
	      if (checkbox.getDomAttribute("value").equals("option2")) {
	        checkbox.click();
	      }

	      // Verify and check the selected checkbox is active
	      System.out.println(checkbox.getDomAttribute("value") + " is selected: " + checkbox.isSelected());
	    }
	  }

	  @Test
	  public void handleMultipleRadioBtns() {
	    List<WebElement> radioBtns = driver.findElements(By.cssSelector("input[type='radio']"));

	    for (WebElement radioBtn : radioBtns) {
	      if (radioBtn.getDomAttribute("value").equals("radio2")) {
	        radioBtn.click();
	      }

	      // Verify and check the selected radio button active
	      System.out.println(radioBtn.getDomAttribute("value") + " is selected: " + radioBtn.isSelected());
	    }
	  }

	  @AfterClass
	  public static void close() {
	    driver.quit();
	  }
	}