//package ccst;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//
//public class Day1_2_TestHeadedMode {
//    public static void main(String[] args) {
//
//        try (Playwright obj_playwrite = Playwright.create()) {
//
//            Browser obj_browser = obj_playwrite.chromium().launch(
//                    );
//
//            BrowserContext obj_context = obj_browser.newContext();
//
//            Page obj_page = obj_context.newPage();
//
//            obj_page.navigate("https://www.example.com");
//
//            System.out.println("Page title is: " + obj_page.title());
//
//        }
//
//        }
//    }
//}
