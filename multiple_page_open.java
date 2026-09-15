package ccst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multiple_page_open {
    public static void main(String[] args) {


            WebDriver obj_driver = new ChromeDriver();

            try {
                obj_driver.get("https://www.saucedemo.com/");

                Thread.sleep(10000);
                System.out.println("Current URL: " + obj_driver.getCurrentUrl());

                obj_driver.get("https://www.google.com/");

                Thread.sleep(10000);
                System.out.println("Current URL: " + obj_driver.getCurrentUrl());

                obj_driver.get("https://www.w3schools.com/");

                Thread.sleep(10000);
                System.out.println("Current URL: " + obj_driver.getCurrentUrl());


            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                obj_driver.quit();
            }
    }

}
