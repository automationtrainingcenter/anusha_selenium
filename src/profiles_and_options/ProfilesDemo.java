package profiles_and_options;

import actions.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import utitlity.BrowserConfig;
import utitlity.DriverConfig;

/*
 * Profile is a File where Firefox saves your personal information such as bookmarks,
 * passwords, and user preferences.
 * Multiple Firefox profiles can exist, each containing a separate set of preferences.
 * When starting Firefox in Selenium WebDriver, it starts new "anonymous" profile.
 *
 * to open profiles in firefox browser type about:profiles
 * create the profiles with extensions and preferences you want
 * and launch firefox browser using this profile as bellow
 */
public class ProfilesDemo {

    public static void main(String[] args) {
        ProfilesIni init = new ProfilesIni();
        FirefoxProfile automation = init.getProfile("automation");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(automation);
        DriverConfig.setDriverPath(BrowserName.FIREFOX);
        WebDriver driver = new FirefoxDriver(options);
    }
}
