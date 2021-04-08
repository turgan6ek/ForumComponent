package ConfigDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnProvider implements ProviderDB{
    static Connection conn = null;
    public static Connection getConn() {
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
