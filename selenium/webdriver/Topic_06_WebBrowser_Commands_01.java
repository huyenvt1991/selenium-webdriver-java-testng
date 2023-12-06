package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Topic_06_WebBrowser_Commands_01 {
    // Các câu lệnh để thao tác với Browser
    // driver.
    //  class kế thừa 1 class khác: Extends
    //  class kế thừa 1 interface: Implements
    //  cùng type: Extends
    //  khác type: Implements
    //  không support interface kế thừa class
    //  kế thừa: 1 class không kế thừa nhiều hơn 1 class, nhưng có thể kế thừa > 1 interface
    //  chromedriver, firefoxdriver, edgedriver kế thừa từ remotedriver (chạy trên grid, docker, cloud, ...)
    //  remotedriver Implements webdriver
    //  webdriver kế thừa SearchContext
    //  muốn dùng biến phải khởi tạo bằng cách New (Inject, Inherent, ...) nó lên
    WebDriver driver;

    // Các câu lệnh để thao tác với Element
    // element.
    WebElement  element;

    @BeforeClass
    public void beforeClass() {
        // Muốn dùng được thì phải khởi tạo
        // Nếu không khởi tạo sẽ gặp lỗi: NullPointerException
        // 1 biến chưa được khởi tạo nhưng đã được gọi ra để sử dụng
//        driver = new FirefoxDriver();
        driver = new ChromeDriver(); // **
//        driver = new EdgeDriver();
//        driver = new InternetExplorerDriver();
//        driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // **
        driver.manage().window().maximize(); // **
    }

    @Test
    public void TC_01_() throws MalformedURLException {
        // m - method
        //f - field
        //c - class
        //i - interface
        //e - enum
        //a - abstract class
        //@ - annotation

        // Mở ra 1 URL bất kỳ
        driver.get("https://www.facebook.com/"); // **

        System.out.print("Tab ID = " + driver.getWindowHandle());

        // Nếu như có 1 tab thì tính năng tự quit
        // Nhiều hơn thì sẽ đóng cái đang active
        driver.close(); // *

        // Đóng browser (bao nhiêu tab đóng hết)
        driver.quit(); // **

        WebElement emailAddressTextbox = driver.findElement(By.id("email")); // **

        // Không được tìm thấy ==> ko bị fail ==> trả về 1 list rỗng (0 element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("")); // **

        // Dùng để lấy ra URL của màn hình/ page hiện tại đang đứng
        driver.getCurrentUrl(); // *
        Assert.assertTrue(driver.getCurrentUrl().contains(""));

        // Lấy ra page source HTML/CSS/JS của page hiện tại
        // Thường dùng để verify 1 cách tương đối
        driver.getPageSource();

        // Lấy ra title của page hiện tại
        driver.getTitle();

        // Lấy ra ID của tab hiện tại
        // Dùng cho bài Handle Window/Tab
        driver.getWindowHandle(); // *
        driver.getWindowHandles(); // *

        // Dùng cho bài Cookies - Framework
        driver.manage().getCookies(); // *

        // Get ra những logs ở Dev Tool
        driver.manage().logs().get(LogType.DRIVER); // *

        // Apply cho việc tìm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // **

        // Chờ cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set trước khi dùng vs thư viện JavascriptExecutor
        // Inject 1 đoạn code JS vào trong Browser/Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Selenium 4 trở lên mới có - Ít dùng
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        // Chạy full màn hình - Tương tự F11 - Ít dùng
        driver.manage().window().fullscreen();

        // Hay dùng
        driver.manage().window().maximize(); // **
        driver.manage().window().minimize();

        // Test giao diện - GUI
        // Chọn độ phân giải của Browser để chạy - Dùng để test Responsive
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().window().getSize();

        // Set cho Browser ở vị trí nào so với độ phân giải của màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // Điều hướng trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        // Hỗ trợ tốt hơn khi thao tác history của web page (back/forward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));

        // Alert/ Window (Tab)/ Frame (iFrame) // *
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");

        // Handle Window/Tab // *
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        Set<String> allWindowIDs = driver.getWindowHandles();

        // Handle Frame(Iframe) // *
        driver.switchTo().frame(0);
        driver.switchTo().frame("123456");
        driver.switchTo().frame(driver.findElement(By.id("frame")));

        // Switch về HTML chứa frame trước đó // *
        driver.switchTo().defaultContent();

        // Từ frame bên trong đi ra frame bên ngoài chứa nó // *
        driver.switchTo().parentFrame();


    }

    @Test
    public void TC_02_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
