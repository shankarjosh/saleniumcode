package ccst;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class RevisionLoginHtml {
    public static void main(String[] args) {

        Browser obj_browser = null;
        try (Playwright obj_playwright = Playwright.create()) {

            obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext obj_context = obj_browser.newContext();

            Page page = obj_browser.newPage();

            page.navigate("file:///D:/selenium/html/Day5_login.html");
            System.out.println(page.title());
            Thread.sleep(2000);


            Locator obj_username = page.locator("#username");
            obj_username.fill("Vansajsingh1998");
            Thread.sleep(2000);

            Locator obj_password = page.locator("#password");
            obj_password.fill("Qwerty");
            Thread.sleep(2000);

            Locator obj_signin = page.locator("//button[@data-testid='submit-btn']");
            obj_signin.click();
            Thread.sleep(2000);

            Page obj_newpage = obj_context.waitForPage(() -> {
                obj_signin.click();
            });
            Thread.sleep(2000);

//            Locator obj_DropDownOption = page.locator("option[value='1']");
//            obj_DropDownOption.click();
//            Thread.sleep(2000);


//            if(obj_DropDownLIst.inputValue().equals("1"))
//                System.out.println("Option Validate successfully");
//
//            else {
//                System.out.println("Option validate Unsuccessfull");
//            }

            if (page.title().equals("Student Performance Report"))
                System.out.println("Page Validate successful");

            else {
                System.out.println("Page validate unsuccessfull");
            }


        } catch (InterruptedException e) {

            obj_browser.close();


        }
    }
}
