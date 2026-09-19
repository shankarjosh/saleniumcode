package ccst;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;

import java.util.Arrays;
import java.util.Map;

public class twoseparatewindow
{
    static final String URL1 = "https://www.google.com/";
    static final String URL2 = "https://yahoo.com/";

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
                    // Set geolocation to Paris, France (Latitude: 48.8566, Longitude: 2.3522)
                    .setGeolocation(new Geolocation(48.8566, 2.3522))
                    .setPermissions(Arrays.asList("geolocation")));

            // ==================== PAGE OBJECT 1 ====================
            Page obj_page1 = obj_context.newPage();
            obj_page1.navigate(URL1);

            // Extract title and print for Page 1
            String title1 = obj_page1.title();
            System.out.println("Page 1 URL: " + obj_page1.url());
            System.out.println("Page 1 Title: " + title1);

            // Get Geolocation on Page 1
            @SuppressWarnings("unchecked")
            Map<String, Object> location1 = (Map<String, Object>) obj_page1.evaluate(
                    "() => new Promise((resolve, reject) => {"
                            + "  navigator.geolocation.getCurrentPosition("
                            + "    p => resolve({lat: p.coords.latitude, longitude: p.coords.longitude}),"
                            + "    e => reject(e.message)"
                            + "  );"
                            + "})"
            );
            double lat1 = ((Number) location1.get("lat")).doubleValue();
            double long1 = ((Number) location1.get("longitude")).doubleValue();
            System.out.println("Page 1 Geolocation - Lat: " + lat1 + ", Long: " + long1);

            System.out.println("----------------------------------------");

            // ==================== PAGE OBJECT 2 ====================
            Page obj_page2 = obj_context.newPage();
            obj_page2.navigate(URL2);

            // Extract title and print for Page 2
            String title2 = obj_page2.title();
            System.out.println("Page 2 URL: " + obj_page2.url());
            System.out.println("Page 2 Title: " + title2);

            // Get Geolocation on Page 2
            @SuppressWarnings("unchecked")
            Map<String, Object> location2 = (Map<String, Object>) obj_page2.evaluate(
                    "() => new Promise((resolve, reject) => {"
                            + "  navigator.geolocation.getCurrentPosition("
                            + "    p => resolve({lat: p.coords.latitude, longitude: p.coords.longitude}),"
                            + "    e => reject(e.message)"
                            + "  );"
                            + "})"
            );
            double lat2 = ((Number) location2.get("lat")).doubleValue();
            double long2 = ((Number) location2.get("longitude")).doubleValue();
            System.out.println("Page 2 Geolocation - Lat: " + lat2 + ", Long: " + long2);

            // Close individual page objects
            obj_page1.close();
            obj_page2.close();

            // Close context and browser project instances
            obj_context.close();
            obj_browser.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}