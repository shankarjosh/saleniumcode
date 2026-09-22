package ccst;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class DropDown {
    public static void main(String[] args){

        try(Playwright obj_playwright = Playwright.create()){

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext obj_context = obj_browser.newContext();

            Page page = obj_browser.newPage();

            page.navigate("https://the-internet.herokuapp.com/");
            System.out.println(page.title());
            Thread.sleep(2000);


            Locator obj_DropDown = page.locator("//a[@href='/dropdown']");
            obj_DropDown.click();
            Thread.sleep(2000);

            Locator obj_DropDownLIst = page.locator("#dropdown");
            obj_DropDownLIst.selectOption("2");
            obj_DropDownLIst.click();
            Thread.sleep(2000);

//            Locator obj_DropDownOption = page.locator("option[value='1']");
//            obj_DropDownOption.click();
//            Thread.sleep(2000);


            if(obj_DropDownLIst.inputValue().equals("1"))
                System.out.println("Option Validate successfully");

            else {
                System.out.println("Option validate Unsuccessfull");
            }


            System.out.println("Current URL " + page.url());
            String str_url = page.url();
            if(str_url.contains("dropdown"))
                System.out.println(" URL Validate successful");

            else{
                System.out.println("url validate Invalid");
            }


        } catch (InterruptedException e) {


        }
    }
}
