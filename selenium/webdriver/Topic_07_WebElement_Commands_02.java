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
    WebElement  development_checkbox = driver.findElement(By.id("development"));
    WebElement  slider01 = driver.findElement(By.id("slider-1"));
    WebElement  passwordField = driver.findElement(By.id("disable_password"));
    WebElement  age_disabledRadio = driver.findElement(By.id("radio-disabled"));
    WebElement  jobRole03_dropDown = driver.findElement(By.id("job3"));
    WebElement  interests_disabledCheckbox = driver.findElement(By.id("check-disbaled"));
    WebElement  slider02 = driver.findElement(By.id("slider-2"));



    @Test
    public void TC_01_Displayed() {
        if (Assert.assertTrue(emailField.isDisplayed())) {
            emailField.sendKeys("Automation Testing");
        }

        Assert.assertTrue(emailField.isDisplayed());

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
        Assert.assertTrue(jobRole01_dropDown.isEnabled());
        Assert.assertTrue(jobRole02_dropDown.isEnabled());
        Assert.assertTrue(development_checkbox.isEnabled());
        Assert.assertTrue(slider01.isEnabled());
        Assert.assertFalse(passwordField.isEnabled());
        Assert.assertFalse(age_disabledRadio.isEnabled());
        Assert.assertFalse(jobRole03_dropDown.isEnabled());
        Assert.assertFalse(interests_disabledCheckbox.isEnabled());
        Assert.assertFalse(slider02.isEnabled());






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
