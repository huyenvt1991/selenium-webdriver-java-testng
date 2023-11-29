package javaTester;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;

    @Test
    public  void  verifyTestNG() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // Trong Java có nhiều thư viện để verify dữ liệu
        // Gọi là Testing Framework (dùng cho Unit / Integration / UI Automation Test)
        // Ví dụ: JUnit 4/ TestNG/ JUnit 5/ Hamcrest/ AssertJ/...
        // TestNG vừa là thư viện, vừa là Test runner

        // Kiểu dữ liệu nhận vào là Boolean
        // Khi mong muốn điều kiện trả về là đúng
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        // Khi mong muốn điều kiện trả về là sai
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));

        // Các hàm trả về kiểu dữ liệu là boolean
        // Quy tắc: bắt đầu vs tiền tố là is...
        // WebElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        // Mong đợi 1 điều kiện giống với thực tế (tuyệt đối)
        // Actual = Expected
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Assert.assertEquals(driver.findElement(By.id("")).getText(), "Create a new account");

        // Dùng cho Unit test
        Object name = null;
        Assert.assertNull(name);
        Assert.assertNotNull(name);

    }
}
