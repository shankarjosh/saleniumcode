package ccst;

import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Action {

    public static void main(String[] args) {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));
            BrowserContext obj_context = obj_browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));


            Page page = obj_browser.newPage();
            page.navigate("file:///D:/selenium/html/Day3_keybordShortcut.html");
            System.out.println(page.title());

            Locator obj_copy = page.locator("sourceText");
            l
            page.keyboard().press("Control+A");

            Locator obj_paste = page.locator("targetText");
            page.keyboard().press("Control+V");



        }
    }
}