package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day3_VerifyUnhandledPromptBehavior {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        // Configure browser capability to auto-accept all dialogs
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("file:///D:/selenium/html/Day3_javascriptAlert.html");

            // 1. Test Simple Alert -> Auto-accepted (Clicks OK)
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            Thread.sleep(1000);

            // 2. Test Confirm Dialog -> Auto-accepted (Clicks OK)
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
            Thread.sleep(1000);

            // 3. Test Prompt Box -> Auto-accepted (Submits default/empty input with OK)
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
            Thread.sleep(1000);

            // Print the page result message to verify submission status
            String resultText = driver.findElement(By.id("result")).getText();
            System.out.println("Result message on page: " + resultText);

        } finally {
            driver.quit();
        }
    }
}