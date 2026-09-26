import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class herokuapp1 {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500)
            );
            BrowserContext obj_context = obj_browser.newContext();

            Page page = obj_context.newPage();

            page.navigate("https://the-internet.herokuapp.com/");
            Thread.sleep(2000);

            Locator Hslider = page.locator("//a[@href='/horizontal_slider']");
            Hslider.click();

            Locator slider = page.locator(".sliderContainer input");
            Locator rangeValue = page.locator("#range");

            slider.focus();

            for (int i = 0; i < 5; i++) {
                slider.press("ArrowRight");
            }

            // Assert or print the updated range value
            System.out.println("Slider Value: " + rangeValue.innerText());
            assertThat(rangeValue).hasText("2.5");

            page.close();
            obj_browser.close();
        }
    }
}