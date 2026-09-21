package ccst;

import com.microsoft.playwright.*;

public class DragAndDropTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();

            page.navigate("file:///D:/selenium/html/locatorfilter.html");

            Locator targetContainer = page.locator("#targetContainer");
            Locator sourceContainer = page.locator("#sourceContainer");

            String[] itemIds = {"#item1", "#item2", "#item3"};

            for (String id : itemIds) {
                Locator item = page.locator(id);
                item.dragTo(targetContainer);
                page.waitForTimeout(3000);
            }

            for (String id : itemIds) {
                Locator item = page.locator(id);
                item.dragTo(sourceContainer);
                page.waitForTimeout(3000);
            }

            String resultText = page.locator("#result").textContent();
            System.out.println("Result text: " + resultText);

            browser.close();
        }
    }
}