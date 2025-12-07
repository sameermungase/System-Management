import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
     static String Url = "jdbc:postgresql://localhost:5432/system_management";
     static String User = "postgres";
     static String Password = "root";

     public static Connection getConnection() throws SQLException {
         return DriverManager.getConnection(Url,User,Password);
     }
}
