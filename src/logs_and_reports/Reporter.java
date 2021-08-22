package logs_and_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utitlity.DriverConfig;

import java.io.File;

public class Reporter {
    static ExtentReports reports = new ExtentReports();
    static ExtentSparkReporter reporter = new ExtentSparkReporter(DriverConfig.getFolderPath("reports")+ File.separator+"report.html");
    static ExtentTest test;
}
