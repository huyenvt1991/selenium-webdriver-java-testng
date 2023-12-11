package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void TC_01_Displayed() {
        WebElement  emailField = driver.findElement(By.id("email"));
        Assert.assertTrue(emailField.isDisplayed());

        WebElement  ageUnder18_radioBtn = driver.findElement(By.id("under_18"));
        Assert.assertTrue(ageUnder18_radioBtn.isDisplayed());

        WebElement  educationField = driver.findElement(By.id("under_18"));
        Assert.assertTrue(educationField.isDisplayed());
    }

    @Test
    public void TC_02_Enabled() {

    }

    @Test
    public void TC_03_Selected() {

    }

    @Test
    public void TC_04_MailChimp() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
