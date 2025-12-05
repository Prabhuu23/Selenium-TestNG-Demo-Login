package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Stay open for debugging
        System.out.println("Browser opened...");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test finished. Browser will remain open for 5 seconds...");
        try {
            Thread.sleep(5000); // prevent immediate close
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
