package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * DashboardPage:
 * - For OrangeHRM dashboard page
 */
public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for dashboard welcome message
    private By dashboardHeader = By.xpath("//h1[contains(text(),'Dashboard')]");

    // Get dashboard header text
    public String getHeaderText() {
        return driver.findElement(dashboardHeader).getText();
    }
}
