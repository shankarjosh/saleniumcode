package ccst;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class RevisionLogin{

    public static void main(String[] args){

        try(Playwright obj_playwright = Playwright.create()) {

            Browser obj_Browser = obj_playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext obj_context = obj_Browser.newContext();

            Page obj_Page = obj_context.newPage();

            obj_Page.navigate("file:///D:/selenium/html/Day5_login.html");
            System.out.println(obj_Page.title());
            Thread.sleep(2000);

            Locator obj_usrname = obj_Page.locator("#username");
            obj_usrname.fill("VansajSingh1998");
            Thread.sleep(2000);

            Locator obj_password = obj_Page .locator("#password");
            obj_password.fill("qwerty");
            Thread.sleep(2000);

            Locator obj_login = obj_Page.locator("//button[@data-testid='submit-btn']");
            obj_login.click();


        } catch (InterruptedException e) {

        }
    }
}