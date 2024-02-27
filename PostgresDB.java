import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/java_oop";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "7894");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
