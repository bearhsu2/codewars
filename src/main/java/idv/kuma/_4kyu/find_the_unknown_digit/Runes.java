package idv.kuma._4kyu.find_the_unknown_digit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashSet;
import java.util.Set;

//https://www.codewars.com/kata/find-the-unknown-digit/train/java
public class Runes {

    private static final String EQUAL = "=";

    public static int solveExpression( final String input ) {
        int missingDigit = -1;

        String preprocessedInput = preProcessing(input);

        Set<Integer> usedNumbers = findUsedNumbers(preprocessedInput);

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        String qRegExp = "\\?";
        for (int i = 0; i <= 9; i++) {

            // "?" cannot be a leading "0"
            if (i == 0 && missingDigitLeading(preprocessedInput)) continue;

            // skip used numbers
            if (usedNumbers.contains(i)) continue;

            // divide input into "expression=answer" format
            String[] parts = splitExpAndAnswer(preprocessedInput);
            String expression = parts[0];
            String answer = parts[1];

            try {
                String digit = "" + i;

                int left = (Integer) engine.eval(expression.replaceAll(qRegExp, digit));
                int right = Integer.parseInt(answer.replaceAll(qRegExp, digit));

                if (left == right) {
                    missingDigit = i;
                    break;
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }

        }

        return missingDigit;
    }

    private static boolean missingDigitLeading(String input) {
        return input.startsWith("?") ||
                input.contains("*?") ||
                input.contains("-?") ||
                input.contains("+?");
    }

    public static Set<Integer> findUsedNumbers(String input) {
        Set<Integer> result = new HashSet<>();
        for (char c : input.toCharArray()){
            if (Character.isDigit(c)){
                result.add(Integer.parseInt("" + c));
            }
        }
        return result;
    }

    public static String preProcessing(String input) {
        return input.replaceAll("--", "+");
    }

    public static String[] splitExpAndAnswer(String input){

        String[] response = input.split(EQUAL);
        return response;
    }



}
