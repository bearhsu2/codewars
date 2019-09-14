package idv.kuma._3kyu.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

    private static final ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Double evaluate(String expression) {
        try {
            Object result = ENGINE.eval(expression);

            if (result instanceof Integer){
                return Double.valueOf((int)result);
            }

            return (double) result;

        } catch (ScriptException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}