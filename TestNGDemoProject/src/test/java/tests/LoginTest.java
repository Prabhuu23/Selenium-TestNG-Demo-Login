package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SuccessPage;
import utils.RetryAnalyzer;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    // 1️⃣ DataProvider → multiple credentials
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"student", "Password123", "success"},  // ✅ valid
                {"student", "wrongpass", "fail"},       // ❌ invalid
                {"wronguser", "Password123", "fail"},   // ❌ invalid
                {"admin", "admin123", "fail"},          // ❌ invalid
                {"student", "Password123", "success"}   // ✅ valid
        };
    }

    // 2️⃣ Test using DataProvider
    @Test(dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)
    public void loginTest(String username, String password, String expectedResult) {

        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (expectedResult.equals("success")) {
            SuccessPage successPage = new SuccessPage(driver);
            System.out.println("✅ SUCCESS LOGIN:");
            System.out.println("Page Title: " + successPage.getPageTitle());
            System.out.println("Header: " + successPage.getHeaderText());
            System.out.println("Full UI Text: " + successPage.getAllVisibleText());

            Assert.assertEquals(successPage.getHeaderText(), "Logged In Successfully");
        } else {
            // ❌ Failure test → fail on purpose to trigger Retry + Screenshot
            System.out.println("❌ FAILED LOGIN: username=" + username + " | password=" + password);
            Assert.fail("Invalid credentials → Test fail to capture screenshot");
        }
    }
}
