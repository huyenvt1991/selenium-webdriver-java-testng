package webdriver;

import com.beust.ah.A;
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
    WebElement invalidEmail_errorMsg;
    WebElement lessThan6characters_errorMsg;
    WebElement invalidLoginorPassword_errorMsg;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
        sleepInSeconds(3);

        myAccount_link = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));

        myAccount_link.click();
        sleepInSeconds(2);

        email_field = driver.findElement(By.cssSelector("input#email"));
        password_field = driver.findElement(By.cssSelector("input#pass"));
        login_btn = driver.findElement(By.cssSelector("button#send2"));

    }

    @Test
    public void TC_01_Empty_Email_And_Password() {
        login_btn.click();
        sleepInSeconds(2);

        requiredField_errorMsg_email = driver.findElement(By.cssSelector("div#advice-required-entry-email"));
        requiredField_errorMsg_password = driver.findElement(By.cssSelector("div#advice-required-entry-pass"));

        Assert.assertTrue(requiredField_errorMsg_email.isDisplayed());
        Assert.assertEquals(requiredField_errorMsg_email.getText(), "This is a required field.");
        Assert.assertTrue(requiredField_errorMsg_password.isDisplayed());
        Assert.assertEquals(requiredField_errorMsg_password.getText(), "This is a required field.");
    }

    @Test
    public void TC_02_Invalid_Email() {
        email_field.sendKeys("123434234@12312.123123");
        password_field.sendKeys("123456");
        login_btn.click();;
        sleepInSeconds(2);

        invalidEmail_errorMsg = driver.findElement(By.id("advice-validate-email-email"));
        Assert.assertTrue(invalidEmail_errorMsg.isDisplayed());
        Assert.assertEquals(invalidEmail_errorMsg.getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_03_Password_Less_Than_6_Characters() {
        this.email_field.clear();
        this.password_field.clear();;
        this.email_field.sendKeys("automation@gmail.com");
        this.password_field.sendKeys("123");
        this.login_btn.click();
        sleepInSeconds(2);

        this.lessThan6characters_errorMsg = driver.findElement(By.id("advice-validate-password-pass"));
        Assert.assertTrue(this.lessThan6characters_errorMsg.isDisplayed());
        Assert.assertEquals(this.lessThan6characters_errorMsg.getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_Incorrect_Email_or_Password() {
        this.email_field.clear();
        this.email_field.sendKeys("automation@gmail.com");
        this.password_field.clear();
        this.password_field.sendKeys("123123123");
        this.login_btn.click();
        sleepInSeconds(2);

        this.invalidLoginorPassword_errorMsg = driver.findElement(By.id(""));
        Assert.assertTrue(this.invalidLoginorPassword_errorMsg.isDisplayed());
        Assert.assertEquals(this.invalidLoginorPassword_errorMsg.getText(), "sdsadasdasd");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
