package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_9_HighlightHeading {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Fixed: Uppercase 'J' for JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;


        try {
            driver.get("https://www.saucedemo.com/");

            WebElement obj_heading = driver.findElement(By.xpath("//div[@class='login_logo']"));

            // Highlight element with border and background in a single JavaScript execution
            js.executeScript("arguments[0].style.border='5px solid red'; arguments[0].style.backgroundColor='orange';", obj_heading);

            // Fixed: Uppercase 'T' for Thread
            Thread.sleep(5000);

            // Fixed: Added catch block for InterruptedException
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}