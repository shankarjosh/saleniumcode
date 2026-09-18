package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day3_2_AssignmentContextMenu {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///D:/selenium/html/Day3_ActionclassMenu.html#");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            WebElement contextMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("targetbox")));

            // Right click to open the context menu
            actions.contextClick(contextMenu).perform();

            WebElement contextMenuList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".context-menu")));

            if(contextMenuList.isDisplayed()){
                System.out.println("PASSED: Context menu is displayed on right click");
            } else {
                System.out.println("FAILED: Context menu is not displayed on right click");
            }

            // --- ASSIGNMENT: VERIFY MENU CLEARS WHEN CLICKED ELSEWHERE ---

            // 1. Locate the body/blank area outside the context menu
            WebElement bodyArea = driver.findElement(By.tagName("body"));

            // 2. Click outside the menu to dismiss it
            actions.click(bodyArea).perform();

            // 3. Verify that the context menu is no longer visible
            boolean isMenuCleared = wait.until(ExpectedConditions.invisibilityOf(contextMenuList));

            if (isMenuCleared) {
                System.out.println("PASSED: Context menu cleared successfully when clicked elsewhere.");
            } else {
                System.out.println("FAILED: Context menu is still visible after clicking elsewhere.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser connection cleanly
            driver.quit();
        }
    }
}