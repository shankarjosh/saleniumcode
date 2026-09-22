package ccst;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Wikipedia {
    public static void main (String[] args){

        try(Playwright obj_playwright = Playwright.create()) {

            Browser obj_Browser = obj_playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext obj_context = obj_Browser.newContext(new Browser.NewContextOptions().setLocale("ja-JP"));

            Page obj_Page = obj_context.newPage();

            obj_Page.navigate("https://www.wikipedia.org/");
            obj_Page.waitForTimeout(10000);

            System.out.println("Page title: " + obj_Page.title() );


            assertThat(obj_Page).hasURL("#jsLangLabel");

            obj_Browser.close();

        }
    }
}
