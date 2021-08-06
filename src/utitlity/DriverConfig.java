package utitlity;

import actions.BrowserName;

import java.io.File;

public class DriverConfig {

    private static String getDriverFolderPath(String folderName){
        String baseDir = System.getProperty("user.dir");
        StringBuilder builder = new StringBuilder(baseDir);
        return builder.append(File.separator).append(folderName).append(File.separator).toString();
    }

    private static String getDriverName(String driverName){
        String osName = System.getProperty("os.name");
        if(osName.toLowerCase().contains("win")){
            driverName = driverName+".exe";
        }
        return driverName;
    }

    public static void setDriverPath(BrowserName browserName) {
        String driversPath = getDriverFolderPath("drivers");
        switch(browserName){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driversPath.concat(getDriverName("chromedriver")));
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", driversPath.concat(getDriverName("geckodriver")));
                break;
        }
    }
}
