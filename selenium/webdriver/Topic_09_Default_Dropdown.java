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

    public String day_text = "21";
    public String month_text = "January";
    public String year_text = "1996";


    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a[class='ico-register']")).click();
        driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys(firstName_text);
        driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys(lastName_text);
        driver.findElement(By.cssSelector("input[id='Email']")).sendKeys(email_text);

        Select day_dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day_dropdown.selectByVisibleText(this.day_text);
        Assert.assertFalse(day_dropdown.isMultiple()); // Ít dùng
        List<WebElement> dayOptions = day_dropdown.getOptions(); // Ít dùng
        Assert.assertEquals(dayOptions.size(), 32); // Ít dùng

        Select month_dropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month_dropdown.selectByVisibleText(this.month_text);
        Assert.assertFalse(month_dropdown.isMultiple()); // Ít dùng
        List<WebElement> monthOptions = month_dropdown.getOptions(); // Ít dùng
        Assert.assertEquals(monthOptions.size(), 13); // Ít dùng

        Select year_dropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));
        Assert.assertFalse(year_dropdown.isMultiple()); // Ít dùng
        List<WebElement> yearOptions = year_dropdown.getOptions(); // Ít dùng
        Assert.assertEquals(yearOptions.size(), 112); // Ít dùng
        year_dropdown.selectByVisibleText(this.year_text);


//        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("21");
//        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("January");
//        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1996");


        driver.findElement(By.cssSelector("input[id='Password']")).sendKeys(password_text);
        driver.findElement(By.cssSelector("input[id='ConfirmPassword']")).sendKeys(password_text);

        driver.findElement(By.id("register-button")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.className("result")).getText().contains("Your registration completed"));
    }

    @Test
    public void TC_02_Login() {
        driver.findElement(By.className("ico-login")).click();
        sleepInSeconds(2);

        driver.findElement(By.id("Email")).sendKeys(this.email_text);
        driver.findElement(By.id("Password")).sendKeys(this.password_text);
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), this.firstName_text);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), this.lastName_text);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), this.day_text);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), this.month_text);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), this.year_text);

        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), this.email_text);

    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
}