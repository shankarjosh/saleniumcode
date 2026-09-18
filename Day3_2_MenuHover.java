package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day3_2_MenuHover {
    public static void main(String[] args) {
        // Correct WebDriver instantiation
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize window and set up implicit/explicit waits
            driver.manage().window().maximize();
            driver.get("file:///D:/selenium/html/Day3_ActionclassMenu.html"); // Note: Replace with target app containing hover menus

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            Actions actions = new Actions(driver);

            // 1. Products menu hover
            WebElement productsMenu = driver.findElement(By.id("products-menu"));
            actions.moveToElement(productsMenu).perform();

            // 2. Submenu visibility check
            WebElement obj_submenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productsSubmenu")));

            if (obj_submenu.isDisplayed()) {
                System.out.println("PASSED: Submenu is displayed on hover");
            } else {
                System.out.println("FAILED: Submenu is not displayed on hover");
            }

            // 3. Move to submenu and click target link
            actions.moveToElement(obj_submenu).perform();

            WebElement obj_Laptoplink = wait.until(ExpectedConditions.elementToBeClickable(By.id("laptopLink")));
            obj_Laptoplink.click();

            // 4. Verify result text
            String resultText = driver.findElement(By.id("resultText")).getText();
            if ("You clicked on Laptops link".equals(resultText)) {
                System.out.println("PASSED: Clicked on Laptops link and result matched");
            } else {
                System.out.println("FAILED: Result mismatch. Actual text: " + resultText);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser connection cleanly
            driver.quit();
        }
    }
}