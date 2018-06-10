package idv.kuma._4kyu.binary_multiple_of_3;

import java.util.regex.Pattern;

public class BinaryRegexp {

    public static Pattern multipleOf3() {
//        https://www.codewars.com/kata/54de279df565808f8b00126a
        // Regular expression that matches binary inputs that are multiple of 3

        return Pattern.compile("^((((0+)?1)(10*1)*0)(0(10*1)*0|1)*(0(10*1)*(1(0+)?))|(((0+)?1)(10*1)*(1(0+)?)|(0(0+)?)))$");
    }

}