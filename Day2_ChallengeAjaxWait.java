package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day2_ChallengeAjaxWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to challenge_ajaxpage.html
            driver.get("file:///D:/selenium/html/ajax.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Optional: Click button if your page requires triggering the AJAX request
            // wait.until(ExpectedConditions.elementToBeClickable(By.id("loadQuoteBtn"))).click();

            // -------------------------------------------------------------
            // WAIT 1: Wait for Spinner element to disappear
            // -------------------------------------------------------------
            boolean isSpinnerInvisible = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(By.id("spinner"))
            );
            System.out.println("Spinner disappeared: " + isSpinnerInvisible);

            // -------------------------------------------------------------
            // WAIT 2: Wait for 'Fetching quote...' text element to disappear
            // -------------------------------------------------------------
            boolean isLoadingTextInvisible = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(By.id("loadingText"))
            );
            System.out.println("AJAX 'Fetching quote...' status cleared: " + isLoadingTextInvisible);

            // -------------------------------------------------------------
            // Fetch and validate final loaded AJAX content
            // -------------------------------------------------------------
            WebElement quoteElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("quoteContent"))
            );

            System.out.println("SUCCESS - Fetched Quote: " + quoteElement.getText());

            // Pause execution to visually verify result before quitting
            Thread.sleep(5000);

        } catch (Exception e) {
            System.err.println("FAILED: AJAX elements did not transition within timeout.");
            e.printStackTrace();
        } finally {
            System.out.flush();
            driver.quit();
        }
    }
}