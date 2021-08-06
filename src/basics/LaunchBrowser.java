package basics;

import actions.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utitlity.DriverConfig;

/*
WebDriver is the main interface contains all the methods to automate any browser. For every browser we have
Driver classes like ChromeDriver, FirefoxDriver ..etc which will implement WebDriver interface methods.
 */
public class LaunchBrowser {

    public static void main(String[] args) throws Exception{
        // set the Chrome driver executable system property
        DriverConfig.setDriverPath(BrowserName.CHROME);

        // to launch the chrome browser just create an object of ChromeDriver class
//        ChromeDriver cdriver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);

        // close the browser
        driver.close();


        // set the gecko driver executable system property
        DriverConfig.setDriverPath(BrowserName.FIREFOX);

        // to launch the firefox browser just create an object of the FirefoxDriver class
//        FirefoxDriver fdriver = new FirefoxDriver();
        driver = new FirefoxDriver();
        Thread.sleep(3000);

        // close the browser
        driver.close();



    }

}
