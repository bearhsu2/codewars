package idv.kuma._4kyu.find_the_unknown_digit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

            // divide input into "expression=answer" format
            String[] parts = splitExpAndAnswer(preprocessedInput);
            String expression = parts[0];
            String answer = parts[1];

            String digit = "" + i;
            expression = expression.replaceAll(qRegExp, digit);
            answer = answer.replaceAll(qRegExp, digit);

            // expression cannot contain leading "0"s
            // answer cannot, either
            if (i == 0 && hasLeadingZeros(expression) || isLedByZeros(answer)) continue;

            // skip used numbers
            if (usedNumbers.contains(i)) continue;

            try {
                int left = (Integer) engine.eval(expression);
                int right = Integer.parseInt(answer);

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

    private static boolean hasLeadingZeros(String expression){
        // find two "numbers"
        String[] numberStrings = expression.split("[\\D]");

        return isLedByZeros(numberStrings[0]) || isLedByZeros(numberStrings[1]);
    }

    private static boolean isLedByZeros(String numberString){
        if (numberString.length() == 1) return false;

        // String to be scanned to find the pattern.
        String pattern = "^0";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(numberString);

        return m.find();
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
