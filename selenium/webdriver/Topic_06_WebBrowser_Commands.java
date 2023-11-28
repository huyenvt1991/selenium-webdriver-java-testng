package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_06_WebBrowser_Commands {
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
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new InternetExplorerDriver();
        driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        // m - method
        //f - field
        //c - class
        //i - interface
        //e - enum
        //a - abstract class
        //@ - annotation
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));

        // Không được tìm thấy ==> ko bị fail ==> trả về 1 list rỗng (0 element)
        List<WebElement> checkboxes = driver.findElements(By.xpath(""));

        // Dùng để lấy ra URL của màn hình/ page hiện tại đang đứng
        driver.getCurrentUrl();
        driver.getPageSource();
        driver.getTitle();
        driver.getWindowHandle();
        driver.getWindowHandles();


    }

    @Test
    public void TC_02_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
