package cookies;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utitlity.BrowserConfig;
import utitlity.DriverConfig;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class CookieLogin extends BrowserConfig {

    static WebDriver driver;
    static WebDriverWait wait;

    private static void storeCookieData(String fileName){
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        try {
            File fis = new File(DriverConfig.getFolderPath("")+ File.separator+fileName);
            FileWriter fw = new FileWriter(fis);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder str = new StringBuilder();
            for (Cookie cookie : cookies) {
                str.append(cookie.getName()).append(";").append(cookie.getDomain()).append(";").
                        append(cookie.getPath()).append(";").append(cookie.getValue()).append(";").
                        append(cookie.getExpiry()).append("\n");
            }
            bw.write(str.toString());
            bw.flush();
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadCookies(String fileName){
        File file = new File(DriverConfig.getFolderPath("")+File.separator+fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String s = reader.readLine();
            while(s != null) {
                // retrieve cookie data from text file and create a cookie and set it to driver
                String[] data = s.split(";");
                String name = data[0];
                String domain = data[1];
                String path = data[2];
                String value = data[3];
                String expiry = data[4];
//                Thu Sep 09 12:50:26 IST 2021
                DateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date expiryDate = format.parse(expiry);
                // create the Cookie class object
                Cookie cookie = new Cookie(name, value, domain, path, expiryDate);
                driver.manage().addCookie(cookie);
                s = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void login(){
        driver.findElement(By.cssSelector(".login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("test123@xyz.com");
        driver.findElement(By.id("passwd")).sendKeys("test123");
        driver.findElement(By.id("SubmitLogin")).click();
        if(wait.until(ExpectedConditions.urlContains("my-account"))){
            System.out.println("Login success");
        }

        // call the storeCookieData
        storeCookieData("cookie.txt");
    }

    public static void main(String[] args) {
        driver = launchBrowser(BrowserName.CHROME, "http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver, 20);
//        login();
        loadCookies("cookie.txt");
        driver.get("http://automationpractice.com/index.php?controller=my-account");
        sleep(3000);
        closeBrowser();
    }
}
