package ccst;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Visible {
    public static void main(String[] args){

        try (Playwright obj_playweight =Playwright.create()){
            Browser obj_browser = obj_playweight.chromium().launch(new BrowserType.LaunchOptions());
            BrowserContext obj_context=obj_browser.newContext();
            Page obj_page =obj_context.newPage();

            Locator message =obj_page.locator("#message");
            obj_page.navigate(strPage);

            long start = System.currentTimeMillis();

            message.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

            String labelText = message.innerText();
            long elapsed = System.currentTimeMillis();

            System.out.println("Label text: " + labelText);
            System.out.println("Time waited:" + elapsed + " ms ");
        }
    }
}

