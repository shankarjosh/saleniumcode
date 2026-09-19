//package ccst;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.Page;
//
//public class Day1_4_Locators {
//    static String userName = "stard_user";
//    static String password = "secret_sauce";
//
//    //................Locators for the login page................
//    static String userNameLocator = "//*[@id='user-name']";
//    static String passwordLocator = "//*[@id='password']";
//
//    static String xpath_loginbutton = "//input[@data-test='login-button']";
//    static String css_loginbutton = "input[type=\"submit\"][value=\"Login\"]";
//    static String id_userName = "#user-name";
//    static String name_userName = "[name=\"usewr-name\"]";
//    static String placeholder_userName = "input[placeholder=\"Username\"]";
//    static String id_password = "#password";
//
//    public static void main(String[] args) {
//
//        try (playwriteday obj_playwrite = playwriteday.create()) {
//            Browser obj_browser = obj_playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            Page obj_page = obj_browser.newPage();
//            obj_page.navigate("https://www.saucedemo.com/");
//
//            try {
//                Thread.sleep(1000);
//
//
//                Locator obj_userName = obj_page.locator(id_userName);
//
//            }}
//
//        }
//    }
//}