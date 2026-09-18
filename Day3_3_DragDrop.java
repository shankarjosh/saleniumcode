package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day3_3_DragDrop {
    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("file:///D:/selenium/html/Day3_ActionclassMenu.html#");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions action = new Actions(driver);

            // Switch to the jQuery UI iframe that holds the draggable/droppable elements
            WebElement demoFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("demo-frame")));
            driver.switchTo().frame(demoFrame);

            // Locate source (draggable) and target (droppable) elements inside the iframe
            WebElement draggable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
            WebElement droppable = driver.findElement(By.id("droppable"));

            // Attempt 1: Built-in dragAndDrop method
            action.dragAndDrop(draggable, droppable).perform();

            String result1 = droppable.getText();
            System.out.println("Result after first drag and drop: " + result1);

            if (result1.equalsIgnoreCase("Dropped!")) {
                System.out.println("PASSED: First drag and drop successful");
            } else {
                System.out.println("FAILED: First drag and drop failed");
            }

            Thread.sleep(2000); // Wait before next action

            // Attempt 2: Manual click-and-hold, move-to-element, and release sequence
            action.clickAndHold(draggable)
                    .moveToElement(droppable)
                    .pause(Duration.ofMillis(300))
                    .release()
                    .build()
                    .perform();

            String result2 = droppable.getText();
            System.out.println("After manual click-hold-move-release: " + result2);

            if (result2.equalsIgnoreCase("Dropped!")) {
                System.out.println("PASSED: Second drag and drop successful");
            } else {
                System.out.println("FAILED: Second drag and drop failed");
            }

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up and close browser
            driver.quit();
        }
    }
}