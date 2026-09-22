package ccst;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import  com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class herokuappAutomation {
    public static void main(String[] args){

        try(Playwright obj_playwright = Playwright.create()){

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext obj_context = obj_browser.newContext();

            Page page = obj_browser.newPage();

            page.navigate("https://the-internet.herokuapp.com/");
            System.out.println(page.title());
            Thread.sleep(2000);


//            Locator obj_dragDrop = page.locator("//a[@href='/drag_and_drop']");
//            obj_dragDrop.click();
//            Thread.sleep(2000);
//
//            if()
//
//            Locator obj_source = page.locator("#column-a");
//            Locator obj_target = page.locator("#column-b");
//            obj_target.dragTo(obj_source);
//            Thread.sleep(2000);
//
////            if(obj_source.textContent().contains("B"))
//                System.out.println("Validate successfully");
//
//            else {
//                System.out.println("Unsuccessfull");
//            }


//            Locator obj_addRemove = page.locator("//a[@href='/add_remove_elements/']");
//            obj_addRemove.click();
//            Thread.sleep(2000);
//
//            Locator obj_addElement = page.locator("//button[@onclick='addElement()']");
//            obj_addElement.click();
//            Thread.sleep(2000);
//
//            Locator obj_delete = page.locator("//button[@onclick='deleteElement()']");
//            obj_delete.click();
//            Thread.sleep(2000);
//
//            if(obj_delete.isVisible())
//                System.out.println("Delete Button is visible");
//
//            else {
//                System.out.println("Delete Button is not visible");
//            }
//
//
            page.url();
            System.out.println("Current URL " + page.url());
            String str_url = page.url();
            if(str_url.contains("drag_and_drop"))
                System.out.println("Validate successful");




            else{
                System.out.println("Invalid");
            }


        } catch (InterruptedException e) {


        }
    }
}
