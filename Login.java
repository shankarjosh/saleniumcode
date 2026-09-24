package ccst.saucedemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Login {
    Playwright objPlaywright;
    Browser objBrowser;
    BrowserContext objContext;
    Page page;

    @BeforeMethod
    public void setUp() {
        objPlaywright = Playwright.create();
        objBrowser = objPlaywright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        objContext = objBrowser.newContext();
        page = objContext.newPage();

        page.navigate("https://www.saucedemo.com/");
        System.out.println("Page Title: " + page.title());
    }

    @Test
    public void testLoginSuccessful() {
        Locator objUser = page.locator("//input[@data-test='username']");
        objUser.fill("standard_user");

        Locator objPassword = page.locator("//input[@data-test='password']");
        objPassword.fill("secret_sauce");

        Locator objSubmit = page.locator("//input[@data-test='login-button']");
        objSubmit.click();

        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (objContext != null) {
            objContext.close();
        }
        if (objBrowser != null) {
            objBrowser.close();
        }
        if (objPlaywright != null) {
            objPlaywright.close();
        }
    }
}