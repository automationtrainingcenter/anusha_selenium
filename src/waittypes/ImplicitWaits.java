package waittypes;

import actions.BrowserName;
import org.openqa.selenium.WebDriver;
import utitlity.BrowserConfig;

import java.util.concurrent.TimeUnit;
// don't use both implicit and explicit waits together in a project

/*
 * WebDriver interface contains manage() which returns Options interface
 * reference. In Options interface we have timeouts() which returns TimeOuts
 * interface reference. This TimeOut interface contains different wait type
 * methods
 *
 * all these methods are implicit wait methods
 */

public class ImplicitWaits extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.amazon.com");

        /*
         * implicitlyWait() -- An implicit wait tells the WebDriver to wait for a
         * certain amount of time when trying to locate element or elements if they are
         * not available immediately on the page the implicit wait set for life of the
         * WebDriver object
         */
//        WebDriver.Options manage = driver.manage();
//        WebDriver.Timeouts timeouts = manage.timeouts();
//        timeouts.implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /*
		 * pageLoadTimeout() -- A pageLoadTimeout tells the WebDriver to wait for a
		 * certain amount of time for a page load to complete before throwing an
		 * exception
		 */
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        /*
		 * setScriptTimeout() -- setScriptTimeout tells the WebDriver to wait for a
		 * certain amount of time for an asynchronous script to finish execution before
		 * throwing an exception
		 */
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        closeBrowser();

    }

}
