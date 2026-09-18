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

public class Day3_3_AssignmentKeybordShortCuts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // 1. Open the local HTML file
            driver.get("file:///D:/selenium/html/Day3_keybordShortcut.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            // 2. Locate the Target textarea/input box
            WebElement targetBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//textarea | //input[@placeholder='Paste text here...'] | //*[@placeholder='Paste text here...']")
            ));

            // 3. Focus on Target box, Select All (CTRL + A), and delete/clear
            Keys modifier = System.getProperty("os.name").toLowerCase().contains("mac") ? Keys.COMMAND : Keys.CONTROL;

            actions.click(targetBox)
                    .keyDown(modifier).sendKeys("a").keyUp(modifier) // Select All text
                    .sendKeys(Keys.BACK_SPACE)                      // Clear/Delete selected text
                    .perform();

            // Short pause for DOM update
            Thread.sleep(1000);

            // 4. Locate and validate the bottom message text after clearing
            WebElement bottomMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Text in Target')]")
            ));

            String actualMessage = bottomMessage.getText();
            String expectedMessage = "Text in Target does not match Source yet.";

            System.out.println("Bottom Message Text: " + actualMessage);

            if (actualMessage.trim().equals(expectedMessage.trim())) {
                System.out.println("PASSED: Target box cleared successfully and validation message matches!");
            } else {
                System.out.println("FAILED: Validation message mismatch.\nExpected: '" + expectedMessage + "'\nActual: '" + actualMessage + "'");
            }

            Thread.sleep(2000); // Brief wait to visually observe the result before closing

        } catch (InterruptedException e) {
            System.err.println("Thread sleep was interrupted.");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("An error occurred during execution:");
            e.printStackTrace();
        } finally {
            // Forcefully close all driver windows and end the driver process
            if (driver != null) {
                driver.quit();
                System.out.println("Browser window closed successfully.");
            }
        }
    }
}