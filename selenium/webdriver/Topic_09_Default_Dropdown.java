package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    public String getEmailAddress() {
        Random random = new Random();
        return "minhha" + random.nextInt(99999) + "@gmail.com";
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String firstName_text = "Minh";
    public String lastName_text = "Hoang";

    public String email_text = getEmailAddress();
    public String password_text = "Hoangducanh2003@";

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a[class='ico-register']")).click();
        driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys(firstName_text);
        driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys(lastName_text);
        driver.findElement(By.cssSelector("input[id='Email']")).sendKeys(email_text);

        Select day_dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day_dropdown.selectByVisibleText("21");
        Assert.assertFalse(day_dropdown.isMultiple());
        List<WebElement> dayOptions = day_dropdown.getOptions();
        Assert.assertEquals(dayOptions.size(), 32);

        Select month_dropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month_dropdown.selectByVisibleText("January");
        Assert.assertFalse(month_dropdown.isMultiple());
        List<WebElement> monthOptions = month_dropdown.getOptions();
        Assert.assertEquals(monthOptions.size(), 13);

        Select year_dropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));
        Assert.assertFalse(year_dropdown.isMultiple());
        List<WebElement> yearOptions = year_dropdown.getOptions();
        Assert.assertEquals(yearOptions.size(), 112);
        year_dropdown.selectByVisibleText("1996");


//        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("21");
//        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("January");
//        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1996");


        driver.findElement(By.cssSelector("input[id='Password']")).sendKeys(password_text);
        driver.findElement(By.cssSelector("input[id='ConfirmPassword']")).sendKeys(password_text);

        driver.findElement(By.id("register-button")).click();
        sleepInSeconds(3);

//        Assert.assertTrue(driver.findElement());
    }

    @Test
    public void TC_02_Login() {

    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
}