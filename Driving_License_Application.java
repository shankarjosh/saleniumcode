package ccst;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driving_License_Application {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();
        obj_driver.manage().window().maximize();

        try {
            obj_driver.get("D:\\selenium\\html\\form.html");

            // Locate Form Elements
            WebElement usernameField = obj_driver.findElement(By.id("fullname"));
            WebElement addressField = obj_driver.findElement(By.id("address"));
            WebElement ageField = obj_driver.findElement(By.id("age"));
            WebElement placeOfBirthField = obj_driver.findElement(By.id("placeofbirth"));
            WebElement genderMaleRadio = obj_driver.findElement(By.id("Male"));
            WebElement colorblindYesCheckbox = obj_driver.findElement(By.xpath("//input[@name='color_yes']"));

            // FIX 1: Correct ID spelling ('licenseType' with 's')
            WebElement licenseTypeElement = obj_driver.findElement(By.id("licenseType"));

            WebElement languageDropdown = obj_driver.findElement(By.id("languages"));

            // Fill Text Inputs
            usernameField.sendKeys("shankar");
            addressField.sendKeys("Hinjewadi phase 1");
            ageField.sendKeys("25");
            placeOfBirthField.sendKeys("Rishikesh");

            // Select Single License Type Option
            Select licenseTypeSelect = new Select(licenseTypeElement);
            licenseTypeSelect.selectByValue("permanent"); // Choose one option (e.g., "permanent" or "learning")

            // Handle Checkbox & Radio Buttons
            if (!colorblindYesCheckbox.isSelected()) {
                colorblindYesCheckbox.click();
            }

            if (!genderMaleRadio.isSelected()) {
                genderMaleRadio.click();
            }

            // Select Language Option
            Select selectLanguage = new Select(languageDropdown);
            selectLanguage.selectByValue("english");

            // Pause to observe inputs on screen
            Thread.sleep(3000);

            // Submit Form
            WebElement submitButton = obj_driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();

            // Wait for Redirection
            WebDriverWait wait = new WebDriverWait(obj_driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlContains("welcome.html"));

            // Check Success
            if (obj_driver.getCurrentUrl().contains("welcome.html")) {
                System.out.println("Application submitted successfully!");
            } else {
                System.out.println("Application submission failed.");
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obj_driver.quit();
        }
    }
}