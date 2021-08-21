package profiles_and_options;

import actions.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utitlity.DriverConfig;

import java.io.File;

/*
 * chrome extensions are available in below folder in windows os
 * C:\Users\%USERNAME%\AppData\Local\Google\Chrome\User Data\Default\Extensions
 *
 * Choose the extension and get the complete path with the version.
 * Copy the path and paste it into Chrome Pack Extension window to get the .crx extension file
 * Create a File class object with .crx file path
 * Use this File class objects in ChromeOptions class addExtensions method
 */
public class OptionsDemo {
    public static void main(String[] args) {
        File selectorHubExt = new File("/Users/suryaprakash/Library/Application Support/Google/Chrome/Default/Extensions/ndgimibanhlabgdgjcpbbndiehljcpfh/3.2.6_0.crx");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(selectorHubExt);
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver(options);
//        Thread.sleep(40);
    }
}
