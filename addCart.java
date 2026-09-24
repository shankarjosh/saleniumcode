package saucedemo;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class addCart {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            BrowserContext obj_context = obj_browser.newContext();

            Page page = obj_browser.newPage();

            page.navigate("https://www.saucedemo.com/");
            System.out.println(page.title());
            page.waitForTimeout(4000);

            Locator obj_user = page.locator("//input[@data-test='username']");
            obj_user.fill("standard_user");

            Locator obj_password = page.locator("//input[@data-test='password']");
            obj_password.fill("secret_sauce");
            Thread.sleep(2000);

            Locator obj_submit = page.locator("//input[@data-test='login-button']");
            obj_submit.click();
            Thread.sleep(2000);

            Locator obj_cart = page.locator("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']");
            obj_cart.click();
            Thread.sleep(2000);

            Locator obj_check = page.locator("//a[@data-test='shopping-cart-link']");
            obj_check.click();
            Thread.sleep(2000);


        }
    }
}