package logs_and_reports;

import actions.BrowserName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utitlity.DriverConfig;

import java.util.concurrent.TimeUnit;

// generating log manually for event
public class LogsDemo1 {
    private static WebDriver driver;
    private static WebDriverWait wait;

    // launch browser
    public static void openBrowser(){
        DriverConfig.setDriverPath(BrowserName.CHROME);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://primusbank.qedgetech.com/");
    }

    // login
    public static void loginTest(){
        driver.findElement(By.id("txtuId")).sendKeys("Admin");
        System.out.println("entered text Admin in element Username");
        driver.findElement(By.id("txtPword")).sendKeys("Admin");
        System.out.println("entered text Admin in element Password");
        driver.findElement(By.id("login")).click();
        System.out.println("clicked on Login button");
        wait.until(ExpectedConditions.urlContains("adminflow"));
        if(driver.getCurrentUrl().contains("adminflow")){
            System.out.println("Login test Passed");
        }else {
            System.out.println("Login test Failed");
        }
    }

    // branch creation
    public static void branchCreationTest(){
        driver.findElement(By.cssSelector("a[href *= 'master']")).click();
        System.out.println("clicked on Branches button");
        driver.findElement(By.id("BtnNewBR")).click();
        System.out.println("clicked on New Branch button");
        driver.findElement(By.id("txtbName")).sendKeys("LondonBranch");
        System.out.println("entered LondonBranch in element branch name");
        driver.findElement(By.id("txtAdd1")).sendKeys("address1");
        System.out.println("entered address1 in element address1");
        driver.findElement(By.id("txtZip")).sendKeys("98123");
        System.out.println("entered 98123 in element zipcode");
        Select country = new Select(driver.findElement(By.id("lst_counrtyU")));
        country.selectByVisibleText("UK");
        System.out.println("selected UK from country dropdown");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#lst_stateI>option"), 1));
        Select state = new Select(driver.findElement(By.id("lst_stateI")));
        state.selectByVisibleText("England");
        System.out.println("selected England from state dropdown");
        // anonymous object
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#lst_cityI>option"), 1));
        new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("LONDON");
        System.out.println("selected LONDON from city dropdown");
        driver.findElement(By.id("btn_insert")).click();
        System.out.println("clicked on submit button");
        // switch the driver focus to the alert
        Alert alert = driver.switchTo().alert();
        // get alert text and print on the console
        System.out.println(alert.getText());
        if(alert.getText().startsWith("New Branch")){
            System.out.println("Branch creation test passed");
        } else {
            System.out.println("Branch creation test failed");
        }
        // accept the alert
        alert.accept();
        System.out.println("clicked on Ok button of alert");
    }

    // logout
    public static void logoutTest(){
        driver.findElement(By.cssSelector("a[href *= 'primusbank']")).click();
        System.out.println("clicked on logout button");
        if(driver.findElement(By.id("login")).isDisplayed()){
            System.out.println("Logout test is passed");
        } else {
            System.out.println("Logout test is failed");
        }
    }

    // close browser
    public static void teardown(){
        driver.close();
    }

    public static void main(String[] args) {
        openBrowser();
        loginTest();
        branchCreationTest();
        logoutTest();
        teardown();
    }
}
