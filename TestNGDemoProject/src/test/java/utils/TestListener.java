package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("❌ Test Failed: " + result.getName());

        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshots/" + result.getName() + "_" + timestamp + ".png";

            try {
                FileHandler.createDir(new File("screenshots"));
                FileHandler.copy(screenshot, new File(fileName));
                System.out.println("📸 Screenshot saved: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
