package ccst;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class upload {
    public static void main(String[] args) {


        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext obj_context = obj_browser.newContext();

            Page page = obj_browser.newPage();

            page.navigate("file:///D:/selenium/html/Day3_fileupload.html");
            System.out.println(page.title());
            Thread.sleep(2000);

            Locator obj_input = page.locator("#fileInput");
            String file = "C:/Users/ccst/Downloads/lion.jpg";
            page.setInputFiles("#fileInput", Paths.get(file));
            Thread.sleep(2000);

            Locator obj_upload = page.locator("#uploadBtn");
            obj_upload.click();
            Thread.sleep(2000);

            Locator obj_result = page.locator("#result");

            assertThat(obj_result).hasText("File 'lion.jpg' uploaded successfully!");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}