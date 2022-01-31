package vaqt;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Vaqt {

    public static void main(String[] args) {

        String mainString = "calc 23*(44+12)*3";
        String only_value = mainString.substring(5);
        System.out.println(only_value);
        
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        
        try{
            Integer result = (Integer) engine.eval(only_value);
            System.out.println(result);
        }catch(ScriptException e){
            e.printStackTrace();
        }

    }
}
