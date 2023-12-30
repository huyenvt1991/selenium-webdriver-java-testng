package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    public String getEmailAddress() {
        Random random = new Random();
        return "minhha" + random.nextInt(99999) + "@gmail.com";
    }

    public String firstName_text = "Minh";
    public String lastName_text = "Hoang";

    public String email_text = getEmailAddress();


    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a[class='ico-register']")).click();
        driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Minh");
        driver.findElement(By.cssSelector("a[class='ico-register']")).click();

    }

    @Test
    public void TC_02_Login() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}