package ccst1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day3_1_Alerthandling {
    public static void main(String[] args) {
        // Setup configuration for Chrome driver
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "accept");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Replace with your target URL that actually contains an alert button
            driver.get("file:///D:/selenium/html/Day3_javascriptAlert.html");
            Thread.sleep(2000);

            // Click the button that triggers the alert
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

            // Switch to alert and extract text
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());

            // Accept the alert explicitly (if not relying solely on ChromeOptions)
            alert.accept();

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close browser connection cleanly
            driver.quit();
        }
    }
}