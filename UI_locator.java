package ccst;

import com.microsoft.playwright.*;

public class UI_locator {

    static final String URL = "file:///D:/selenium/html/Day5_login.html";

    public static void main(String[] args) {
        try (Playwright obj_playwrite = Playwright.create()) {
            Browser obj_browser = obj_playwrite.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500)
            );

            BrowserContext obj_context = obj_browser.newContext();
            Page obj_page = obj_context.newPage();

            // 1. NAVIGATE TO THE DRIVING LICENCE PAGE
            obj_page.navigate(URL);

            // 2. INTERACT WITH TEXT FIELDS USING LOCATORS
            obj_page.locator("#fullname").fill("John Doe");
            obj_page.locator("#address").fill("123 Main Street, Paris");
            obj_page.locator("#age").fill("25");
            obj_page.locator("#placeofbirth").fill("Paris");

            // 3. INTERACT WITH CHECKBOXES USING LOCATORS
            Locator obj_colorNo = obj_page.locator("input[name='color_no']");
            obj_colorNo.check();
            System.out.println("Is Color Blindness 'No' checked: " + obj_colorNo.isChecked());

            // 4. SUBMIT FORM AND CAPTURE NEW PAGE
            Locator obj_submit = obj_page.locator("button[type='submit']");

            Page obj_newpage = obj_context.waitForPage(() -> {
                obj_submit.click();
            });

            // 5. VALIDATE NEW PAGE URL
            obj_newpage.waitForLoadState();
            String newPageUrl = obj_newpage.url();
            System.out.println("New Page URL: " + newPageUrl);

            if (newPageUrl.contains("welcome.html")) {
                System.out.println("PASS: Successfully navigated to welcome.html");
            } else {
                throw new AssertionError("FAIL: Expected URL to contain welcome.html, but was: " + newPageUrl);
            }

            // CLEANUP
            obj_page.close();
            obj_newpage.close();
            obj_context.close();
            obj_browser.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}