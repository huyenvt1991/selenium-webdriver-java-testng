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

    WebElement  emailField = driver.findElement(By.id("email"));
    WebElement  ageUnder18_radioBtn = driver.findElement(By.id("under_18"));
    WebElement  educationField = driver.findElement(By.id("under_18"));
    WebElement  jobRole01_dropDown = driver.findElement(By.id("job1"));
    WebElement  jobRole02_dropDown = driver.findElement(By.id("job2"));

    @Test
    public void TC_01_Displayed() {
        Assert.assertTrue(emailField.isDisplayed());
        emailField.sendKeys("Automation Testing");

        Assert.assertTrue(ageUnder18_radioBtn.isDisplayed());
        ageUnder18_radioBtn.click();

        Assert.assertTrue(educationField.isDisplayed());
        educationField.sendKeys("Automation Testing");

        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());
        System.out.println("Element is not displayed");
    }

    @Test
    public void TC_02_Enabled() {
        Assert.assertTrue(emailField.isEnabled());

        Assert.assertTrue(ageUnder18_radioBtn.isEnabled());

        Assert.assertTrue(educationField.isEnabled());

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
