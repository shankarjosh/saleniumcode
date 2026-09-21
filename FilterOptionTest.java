package ccst;


import com.microsoft.playwright.*;

public class FilterOptionTest {
    static final String PAGE_URL = "file:///D:/selenium/html/controlspractice.html";

    public static void main(String[] args) {
        try (Playwright obj_playwrite = Playwright.create()) {
            Browser obj_browser = obj_playwrite.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            BrowserContext obj_context = obj_browser.newContext();
            Page obj_ControlsPage = obj_context.newPage();

            obj_ControlsPage.navigate(PAGE_URL);

            Locator moduleDropdown = obj_ControlsPage.locator("#module");

            Locator options = moduleDropdown.locator("option");

            Locator targetOption = options.filter(new Locator.FilterOptions().setHasText("CCST"));

            String value = targetOption.getAttribute("value");
            System.out.println("Extracted attribute value: " + value);

            moduleDropdown.selectOption(value);

            Locator rows = obj_ControlsPage.locator("#studentTableBody tr");
            System.out.println("Populated student rows count: " + rows.count());

            obj_ControlsPage.waitForTimeout(5000);
            obj_context.close();
            obj_browser.close();
        }
    }
}
