package jsoninjava; 
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JSONinJava {
    public static void main(String[] args) {
        try{
        ObjectMapper oo = new ObjectMapper();
        Model m = oo.readValue("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":23}", Model.class);
        System.out.println(m.getFirstName());
        }catch(IOException e){ System.err.println("Xatolik sodir bo'ldi"); }
    }
}