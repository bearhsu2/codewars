package idv.kuma._4kyu.find_the_unknown_digit;

/**
 * Created by bearhsu2 on 3/27/2018.
 */
import java.util.regex.*;
import javax.script.*;

public class RunesBestPractice {
    private static final Pattern NOT_ZERO = Pattern.compile("(^|[^\\d])[?][?\\d]");

    public static int solveExpression(String runes) {
        for (char d = '0'; d <= '9'; d += 1) {
            if (runes.indexOf(d) >= 0) continue;
            if (d == '0' && NOT_ZERO.matcher(runes).find()) continue;
            if (isCorrect(runes.replace('?', d))) return d - '0';
        }
        return -1;
    }

    private static boolean isCorrect(String expression) {
        try {
            return (boolean) new ScriptEngineManager().getEngineByName("JavaScript")
                    .eval(expression.replace("--", "+").replace("=", "==="));
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}