package oracledatabasejdbc;
import java.sql.*;
public class Oracledatabasejdbc {
    public static void main(String[] args) {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:baza@//localhost:1521:", "baza", "baza");
            System.out.println("Klas bilan aloqa ulandi.");
            System.out.println("Baza bilan aloqa ulandi.");
        }catch(ClassNotFoundException e){
            System.err.println("Klas topilmadi");
        } catch (SQLException ex) {
            System.out.println("Ulanishda xatolik");
        }
    }
}