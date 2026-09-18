package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day3_5_KeybordShortCuts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("file:///D:/selenium/html/Day3_keybordShortcut.html"); // Replace with your local HTML path or URL

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Actions actions = new Actions(driver);

            // 1. Locate Source element (div/container holding the text) and Target input/textarea
            WebElement sourceContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'source')] | //fieldset[legend[text()='Source']] | //div[1]")));
            WebElement targetInput = driver.findElement(By.xpath("//textarea | //input | //*[@placeholder='Paste text here...']"));

            // Option A: Extract text directly and send to Target (Most Reliable)
            String sourceText = sourceContainer.getText();
            System.out.println("Extracted Source Text:\n" + sourceText);

            targetInput.clear();
            targetInput.sendKeys(sourceText);

            // -------------------------------------------------------------

            // Option B: Native Keyboard Select All (CTRL+A) -> Copy (CTRL+C) -> Paste (CTRL+V)
            // OS key handler (Control for Windows, Command for Mac)
            Keys modifier = System.getProperty("os.name").toLowerCase().contains("mac") ? Keys.COMMAND : Keys.CONTROL;

            // Highlight source text manually via triple-click or Actions click
            actions.click(sourceContainer)
                    .keyDown(modifier).sendKeys("a").keyUp(modifier) // Select All
                    .keyDown(modifier).sendKeys("c").keyUp(modifier) // Copy
                    .perform();

            // Focus target box and paste
            actions.click(targetInput)
                    .keyDown(modifier).sendKeys("v").keyUp(modifier) // Paste
                    .perform();

            // Verify pasted text
            String pastedValue = targetInput.getAttribute("value");
            if (pastedValue.length() > 0) {
                System.out.println("PASSED: Text copied from Source and pasted into Target successfully!");
            } else {
                System.out.println("FAILED: Target text box is empty.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}