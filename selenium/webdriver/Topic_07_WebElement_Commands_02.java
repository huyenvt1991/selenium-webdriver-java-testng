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

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement  emailField;
    public WebElement  ageUnder18_radioBtn;
    public WebElement  educationField;
    public WebElement  jobRole01_dropDown;
    public WebElement  jobRole02_dropDown;
    public WebElement  development_checkbox;
    public WebElement  slider01;
    public WebElement  passwordField;
    public WebElement  age_disabledRadio;
    public WebElement  jobRole03_dropDown;
    public WebElement  interests_disabledCheckbox;
    public WebElement  slider02;
    public WebElement  language_java_checkbox;
    public WebElement  mailchimp_passwordField;


    @BeforeClass()
    public void beforeClass() {
        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        emailField = driver.findElement(By.id("email"));
        ageUnder18_radioBtn = driver.findElement(By.id("under_18"));
        educationField = driver.findElement(By.id("under_18"));
        jobRole01_dropDown = driver.findElement(By.id("job1"));
        jobRole02_dropDown = driver.findElement(By.id("job2"));
        development_checkbox = driver.findElement(By.id("development"));
        slider01 = driver.findElement(By.id("slider-1"));
        passwordField = driver.findElement(By.id("disable_password"));
        age_disabledRadio = driver.findElement(By.id("radio-disabled"));
        jobRole03_dropDown = driver.findElement(By.id("job3"));
        interests_disabledCheckbox = driver.findElement(By.id("check-disbaled"));
        slider02 = driver.findElement(By.id("slider-2"));
        language_java_checkbox = driver.findElement(By.id("java"));
        mailchimp_passwordField = driver.findElement(By.id("new_password"));
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        if (emailField.isDisplayed()) {
            emailField.sendKeys("Automation Testing");
            System.out.print("Email textbox is displayed");
        }   else {
            System.out.print("Email textbox is not displayed");
        }

        if (ageUnder18_radioBtn.isDisplayed()) {
            ageUnder18_radioBtn.click();
            System.out.print("Under 18 radio is displayed");
        }   else {
            System.out.print("Under 18 radio is not displayed");
        }

        if (educationField.isDisplayed()) {
            educationField.sendKeys("Automation Testing");
            System.out.print("Education textarea is displayed");
        }   else {
            System.out.print("Education textarea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            educationField.sendKeys("Automation Testing");
            System.out.print("Name User5 text is displayed");
        }   else {
            System.out.print("Name User5 text is not displayed");
        }
        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());
        System.out.println("Element is not displayed");
    }

    @Test
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        if (emailField.isEnabled()) {
            System.out.print("Email textbox is enabled");
        }   else {
            System.out.print("Email textbox is disabled");
        }

        if (passwordField.isEnabled()) {
            System.out.print("Password textbox is enabled");
        }   else {
            System.out.print("Password textbox is disabled");
        }

        if (interests_disabledCheckbox.isEnabled()) {
            System.out.print("Interests checkbox is enabled");
        }   else {
            System.out.print("Interests checkbox is disabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        ageUnder18_radioBtn.click();
        Assert.assertTrue(ageUnder18_radioBtn.isSelected());

        language_java_checkbox.click();;
        Assert.assertTrue(language_java_checkbox.isSelected());
        language_java_checkbox.click();
        sleepInSeconds(2);
        Assert.assertFalse(language_java_checkbox.isSelected());
    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        sleepInSeconds(3);

        emailField.sendKeys("minhha1.bhsoft@gmail.com");
        sleepInSeconds(2);

        // Case 1: Number
        mailchimp_passwordField.sendKeys("12345");
        sleepInSeconds(2);

        WebElement helperText_lowercase_notCompleted = driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']"));
        Assert.assertTrue(helperText_lowercase_notCompleted.isDisplayed());
        WebElement helperText_uppercase_notCompleted = driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']"));
        Assert.assertTrue(helperText_uppercase_notCompleted.isDisplayed());
        WebElement helperText_number_completed = driver.findElement(By.xpath("//li[@class='number-char completed']"));
        Assert.assertTrue(helperText_number_completed.isDisplayed());
        WebElement helperText_special_notCompleted = driver.findElement(By.cssSelector("li[class='special-char not-completed']"));
        Assert.assertTrue(helperText_special_notCompleted.isDisplayed());
        WebElement helperText_maxLength_notCompleted = driver.findElement(By.cssSelector("li[class='8-char not-completed']"));
        Assert.assertTrue(helperText_maxLength_notCompleted.isDisplayed());

        // Case 2: Lowercase
        mailchimp_passwordField.clear();
        mailchimp_passwordField.sendKeys("minhha");
        sleepInSeconds(2);

        WebElement helperText_lowercase_completed = driver.findElement(By.xpath("//li[@class='lowercase-char completed']"));
        Assert.assertTrue(helperText_lowercase_completed.isDisplayed());
        Assert.assertTrue(helperText_uppercase_notCompleted.isDisplayed());
        WebElement helperText_number_notCompleted = driver.findElement(By.xpath("//li[@class='number-char not-completed']"));
        Assert.assertTrue(helperText_number_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_special_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_maxLength_notCompleted.isDisplayed());

        // Case 3: Uppercase
        mailchimp_passwordField.clear();
        mailchimp_passwordField.sendKeys("MINHHA");
        sleepInSeconds(2);

        Assert.assertTrue(helperText_lowercase_notCompleted.isDisplayed());
        WebElement helperText_uppercase_completed = driver.findElement(By.xpath("//li[@class='uppercase-char completed']"));
        Assert.assertTrue(helperText_uppercase_completed.isDisplayed());
        Assert.assertTrue(helperText_number_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_special_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_maxLength_notCompleted.isDisplayed());

        // Case 4: Special characters
        mailchimp_passwordField.clear();
        mailchimp_passwordField.sendKeys("#$@%^");
        sleepInSeconds(2);

        Assert.assertTrue(helperText_lowercase_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_uppercase_completed.isDisplayed());
        Assert.assertTrue(helperText_number_notCompleted.isDisplayed());
        WebElement helperText_special_completed = driver.findElement(By.cssSelector("li[class='8-char completed"));
        Assert.assertTrue(helperText_special_completed.isDisplayed());
        Assert.assertTrue(helperText_maxLength_notCompleted.isDisplayed());

        // Case 5: Max Length
        mailchimp_passwordField.clear();
        mailchimp_passwordField.sendKeys("12345689");
        sleepInSeconds(2);

        Assert.assertTrue(helperText_lowercase_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_uppercase_notCompleted.isDisplayed());
        Assert.assertTrue(helperText_number_completed.isDisplayed());
        Assert.assertTrue(helperText_special_notCompleted.isDisplayed());
        WebElement helperText_maxLength_completed = driver.findElement(By.cssSelector("li[class='8-char completed"));
        Assert.assertTrue(helperText_maxLength_completed.isDisplayed());

        // Case 6: Valid
        mailchimp_passwordField.clear();
        mailchimp_passwordField.sendKeys("Hoangducanh2003@");
        sleepInSeconds(2);

        Assert.assertFalse(helperText_lowercase_completed.isDisplayed());
        Assert.assertFalse(helperText_uppercase_completed.isDisplayed());
        Assert.assertFalse(helperText_number_completed.isDisplayed());
        Assert.assertFalse(helperText_special_completed.isDisplayed());
        Assert.assertFalse(helperText_maxLength_completed.isDisplayed());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
