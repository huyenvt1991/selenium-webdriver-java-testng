package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Scope {
    // Các biến được khai báo ở bên ngoài hàm -> phạm vi là Class
    // Biến Global (toàn cục)
    // Có thể dùng cho tất cả các hàm ở trong 1 Class đó

    WebDriver driver;

    String homePageUrl; // Khai báo: Declare

    String fullname = "AutomationFC"; // Khai báo và khởi tạo (Initial)

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public  void TC_01_() {
        // Các biến được khai bo ở trong 1 hàm/ block code -> phạm vi cục bộ (Local)
        // Dùng trong cái hàm nó được khai báo/ block code được sinh ra
        String homePageUrl;

        // Trong 1 hàm nếu như có 2 biến cùng tên (Global/ Local) thì nó sẽ ưu tiên lấy biến Local dùng
        driver.get(homePageUrl);
    }
}