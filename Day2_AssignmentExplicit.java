package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day2_AssignmentExplicit {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to welcome.html
            driver.get("file:///D:/selenium/html/welcome.html");

            // Explicit wait set higher than the 5-second spinner delay
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Wait for 'Enter Name' button to become clickable after spinner disappears
            WebElement enterNameBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("enterNameBtn"))
            );

            // Click the button to enable the input field
            enterNameBtn.click();
            System.out.println("PASSED: 'Enter Name' button became clickable and was clicked.");

            // Enter text into the newly enabled text field
            WebElement nameField = driver.findElement(By.id("nameField"));
            nameField.sendKeys("John Doe");

        } catch (Exception e) {
            System.err.println("FAILED: Button did not become clickable within the timeout.");
            e.printStackTrace();
        } finally {
            System.out.flush();
            driver.quit();
        }
    }
}