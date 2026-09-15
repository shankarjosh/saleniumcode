package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment4 {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();
        obj_driver.manage().window().maximize();

        try {
            // 1. Open SauceDemo login page
            obj_driver.get("https://www.saucedemo.com/");

            // 2. Locate form elements
            WebElement usernameField = obj_driver.findElement(By.id("user-name"));
            WebElement passwordField = obj_driver.findElement(By.id("password"));
            WebElement loginButton = obj_driver.findElement(By.id("login-button"));

            // 3. Enter invalid credentials to trigger the red alert box
            usernameField.sendKeys("username");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();

            // 4. Wait explicitly for the red error alert box to become visible
            WebDriverWait wait = new WebDriverWait(obj_driver, Duration.ofSeconds(500));
            WebElement errorBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'error-message-container')]"))
            );

            // 5. Validate if the red error box is displayed
            if (errorBox.isDisplayed()) {
                String errorMessage = errorBox.getText();
                System.out.println("TESTCASE PASSED: Red alert box appeared!");
                System.out.println("Displayed Error: " + errorMessage);
            } else {
                System.out.println("TESTCASE FAILED: Red alert box was not visible.");
            }

        } catch (Exception e) {
            System.out.println("TESTCASE FAILED: Red alert box did not appear or timed out.");
            e.printStackTrace();
        } finally {
            // 6. Clean up browser session
            obj_driver.quit();
        }
    }
}