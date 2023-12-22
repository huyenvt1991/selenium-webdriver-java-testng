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
import java.util.Random;

public class Topic_08_Textbox_Textarea {
    WebDriver driver;

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress() {
        Random random = new Random();
        return "automation" + random.nextInt(99999) + "@gmail.com";
    }

    String firstName_text = "Minh";
    String lastName_text = "Hoang";
    String password_text = "123456";
    String emailAddress_text = getEmailAddress();

    WebElement myAccount_link;
    WebElement email_field;
    WebElement password_field;
    WebElement login_btn;
    WebElement requiredField_errorMsg_email;
    WebElement requiredField_errorMsg_password;
    WebElement invalidEmail_errorMsg;
    WebElement lessThan6characters_errorMsg;
    WebElement invalidLoginorPassword_errorMsg;
    WebElement createAnaccount_btn;

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

        this.invalidLoginorPassword_errorMsg = driver.findElement(By.xpath("//ul[@class='messages']/li/ul/li/span"));
        Assert.assertTrue(this.invalidLoginorPassword_errorMsg.isDisplayed());
        Assert.assertEquals(this.invalidLoginorPassword_errorMsg.getText(), "Invalid login or password.");

    }

    @Test
    public void TC_05_Sucess() {
        // 1 - Đăng kí trước bằng tay (Manual) 1 tài khoản email rồi dùng nó để login cho case này
        // Khi hệ thống bị reset dữ liệu là phải đăng kí lại
        // DB bị xóa data
        // Qua 1 môi trường mới phải đăng kí lại
        // ==> Không nên làm

        // 2 - Sẽ dùng tính năng Register trước - email cố định không thay đổi
        // Chức năng Register cũng auto
        // Email khi dùng đăng kí lại fix cứng (1 lần) ==> Hard code

        // 3 - Sẽ dùng tính năng Register trước - email không cố định (random)
        // Chạy luôn đúng cho tất cả các case

        // Đăng ký 1 tài khooản trước
        this.createAnaccount_btn = driver.findElement(By.xpath("//a[@class='button' and @title='Create an Account']"));
        this.createAnaccount_btn.click();
        sleepInSeconds(2);

        WebElement firstName_field = driver.findElement(By.id("firstname"));
        WebElement lastName_field = driver.findElement(By.id("lastname"));
        WebElement email_field = driver.findElement(By.id("email_address"));
        WebElement password_field = driver.findElement(By.id("password"));
        WebElement confirmPassword_field = driver.findElement(By.id("confirmation"));
        WebElement register_btn = driver.findElement(By.xpath("//button[@class='button' and @title='Register']"));

        firstName_field.sendKeys(this.firstName_text);
        lastName_field.sendKeys(this.lastName_text);

        email_field.sendKeys(emailAddress_text);
        password_field.sendKeys(this.password_text);
        confirmPassword_field.sendKeys(this.password_text);
        register_btn.click();
        sleepInSeconds(2);

        // Login
        String fullName_text = this.firstName_text + " " + this.lastName_text;

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullName_text + "!");
        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/ancestor::div[2]/div[2]/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName_text));
        Assert.assertTrue(contactInfo.contains(emailAddress_text));

        WebElement account = driver.findElement(By.cssSelector("a[class='skip-link skip-account skip-active']"));
        account.click();

        WebElement logOut_btn = driver.findElement(By.cssSelector("a[title='Log Out']"));
        logOut_btn.click();
        sleepInSeconds(2);

        myAccount_link.click();
        sleepInSeconds(2);


    }
//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
}
