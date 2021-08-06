package basics;
/*
 *
 * Navigation is an inner interface of WebDriver interface
 *
 * public interface WebDriver{
 * 		void close();
 * 		void quit();
 *
 * 		Navigation navigate();
 *
 *
 * 		interface Navigation{
 * 			void back();
 * 			void refresh();
 * 		}
 * }
 *
 * WebDriver driver = new ChromeDriver();
 * Navigation nav = driver.navigate();
 * nav.back();
 * nav.refresh(); or
 * driver.navigate().refresh();
 *
 * Navigation interface methods:
 *
 * 1. to(String url): is used to navigate to a given url as a String.
 *
 * 2. to(URL url): is used to navigate to a given url as a URL class object.
 *
 * 3. back(): is used to automate the back button of the browser
 *
 * 4. forward(): is used to automate the forward button of the browser
 *
 * 5. refresh(): is used to refresh the current browser window (automates the refresh button)
 *
 *
 */

import actions.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

import java.net.MalformedURLException;
import java.net.URL;


public class NavigationMethods {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.facebook.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        // create Navigation interface reference by calling navigate() of WebDriver interface
        WebDriver.Navigation nav = driver.navigate();

        // to(String url)
        nav.to("//www.google.com");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        // to(URL url)
        try {
            nav.to(new URL("http://www.gmail.com"));
            System.out.println(driver.getTitle());
            Thread.sleep(3000);
        } catch (MalformedURLException e) {
            System.out.println("Please check the url");
        }

        // refresh()
        nav.refresh();
        System.out.println("clicked Refresh");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        // back()
        nav.back();
        System.out.println("clicked Back");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        // forward()
        nav.forward();
        System.out.println("clicked Forward");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.close();


    }
}
