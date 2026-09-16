package ccst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class connect {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        try {
            driver.get("D:\\selenium\\html\\form.html");

            Thread.sleep(1000);

            //Store the original parent window handle
            String parentWindow = driver.getWindowHandle();

            WebElement obj_fullname = driver.findElement(By.cssSelector("input[name='fullname']"));
            WebElement obj_add = driver.findElement(By.cssSelector("input[name='address']"));
            WebElement obj_age = driver.findElement(By.cssSelector("input[name='age']"));
            WebElement obj_place = driver.findElement(By.cssSelector("input[name='placeofbirth']"));
            WebElement obj_genderM = driver.findElement(By.id("Male"));
            WebElement obj_genderF = driver.findElement(By.id("Female"));
            WebElement obj_colorN = driver.findElement(By.name("color_no"));
            WebElement obj_licenseType = driver.findElement(By.id("licenseType"));
            WebElement obj_language = driver.findElement(By.id("languages"));
            WebElement fileInput = driver.findElement(By.id("identity"));
            WebElement obj_submit = driver.findElement(By.xpath("//button[text()='Submit']"));


            Select licenseTypeSelect = new Select(obj_licenseType);
            Select languageSelect = new Select(obj_language);

            //Handling Drop Downs
            //Option 1 : Select by Visible Text
            licenseTypeSelect.selectByVisibleText("Permanent");

            //Option 2 : Select by Value Attributes
            //licenseTypeSelect.selectByValue("permanent");

            //Option 3 : Select by Index (0=placeholder , 1 = Permanent, 2 = Learning)
            //licenseTypeSelect.selectByIndex(1);


            Thread.sleep(1000);

            obj_fullname.sendKeys("Vansaj");
            obj_add.sendKeys("hinjewadi phase 1");
            obj_age.sendKeys("28");
            obj_place.sendKeys("agra");

            Thread.sleep(1000);
            obj_genderM.click();
            Thread.sleep(1000);
            obj_genderM.click();
            Thread.sleep(1000);
            obj_colorN.click();
            Thread.sleep(1000);



            Thread.sleep(1000);

            //Handling Drop Downs
            //Option 1 : Select by Visible Text
            //languageSelect.selectByVisibleText("Hindi");

            //Option 2 : Select by Value Attributes
            // languageSelect.selectByValue("hindi");

            //Option 3 : Select by Index (0=placeholder , 1 = Permanent, 2 = Learning)
            languageSelect.selectByIndex(1);
            Thread.sleep(3000);


            String filePath = "D:\\selenium\\html\\12.jpg";
            fileInput.sendKeys(filePath);
            Thread.sleep(4000);;

            obj_submit.click();
            Thread.sleep(9000);;

            Set<String> allWindows = driver.getWindowHandles();

            for(String windowHandle : allWindows){
                System.out.println("Window handle desc" + windowHandle);

                if(!windowHandle.equals(parentWindow)){
                    driver.switchTo().window(windowHandle);
                    String newWindow = driver.getWindowHandle();
                    System.out.println("Window handle desc" + windowHandle);
                    break;
                }
            }

            String actualUrl = driver.getCurrentUrl();

            if(actualUrl.contains("D:\\selenium\\html\\welcome.html")){
                System.out.println("Pass: Url Verified. Actual URL: " + actualUrl);
            }else{
                System.out.println("Fail: Url Verified. Actual URL: " + actualUrl);
            }

            String actualTitle = driver.getTitle();
            if(actualTitle.contains("Driving License Application")){
                System.out.println("Pass: Title Verified. Actual Title: " + actualTitle);
            }else{
                System.out.println("Fail: Title Verified. Actual Title: " + actualTitle);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally{
            driver.quit();
        }
    }
}
