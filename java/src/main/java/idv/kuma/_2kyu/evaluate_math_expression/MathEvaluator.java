package idv.kuma._2kyu.evaluate_math_expression;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathEvaluator {

    private static final ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("JavaScript");

    public double calculate(String expression) {

        try {
            Object result = ENGINE.eval(expression);

            if (result instanceof Integer){
                return (int) result;
            }

            return (double) result;

        } catch (ScriptException e) {
            e.printStackTrace();
            return 0.0;
        }

    }

}