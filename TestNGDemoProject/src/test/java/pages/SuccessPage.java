package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/*
 * SuccessPage:
 * - Page object for the post-login page
 * - Can get page title, header, and all visible elements
 */
public class SuccessPage {

    private WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for main content
    private By mainContent = By.tagName("body");

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get main header or success message
    public String getHeaderText() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    // Get all visible text in UI after login
    public String getAllVisibleText() {
        WebElement body = driver.findElement(mainContent);
        return body.getText();
    }

    // Get all buttons/text elements as list
    public List<String> getAllElementsText(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
