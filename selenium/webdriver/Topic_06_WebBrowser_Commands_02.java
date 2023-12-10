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

public class Topic_06_WebBrowser_Commands_02 {
    WebDriver driver;

    @BeforeClass()
    public void beforeClass() {
        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
    }

    @Test
    public void TC_01_Page_Url() {
        WebElement myAccounturl_locator = driver.findElement(By.xpath("//div[@class='footer']/div[4]/ul/li[1]/a"));
        myAccounturl_locator.click();
        // 1000 ms = 1s
        sleepInSeconds(3);


        // Trong 1 class từ 1 hàm có thể gọi qua hàm khác (call function)

        String  currentURL = driver.getCurrentUrl();
        String  expectedURL = "http://live.techpanda.org/index.php/customer/account/login/";
        Assert.assertEquals(currentURL, expectedURL);

        WebElement createAnaccountBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnaccountBtn.click();

        String  currentURL2 = driver.getCurrentUrl();
        String  expectedURL2 = "http://live.techpanda.org/index.php/customer/account/create/";
        Assert.assertEquals(currentURL2, expectedURL2);

    }

    @Test
    public void TC_02_Page_Title() {
        WebElement myAccounturl_locator = driver.findElement(By.xpath("//div[@class='footer']/div[4]/ul/li[1]/a"));
        myAccounturl_locator.click();

        String loginpageTitle = driver.getTitle();
        Assert.assertEquals(loginpageTitle, "Customer Login");

        WebElement createAnaccountBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnaccountBtn.click();

        String registerpageTitle = driver.getTitle();
        Assert.assertEquals(registerpageTitle, "Create New Customer Account");
    }

    @Test
    public void TC_03_Page_Navigation() {
        WebElement myAccounturl_locator = driver.findElement(By.xpath("//div[@class='footer']/div[4]/ul/li[1]/a"));
        myAccounturl_locator.click();

        WebElement createAnaccountBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnaccountBtn.click();

        String  registerpageURL = driver.getCurrentUrl();
        String  expectedURL = "http://live.techpanda.org/index.php/customer/account/create/";
        Assert.assertEquals(registerpageURL, expectedURL);

        driver.navigate().back();

        String  loginpageURL = driver.getCurrentUrl();
        String  expectedURL2 = "http://live.techpanda.org/index.php/customer/account/login/";
        Assert.assertEquals(loginpageURL, expectedURL2);

        driver.navigate().forward();

        String registerpageTitle = driver.getTitle();
        Assert.assertEquals(registerpageTitle, "Create New Customer Account");
    }

    @Test
    public void TC_04_Page_Source() {
        WebElement myAccounturl_locator = driver.findElement(By.xpath("//div[@class='footer']/div[4]/ul/li[1]/a"));
        myAccounturl_locator.click();

        String loginpageSource = driver.getPageSource();
        Assert.assertTrue(loginpageSource.contains(" LOGIN OR CREATE AN ACCOUNT "));

        WebElement createAnaccountBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnaccountBtn.click();

        String registerpageSource = driver.getPageSource();
        Assert.assertTrue(registerpageSource.contains("CREATE AN ACCOUNT"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}