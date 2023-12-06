package webdriver;

import org.openqa.selenium.*;
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
        // HTML Element: Textbox/ Text Area/ Dropdown/ Checkbox/ Link/ Button ...
        // Tìm chưa tương tác lên
        driver.findElement(By.id(""));

        // Tìm và tương tác lên
        driver.findElement(By.id("")).click(); // **
        driver.findElement(By.id("")).sendKeys(); // **

        // Tìm và lưu nó vào 1 biến WebElement (chưa tương tác)
        // Khi dùng biến này ít nhất từ 2 lần trở lên
        WebElement  fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();    // **
        fullNameTextbox.sendKeys();
        fullNameTextbox.getAttribute("");

        // Những hàm tương tác vs Element luôn luôn là hàm Void

        // Trả về nhiều elements khớp vs điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));


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
        Assert.assertTrue(driver.findElement(By.id("")).isSelected()); // *
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (default/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Dùng để Verify 1 element bất kỳ có hiển thị hay ko?
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed()); // **

        // Dùng để Verify 1 element có được thao tác lên hay ko? (ko phải read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled()); // *
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML Element
        driver.findElement(By.id("")).getAttribute("name");  // *

        // Tab Accesibility/Properties
        driver.findElement(By.id("")).getAccessibleName(); // *
        driver.findElement(By.id("")).getDomAttribute("checked"); // *
        driver.findElement(By.id("")).getDomProperty("baseURI"); // *
        driver.findElement(By.id("")).getDomProperty("outerHTML"); // *

        // Tab Styles trong Elements
        // Font/ Size/ Color/ Background/ ...
        driver.findElement(By.id("")).getCssValue("background-color"); // *

        // rbg(46, 138, 184)
        driver.findElement(By.id("")).getCssValue("font-size");
        driver.findElement(By.id("")).getCssValue("text-transform");

        // Vị trí của element so vs độ phân giải màn hình
        Point nameTextboxLocation =  driver.findElement(By.id("")).getLocation();
        nameTextboxLocation.getX();
        nameTextboxLocation.getY();

        // Chiều cao + rộng
        Dimension   addressSize = driver.findElement(By.id("")).getSize();


        // Location + Size
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

        /// Lấy riêng Location
        Point namePoint = nameTextboxRect.getPoint();

        /// Lấy riêng Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        // Shadow element
        driver.findElement(By.id("")).getShadowRoot();

        // Từ id/ class/ name/ css/ xpath có thể truy ra ngược lại tagname HTML
        driver.findElement(By.id("")).getTagName();
        driver.findElement(By.cssSelector("")).getTagName();
        driver.findElement(By.className("")).getTagName();
        driver.findElement(By.xpath("")).getTagName();

        driver.findElement(By.id("")).getText(); // **

        // Chụp hình bị lỗi và lưu dưới dạng BYTE/FILE/BASE64
        driver.findElement(By.cssSelector("")).getScreenshotAs(OutputType.FILE); // Lưu thành 1 hình có kích thước trong ổ cứng .png/ .jpg/ ...)
        driver.findElement(By.cssSelector("")).getScreenshotAs(OutputType.BYTES); //
        driver.findElement(By.cssSelector("")).getScreenshotAs(OutputType.BASE64); // Hình dạng text   // *

        // Form (element nào là thẻ form hoặc nằm trong thẻ form
        // Hành vi giống phím Enter trên màn hình
        // Login/ Search/ Register
        driver.findElement(By.id("")).submit();

    }

    @Test
    public void TC_02_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
