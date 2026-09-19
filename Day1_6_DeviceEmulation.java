package ccst;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;

import java.util.Arrays;
import java.util.Map;

public class Day1_6_DeviceEmulation
{
    static final String URL = "https://www.google.com/";
    public static void main(String[] args)
    {
        try (Playwright obj_playwrite = Playwright.create()) {
            Browser obj_browser = obj_playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext obj_context = obj_browser.newContext(new Browser.NewContextOptions()
                    .setUserAgent("Mozilla/5.0 (BB10; Touch) AppleWebKit/537.35+ (KHTML, like Gecko) Version/10.3.1.2744 Mobile Safari/537.35+")
                    .setViewportSize(360, 640)
                    .setDeviceScaleFactor(2.0)
                    .setIsMobile(true)
                    .setHasTouch(true)

                    .setGeolocation(new Geolocation(48.8566, 2.3522))
                    .setPermissions(Arrays.asList("geolocation")));

            Page obj_page = obj_context.newPage();
            obj_page.navigate(URL);

            obj_page.locator("[data-testid='username-input']").fill("validUser");
            obj_page.locator("[data-testid='password-input']").fill("validPassword");
            Thread.sleep(2000);
            Page obj_control = obj_context.waitForPage(() -> {
                obj_page.locator("[data-testid='submit-btn']").click();
            });
            Thread.sleep(2000);

            obj_control.waitForLoadState();


            //validate naviagation to the next page
            String url = obj_control.url();
            System.out.println("Current URL: " + url);
            if (!url.contains("controlpractice.html")) {
                throw new AssertionError("Navigation to controlpractice.html failed" + URL);
            }
            //VALIDATE PAGE TITLE
            String Title = obj_control.title();
            System.out.println("Page title is: " + Title);

            // FETCH GEOLOCATION VIA JAVASCRIPT EVALUATION
            @SuppressWarnings("unchecked")
            Map<String, Object> location = (Map<String, Object>) obj_control.evaluate(
                    "() => new Promise((resolve, reject) => {"
                            + "  navigator.geolocation.getCurrentPosition("
                            + "    p => resolve({lat: p.coords.latitude, longitude: p.coords.longitude}),"
                            + "    e => reject(e.message)"
                            + "  );"
                            + "})"
            );

            // FIXED: Safely convert Number types from JS to double
            double latitude = ((Number) location.get("lat")).doubleValue();
            double longitude = ((Number) location.get("longitude")).doubleValue();

            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}