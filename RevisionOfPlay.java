package ccst;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class RevisionOfPlay {

    public static void main(String[] args){
        //STEP 1: Create Playwright object
        try(Playwright obj_playwright = Playwright.create()){
            //STEP 2: Launch the browser
            Browser obj_Browser = obj_playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            //STEP 3: create a browser context object
            BrowserContext obj_context = obj_Browser.newContext();

            //STEP 4: create a page object
            Page obj_Page = obj_context.newPage();

            obj_Page.navigate("https://www.saucedemo.com/");
            System.out.println(obj_Page.title());
            Thread.sleep(3000);

            Locator obj_username = obj_Page.locator("#user-name");
            obj_username.fill("standard_user");
            Thread.sleep(3000);

            Locator obj_password = obj_Page.locator("#password");
            obj_password.fill("secret_sauce");
            Thread.sleep(3000);

            Locator obj_login = obj_Page.locator("#login-button");
            obj_login.click();

            obj_Page.url();
            System.out.println("Current URL" + obj_Page.url());

            String str_url = obj_Page.url();

          if(str_url.contains("inventory.html"))
              System.out.println("login successful");

          else{
              System.out.println("login unsuccessful");
          }


            Thread.sleep(3000);
        } catch (InterruptedException e) {


        }

    }

}
