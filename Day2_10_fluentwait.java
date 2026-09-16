package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Day2_10_fluentwait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.google.com");

            // Configure FluentWait
            FluentWait<WebDriver> obj_FluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);

            // Wait until element is visible
            WebElement message = obj_FluentWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("login_logo"))
            );

            // Verify presence and text of the element
            if (message.getText().equalsIgnoreCase("Swag Labs")) {
                System.out.println("PASSED: Text matches expected value -> " + message.getText());
            } else {
                System.out.println("FAILED: Text does not match -> " + message.getText());
            }

        } catch (Exception e) {
            System.err.println("Execution failed due to exception:");
            e.printStackTrace();
        } finally {
            // Close browser connection cleanly
            System.out.flush();
            driver.quit();
        }
    }
}