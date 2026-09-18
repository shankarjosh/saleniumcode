package ccst1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_7_zoom {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://www.google.com");

            // Set zoom to 150%
            js.executeScript("document.body.style.zoom='150%'");
            System.out.println("Zoom applied successfully.");

            Thread.sleep(2000);

            // Reset zoom to 100%
            js.executeScript("document.body.style.zoom='100%'");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}