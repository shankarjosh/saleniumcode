//package ccst;
//
//import com.microsoft.playwright.*;
//
//import java.util.List;
//
//public class LocatorChaining {
//    static final String Login_URL = "file:///D:/selenium/html/LocatorChaining.html";
//
//    public static void main(String[] args) {
//        try (Playwright obj_playwrite = Playwright.create()) {
//            Browser obj_browser  = obj_playwrite.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false)
//            );
//            BrowserContext obj_context = obj_browser.newContext();
//            Page obj_ControlsPage = obj_context.newPage();
//
//            obj_ControlsPage.navigate(Login_URL);
//            Locator modulesDropdown = obj_ControlsPage.locator("#module");
//            modulesDropdown.click();
//
//            List<String> optionTexts = modulesDropdown.locator("option").allInnerTexts();
//            System.out.println("Dropdown options: " + optionTexts);
//
//            modulesDropdown.selectOption("CCST");
//
//            Locator rows = obj_ControlsPage.locator("table").locator("tbody").locator("tr");
//
//                Locator rows = obj_ControlsPage.locator("table tbody tr");
//
//            int rowCount = rows.count();
//            System.out.println("Number of rows: " + rowCount);
//
//            Thread.sleep(2000);
//
//            for (int i= 0; i < rowCount; i++) {
//                Locator row = rows.nth(i);
//
//                Locator marksInput = row.locator("input[type='number']");
//                marksInput.fill("90");
//            }
//
//            Locator saveButton = obj_ControlsPage.locator("#saveButton");
//            System.out.println("save button is enabled: " + saveButton.isEnabled());
//            saveButton.click();
//
//            obj_ControlsPage.waitForTimeout(2000);
//            obj_context.close();
//            obj_browser.close();
//
//
//        }
//    }
//}
