package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_07_WebElement_Commands {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Element() {
//        // HTML Element: Textbox/ Text Area/ Dropdown/ Checkbox/ Link/ Button ...
//        // Tìm chưa tương tác lên
//        driver.findElement(By.id(""));
//
//        // Tìm và tương tác lên
//        driver.findElement(By.id("")).click();
//        driver.findElement(By.id("")).sendKeys();
//
//        // Tìm và lưu nó vào 1 biến WebElement (chưa tương tác)
//        // Khi dùng biến này ít nhất từ 2 lần trở lên
//        WebElement  fullNameTextbox = driver.findElement(By.id(""));
//        fullNameTextbox.clear();
//        fullNameTextbox.sendKeys();
//        fullNameTextbox.getAttribute();
//
//        // Những hàm tương tác vs Element luôn luôn là hàm Void
//
        // Trả về nhiều elements khớp vs điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));
        textboxes.add("");

        // Java non Generic
        ArrayList name = new ArrayList();
        name.add("Automation FC");
        name.add(15);
        name.add("B");
        name.add(true);

        // Java Generic
        ArrayList<String> address = new ArrayList<String>();
        name.add("Automation FC");

        // Dùng để Verify 1 checbox/radio/ dropdown (default) đã được chọn hay chưa?
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (default/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Dùng để Verify 1 element bất kỳ có hiển thị hay ko?
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

    }

    @Test
    public void TC_02_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
