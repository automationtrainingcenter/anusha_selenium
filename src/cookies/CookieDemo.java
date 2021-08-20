package cookies;

import actions.BrowserName;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utitlity.BrowserConfig;

import java.util.Set;

public class CookieDemo extends BrowserConfig {
    /*
     * to work with cookies we have use Options interface
     */
    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.amazon.in");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        for(Cookie cookie : cookies) {
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getExpiry());
            System.out.println(cookie.getName());
            System.out.println(cookie.getPath());
            System.out.println(cookie.getValue());
        }
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies().size());
        closeBrowser();

    }
}
