package saucedemo;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class Logout {
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

            Locator obj_checkout = page.locator("//button[@data-test='checkout']");
            obj_checkout.click();
            Thread.sleep(2000);

            Locator obj_firstname = page.locator("//input[@data-test='firstName']");
            obj_firstname.fill("Vansaj");
            Thread.sleep(2000);

            Locator obj_lastname = page.locator("//input[@data-test='lastName']");
            obj_lastname.fill("Singh");
            Thread.sleep(2000);

            Locator obj_zip = page.locator("//input[@data-test='postalCode']");
            obj_zip.fill("112233");
            Thread.sleep(2000);

            Locator obj_continue = page.locator("//input[@data-test='continue']");
            obj_continue.click();
            Thread.sleep(2000);

            Locator obj_finish = page.locator("//button[@data-test='finish']");
            obj_finish.click();
            Thread.sleep(2000);

            Locator obj_back = page.locator("//button[@data-test='back-to-products']");
            obj_back.click();
            Thread.sleep(2000);

            Locator obj_manu = page.locator("//button[text()='Open Menu']");
            obj_manu.click();
            Thread.sleep(2000);

            Locator obj_logout = page.locator("//a[@data-test='logout-sidebar-link']");
            obj_logout.click();
            Thread.sleep(2000);


        }
    }
}