package files_and_database;
/*
 * Database technology
 * Database url
 * Database name and login credentials
 * Table name
 * Table columns name and data types
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseDemo1 {

    public static String readProperty(String propName){
        String propValue = "";
        try {
            FileInputStream fis = new FileInputStream(".//dbconfig.properties");
            Properties prop = new Properties();
            prop.load(fis);
            propValue = prop.getProperty(propName);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propValue;
    }

    public static void main(String[] args) {
        try {
            /*
             * Load the driver class related to the DB technology dynamically using
             * forName() method of Class class
             */
            Class.forName(readProperty("driver"));

            /*
             * Create connection to the required database by calling getConnection() method
             * of DriverManager class and storing reference in Connection class object
             */
            Connection connection = DriverManager.getConnection(readProperty("dburl"), readProperty("username"), readProperty("password"));

            /*
             * Create Statement class object by calling createStatement() method of
             * Connection class so that we can execute SQL queries
             */
            Statement statement = connection.createStatement();

            /*
             * Execute SQL queries using executeQuery() method of Statement class and store
             * the results in ResultSet class object
             */
            ResultSet rs = statement.executeQuery("SELECT * FROM employees where officeCode = 7;");

            /* Iterate over the results using next() method of ResultSet class */
            while(rs.next()){
                int employeeNumber = rs.getInt("employeeNumber");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String extension = rs.getString("extension");
                String email = rs.getString("email");
                int officeCode = rs.getInt("officeCode");
                String reportsTo = rs.getString("reportsTo");
                String jobTitle = rs.getString("jobTitle");
                System.out.printf("id = %d, first name = %s, lastname = %s, extension = %s, email = %s, office code = %d, reports to = %s, job title = %s\n", employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);
            }

            /* Close the data base connection using close() method of Connection class */
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
