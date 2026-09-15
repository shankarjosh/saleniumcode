package ccst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_1_Login_SauceDemo {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();

        try {
            obj_driver.get("https://www.saucedemo.com/");

            Thread.sleep(10000);

            WebElement usernameField = obj_driver.findElement(By.id("user-name"));
            WebElement passwordField = obj_driver.findElement(By.id("password"));
            WebElement loginButton = obj_driver.findElement(By.id("login-button"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");

            Thread.sleep(10000);
            if (obj_driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
            loginButton.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            obj_driver.quit();
    }
}}
