package ccst1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Day3_6_fileupload {
    public static void main(String[] args) {

        // --- STEP 0: FILE EXISTENCE DIAGNOSTIC CHECK ---
        File uploadFile = new File("D:/selenium/files/ddd.jpg");
        if (!uploadFile.exists()) {
            System.err.println("ERROR: File not found at " + uploadFile.getAbsolutePath());
            System.err.println("Please check the file name and path on your computer!");
            return; // Stops execution before launching browser
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // 1. Navigate to your local HTML file
            driver.get("file:///D:/selenium/html/Day3_fileUpload.html");
            Thread.sleep(1000); // Small delay to visually verify page load

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 2. Locate the file input element (<input type="file">)
            WebElement fileInput = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']"))
            );

            // 3. Send file path directly to input element
            fileInput.sendKeys(uploadFile.getAbsolutePath());
            System.out.println("File path sent: " + uploadFile.getAbsolutePath());
            Thread.sleep(1000);

            // 4. Click the 'Upload' button
            WebElement uploadButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Upload')] | //button | //input[@type='submit']"))
            );
            uploadButton.click();
            System.out.println("Upload button clicked.");

            // 5. Validate the success message
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'uploaded successfully')]"))
            );

            String actualMessage = successMessage.getText();
            System.out.println("Result Message from page: " + actualMessage);

            if (actualMessage.contains("uploaded successfully")) {
                System.out.println("PASSED: File uploaded successfully.");
            } else {
                System.out.println("FAILED: File upload failed.");
            }

            // Pause for 5 seconds so you can inspect the final screen before closing
            Thread.sleep(5000);

        } catch (Exception e) {
            System.err.println("An exception occurred during test execution:");
            e.printStackTrace();
        } finally {
            // Close the browser connection cleanly
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed cleanly.");
            }
        }
    }
}