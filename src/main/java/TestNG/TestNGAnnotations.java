package TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
  WebDriver driver;

  @BeforeClass
  void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @BeforeMethod
  void visitURL() {
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
  }

  @Test
  void handleCheckbox() {
   
	WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
    checkBox.click();
 
    // Verify and check the selected checkbox is active
    System.out.println(checkBox.getDomAttribute("value") + " is selected: " + checkBox.isSelected());
  }

  @Test(priority = 2)
  void handleRadioButton() {
   
    WebElement radioBtn = driver.findElement(By.xpath("//input[@type='radio'][@value='radio1']"));
    radioBtn.click();

    // Verify and check the selected checkbox is active
    System.out.println(radioBtn.getDomAttribute("value") + " is selected: " + radioBtn.isSelected());
  }

  @Test(priority = 3)
  void handleMultipleCheckboxes() {
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

    for (WebElement checkbox : checkboxes) {
      if (checkbox.getDomAttribute("value").equals("option1")) {
        checkbox.click();
      }

      // Verify and check the selected checkbox is active
      System.out.println(checkbox.getDomAttribute("value") + " is selected: " + checkbox.isSelected());
    }
  }

  @Test(priority =  4)
  void handleMultipleRadioBtns() {
    List<WebElement> radioBtns = driver.findElements(By.cssSelector("input[type='radio']"));

    for (WebElement radioBtn : radioBtns) {
      if (radioBtn.getDomAttribute("value").equals("radio3")) {
        radioBtn.click();
      }

      // Verify and check the selected radio button is active
      System.out.println(radioBtn.getDomAttribute("value") + " is selected: " + radioBtn.isSelected());
    }
  }

  @AfterClass
  void close() {
    driver.quit();
  }
}
