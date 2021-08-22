package logs_and_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utitlity.DriverConfig;

import java.io.File;
import java.io.IOException;

public class ReportDemo {
    static ExtentReports reports;


    public static void launch(){
        ExtentTest test = reports.createTest("launch", "launches the browser");
        test.log(Status.INFO, "chrome browser launched");
//        test.log(Status.INFO, "navigated to some url");
        test.info("navigated to some url");
        test.pass("launch browser test passed");
    }

    public static void login(){
        ExtentTest test = reports.createTest("login", "login test");
        test.info("entered user name");
        test.info("entered password");
        test.info("clicked on login button");
        test.pass("login test passed");
    }

    public static void branchCreation(){
        ExtentTest test = reports.createTest("Branch creation", "branch creation test");
        test.info("clicked on branches button");
        test.info("clicked on new branch button");
        test.info("entered branch name");
        test.info("entered address1");
        test.info("entered zipcode");
        test.info("selected country");
        test.info("selected state");
        test.info("selected city");
        test.info("clicked on submit button");
        test.info("branch created alert accepted");
        test.fail("branch creation test failed");
        try {
            test.addScreenCaptureFromPath(DriverConfig.getFolderPath("screenshots")+File.separator+"image.png");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void logout(){
        ExtentTest test = reports.createTest("logout", "logout test");
        test.info("logout button clicked");
        test.pass("logout test passed");

    }

    public static void close(){
        ExtentTest test = reports.createTest("close", "close browser test");
        test.info("browser closed");
        test.pass("close test passed");
    }

    public static void main(String[] args) {
        reports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(DriverConfig.getFolderPath("reports")+File.separator+"report.html");
        reports.attachReporter(reporter);
        launch();
        login();
        branchCreation();
        logout();
        close();
        reports.flush(); // saves the report
    }


}
