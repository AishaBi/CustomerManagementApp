
package dbutil;
// this holds info for the database connection
import java.sql.*;

public class DBUtil {

    //static method that creates a connection to the database and return the connection object
    public static Connection getConnection()
    {
        Connection conn = null;
        try{

            //Class.forName("com.mysql.jdbc.Driver"); ERROR this class is deprecated use new driver class on line below:
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerDatabase", "root", "root");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    //close connection
    public static void closeConnection(Connection conn)
    {
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}