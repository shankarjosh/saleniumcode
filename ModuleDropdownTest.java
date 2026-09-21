package ccst;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;


public class ModuleDropdownTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Load the HTML page (replace with your actual local path or URL)
            page.navigate("file:///D:/selenium/html/controlspractice.html");

            // Locate the dropdown
            Locator moduleDropdown = page.locator("#module");

            // 1. Select by Value directly
            moduleDropdown.selectOption("CCST");
            page.waitForTimeout(1000); // Optional pause to view action

            // 2. Select by Value object
            moduleDropdown.selectOption(new SelectOption().setValue("DAI"));
            page.waitForTimeout(1000);

            // 3. Select by Label (Visible Text)
            moduleDropdown.selectOption(new SelectOption().setLabel("HPCSA"));
            page.waitForTimeout(1000);

            // 4. Select by Index (Index 2 corresponds to "DAI")
            moduleDropdown.selectOption(new SelectOption().setIndex(2));
            page.waitForTimeout(1000);

            browser.close();
        }
    }
}