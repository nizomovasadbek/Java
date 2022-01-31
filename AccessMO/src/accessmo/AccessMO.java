package accessmo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessMO {
    private static Connection conn = null;
    private static Statement stmt;
    private static String sqlQuery = "SELECT * FROM uquvchimo";
    private static ResultSet rs;
    public static String misol = "_";
    
    
    public static void main(String[] args) {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String path="C:\\Program Files\\database\\Baza1.accdb";
            File f = new File(path);
            if(!f.exists()){
                path = "Baza1.accdb";
            }
            String url = "jdbc:ucanaccess://"+path;
            
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            System.out.println("MS Access bilan aloqa ulandi.");
            while(rs.next()){
                misol = rs.getString("ID") + "  " + 
                        rs.getString("Ismi") + "  " + rs.getString("Familiyasi") + "  " + rs.getInt("Yosh")
                + "  " + rs.getString("Manzil");
                System.out.println(misol);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Klas topilmadi.");
        } catch (SQLException ex) {
            System.out.println("Bazada xatolik");
        }
    }
}