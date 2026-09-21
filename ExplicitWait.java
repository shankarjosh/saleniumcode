package ccst;

import com.microsoft.playwright.*;

public class ExplicitWait {
    static final String PAGE_URL = "file:///D:/selenium/html/controlspractice.html";
    public static void main(String[] args) {

        try (Playwright obj_playweight = Playwright.create()) {
            Browser obj_browser = obj_playweight.chromium().launch(new BrowserType.LaunchOptions());
            BrowserContext obj_context = obj_browser.newContext();
            Page obj_ControlsPage = obj_context.newPage();



            obj_ControlsPage.navigate(PAGE_URL);

            Locator dataRows = obj_page.locator("table tbody tr);
            Locator options = moduleDropdown.locator("option");
            Locator targetOption = options.filter(new Locator.FilterOptions().setHasText("CCST"));

            String value = targetOption.getAttribute("value");
            System.out.println("Extracted attribute value: " + value);


        }

    }
}