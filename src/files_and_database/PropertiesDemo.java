package files_and_database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) {
        // create a file class object
        FileInputStream file = null;
        try {
            file = new FileInputStream(".//config.properties");
            // create Properties class object
            Properties prop = new Properties();
            // load the properties file
            prop.load(file);
            // read the properties
            String url = prop.getProperty("url");
            System.out.println(url);

            // if property not mentioned in properties file then it will return default value else returns value of given property
            String username = prop.getProperty("username", "anusha");
            System.out.println("username = "+username);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
