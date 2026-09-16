package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_6_ImplicitwaitDemo {
    public static void main(String[] args) {
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Set implicit wait for 10 seconds (applies globally to element searches)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to webpage
            driver.get("https://www.saucedemo.com/");

            // Implicit wait automatically waits up to 10 seconds for this element to appear in DOM
            WebElement loginLogo = driver.findElement(By.className("login_logo"));
            System.out.println("Element found: " + loginLogo.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser session
            driver.quit();
        }
    }
}