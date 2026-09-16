package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day2_8_ExplicitwaitVisibility {
    public static void main(String[] args) {
        // Initialize the webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.saucedemo.com/");

            // Initialize explicit wait (10 seconds)
            WebDriverWait obj_wait = new WebDriverWait(driver, Duration.ofSeconds(1));

            // Wait for the element to be visible
            WebElement message = obj_wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("login_logo"))
            );

            // Verify presence and text of the element
            if (message.getText().equalsIgnoreCase("Swag Labs")) {
                System.out.println("PASSED: Text matches expected value -> " + message.getText());
            } else {
                System.out.println("FAILED: Text does not match -> " + message.getText());
            }

        } catch (Exception e) {
            System.out.println("Execution failed due to exception:");
            e.printStackTrace();
        } finally {
            // Close browser connection cleanly
            driver.quit();
        }
    }
}