package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day3_4_RightClickContextMenu {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///D:/selenium/html/Day3_RightClick.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement contextMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("targetbox")));

        //right click open the context menu
        actions.contextClick(contextMenu).perform();

        WebElement contextMenuList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".context-menu")));

        if(contextMenuList.isDisplayed()){
            System.out.println("PASSED: Context menu is displayed on right click");
        }else{
            System.out.println("FAILED: Context menu is not displayed on right click");
        }
        //click delete from the menu
        WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("deleteOption")));
        deleteOption.click();

        String result = driver.findElement(By.id("result")).getText();
        if(result.equals("clicked: delete")){
            System.out.println("PASSED: Delete option clicked successfully" + result);
        }else{
            System.out.println("FAILED: Delete option click failed" + result);
        }
    }
}