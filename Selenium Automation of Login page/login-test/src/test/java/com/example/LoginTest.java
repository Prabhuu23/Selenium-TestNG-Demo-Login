package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void testMultipleLogins() throws InterruptedException {

        // Define multiple email/password combinations
        String[][] credentials = {
            {"khadkaprabhu909@gmail.com", "Qwertyuiop@123"},   // valid
            {"wronguser@gmail.com", "wrongpass"},              // invalid
            {"testuser@gmail.com", "Test@123"},                // another test
        };

        for (String[] cred : credentials) {
            String emailInput = cred[0];
            String passwordInput = cred[1];

            // Launch Chrome
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            try {
                // Open login page
                driver.get("https://dev.autoworksgo.com/auth/login");

                // Enter email
                WebElement email = driver.findElement(By.cssSelector("input[formcontrolname='email']"));
                email.sendKeys(emailInput);

                // Enter password
                WebElement password = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
                password.sendKeys(passwordInput);

                // Click login button
                WebElement loginBtn = driver.findElement(By.xpath("//button[.//span[text()='LOGIN']]"));
                loginBtn.click();

                // Wait for page to load
                Thread.sleep(3000); // you can replace with WebDriverWait

                // Check dashboard welcome text
                boolean loginSuccess;
                try {
                    WebElement welcomeText = driver.findElement(By.cssSelector("b.fs-20"));
                    loginSuccess = welcomeText.isDisplayed() &&
                                   welcomeText.getText().contains("Welcome Back Pratik Khadka");
                } catch (Exception e) {
                    loginSuccess = false;
                }

                // Print result for this user
                if (loginSuccess) {
                    System.out.println("Login PASSED with: " + emailInput);
                } else {
                    System.out.println("Login FAILED with: " + emailInput);
                }

            } catch (Exception e) {
                System.out.println("Error occurred while testing: " + emailInput);
                e.printStackTrace();
            } finally {
                // Close browser for this test
                driver.quit();
            }
        }
    }
}
