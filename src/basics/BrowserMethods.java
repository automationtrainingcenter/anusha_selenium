package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utitlity.DriverConfig;

import java.util.List;
import java.util.Set;

public class BrowserMethods {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.FIREFOX);
        WebDriver driver = new FirefoxDriver();

        // get(String url) is used to navigate to the given url
        driver.get("http://www.facebook.com");

        // getCurrentUrl() returns url of the current web page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL of the page is "+currentUrl);

        // getTitle() return title of the current web page
        // title means the inner text of title tag inside head tag
        // inner text means test in between opening and closing tags
        String title = driver.getTitle();
        System.out.println("title of the page is "+title);

        // getPageSource() return the entire source code of the current web page
        String pageSource = driver.getPageSource();
        System.out.println(pageSource.contains("Facebook helps you connect and share with the people in your life."));

        // getWindowHandle() returns the id of the current browser window or tab
        // driver executables provides unique ids to every browser window or tab opened in that session
        String windowHandle = driver.getWindowHandle();
        System.out.println("window handle is "+windowHandle);


        // getWindowHandles() returns the ids of the all the browser windows or tabs opened by driver instance
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("window handles are "+windowHandles);

        /* findElement(By arg): is used to locate an element with in the current web page using
         * given locator information. This method returns a WebElement interface reference if element
         * located with given locator information else it returns NoSuchElementException.
         */
        // create an object of By class
//        By arg = By.id("email");
//        WebElement emailTextBox = driver.findElement(arg);
        WebElement emailTextBox = driver.findElement(By.id("email"));

        /* findElements(By arg): is used to locate one or more elements within the current web page
         * using given locator information. This method returns a List<WebElement> reference. With given
         * locator information if no element is located then this method will return a List of size 0.
         * It does not throw any exception.
         */
//        By arg = By.tagName("a123");
//        List<WebElement> inputTags = driver.findElements(arg);
        List<WebElement> inputTags = driver.findElements(By.tagName("a"));
        System.out.println(inputTags.size());


        Thread.sleep(3000);

        // close() is used to close the current browser window or tab
//        driver.close();

        // quit() is used to close the all the browser windows or tabs opened by driver instance
        driver.quit();
    }
}
