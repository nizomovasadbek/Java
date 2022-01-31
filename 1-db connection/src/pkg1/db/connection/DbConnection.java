package pkg1.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Initialize");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magic", "root", "root");
        Statement st = conn.createStatement();
        st.execute("SELECT * FROM mafia");
        System.out.println("Successfully");
    }
}