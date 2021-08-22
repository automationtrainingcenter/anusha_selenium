package logs_and_reports;

import actions.BrowserName;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utitlity.DriverConfig;

import java.io.File;

public class LogsDemo2 extends Reporter{

    static WebDriver wdriver;
    static WebDriverWait wait;
    static EventFiringWebDriver driver;


    // launch browser
    public static void openBrowser(){
        test = reports.createTest("open browser");
        DriverConfig.setDriverPath(BrowserName.CHROME);
        wdriver = new ChromeDriver();
        wait = new WebDriverWait(wdriver, 10);
        wdriver.manage().window().maximize();

        // create an object of Listener class which implemented WebDriverEventListener interface
        MyListener listener = new MyListener();
        // create an object of EventFiringWebDriver class
        driver = new EventFiringWebDriver(wdriver);
        // register listener object to EventFiringWebDriver object
        driver.register(listener);

        driver.get("http://primusbank.qedgetech.com/");
    }

    // login
    public static void loginTest(){
        test = reports.createTest("login test");
        driver.findElement(By.id("txtuId")).sendKeys("Admin");
        driver.findElement(By.id("txtPword")).sendKeys("Admin");
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.urlContains("adminflow"));
        if(driver.getCurrentUrl().contains("adminflow")){
            System.out.println("Login test Passed");
            test.pass("Login test passed");
        }else {
            System.out.println("Login test Failed");
            test.fail("Login test Failed");
        }
    }

    // branch creation
    public static void branchCreationTest(){
        test = reports.createTest("branch creation test");
        driver.findElement(By.cssSelector("a[href *= 'master']")).click();
        driver.findElement(By.id("BtnNewBR")).click();
        driver.findElement(By.id("txtbName")).sendKeys("LondonBranch");
        driver.findElement(By.id("txtAdd1")).sendKeys("address1");
        driver.findElement(By.id("txtZip")).sendKeys("98123");
        Select country = new Select(driver.findElement(By.id("lst_counrtyU")));
        country.selectByVisibleText("UK");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#lst_stateI>option"), 1));
        Select state = new Select(driver.findElement(By.id("lst_stateI")));
        state.selectByVisibleText("England");
        // anonymous object
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#lst_cityI>option"), 1));
        new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("LONDON");
        driver.findElement(By.id("btn_insert")).click();
        // switch the driver focus to the alert
        Alert alert = driver.switchTo().alert();
        // get alert text and print on the console
        if(alert.getText().startsWith("New Branch")){
            System.out.println("Branch creation test passed");
            test.pass("Branch creation test passed");
        } else {
            System.out.println("Branch creation test failed");
            test.fail("Branch creation test failed");
        }
        // accept the alert
        alert.accept();
    }

    // logout
    public static void logoutTest(){
        test = reports.createTest("logout test");
        driver.findElement(By.cssSelector("a[href *= 'primusbank']")).click();
        if(driver.findElement(By.id("login")).isDisplayed()){
            System.out.println("Logout test passed");
            test.pass("Logout test is passed");
        } else {
            System.out.println("Logout test failed");
            test.fail("Logout test failed");
        }
    }

    // close browser
    public static void teardown(){
        test = reports.createTest("teardown test");
        driver.close();
    }

    public static void main(String[] args) {
        reports.attachReporter(reporter);
        openBrowser();
        loginTest();
        branchCreationTest();
        logoutTest();
        teardown();
        reports.flush();
    }
}
