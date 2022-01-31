package pkg1.db.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Databaseconnect {
    
    public ResultSet rs = null;
    public ArrayList<String> list1 = new ArrayList<String>();
    
    public void connect(){
        Connection conn = null;
        String url = "jdbc:sqlite:D:/conn.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Baza bilan ulandi.");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM base");
        } catch (SQLException ex) {
            Logger.getLogger(Databaseconnect.class.getName()).log(Level.SEVERE, "MO xatoligi", ex);
        } catch(ClassNotFoundException e){
            Logger.getLogger(Databaseconnect.class.getName()).log(Level.SEVERE, "Klas topilmadi", e);
        }
            finally {
            try{
                if(conn!=null){ conn.close(); }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void getDatas(){
        try {
            if(rs!=null)
            while(rs.next()){
                list1.add(rs.getString(0));
            }
        } catch (SQLException ex) {
            System.err.println("MO da xatolik");
        }
    }
    
    public Databaseconnect(){
        connect();
    }
}