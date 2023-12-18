package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Textbox_Textarea {
    WebDriver driver;

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    WebElement myAccount_link;
    WebElement email_field;
    WebElement password_field;
    WebElement login_btn;
    WebElement requiredField_errorMsg_email;
    WebElement requiredField_errorMsg_password;


    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
        sleepInSeconds(3);

        myAccount_link = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
    }

    @Test
    public void TC_01_Empty_Email_And_Password() {
        myAccount_link.click();
        sleepInSeconds(2);

        email_field = driver.findElement(By.cssSelector("input#email"));
        password_field = driver.findElement(By.cssSelector("input#pass"));
        login_btn = driver.findElement(By.cssSelector("button#send2"));
        sleepInSeconds(2);

        requiredField_errorMsg_email = driver.findElement(By.cssSelector("div#advice-required-entry-email"));
        requiredField_errorMsg_password = driver.findElement(By.cssSelector("div#advice-required-entry-pass"));

        Assert.assertTrue(requiredField_errorMsg_email.isDisplayed());
        Assert.assertEquals(requiredField_errorMsg_email.getText(), "This is a required field.");
        Assert.assertTrue(requiredField_errorMsg_password.isDisplayed());
        Assert.assertEquals(requiredField_errorMsg_password.getText(), "This is a required field.");
    }

    @Test
    public void TC_02_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
