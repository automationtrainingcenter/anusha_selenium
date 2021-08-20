package waittypes;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utitlity.BrowserConfig;

import java.util.Locale;
import java.util.function.Function;

public class ExplicitwaitDemo extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.facebook.com");

        // explicit wait is WebDriverWait class
        // create an object of WebDriverWait class
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.titleContains("Facebook"));

//        wait.until(new Function<WebDriver, Object>() {
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                System.out.println("waiting for title to be .. Facebook");
//                return webDriver.getTitle().toLowerCase().contains("FACEBOOK".toLowerCase());
//            }
//        });

//        wait.until(d -> {
//            System.out.println("Waiting for title to be .. Facebook");
//            return d.getTitle().toLowerCase().contains("FACEBOOK".toLowerCase());
//        });

//        wait.until(d -> d.getTitle().toLowerCase().contains("FACEBOOK".toLowerCase()));

//        wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("Facebook"), ExpectedConditions.titleContains("facebook"), ExpectedConditions.titleContains("FACEBOOK")))

        By email = By.id("email");
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("anusha");

        sleep(2000);

        closeBrowser();
    }
}
