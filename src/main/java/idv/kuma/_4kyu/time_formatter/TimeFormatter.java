package idv.kuma._4kyu.time_formatter;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    private static StringBuilder sb;
    private static int leftover;

    private static List<ResultElement> resultElements;

    public static String formatDuration(int input) {

        sb = new StringBuilder();
        resultElements = new ArrayList();

        leftover = input;

        handleWithUnit(1 * 60 * 60 * 24 * 365, "year");
        handleWithUnit(1 * 60 * 60 * 24, "day");
        handleWithUnit(1 * 60 * 60, "hour");
        handleWithUnit(1 * 60, "minute");
        handleWithUnit(1, "second");

        fillSb();

        return sb.length() == 0 ? "now" : sb.toString();
    }


    static void handleWithUnit(int unitSizeInSec, String unitName) {
        if (unitSizeInSec <= leftover) {

            int units = leftover / unitSizeInSec;

            leftover -= units * unitSizeInSec;

            appendSubStrings(new ResultElement(units, unitName));

        }
    }


    static void appendSubStrings(ResultElement resultElement) {


        resultElements.add(resultElement);

    }

    private static void fillSb() {

        int size = resultElements.size();

        for (int i = 0; i < size; i++) {

            ResultElement resultElement = resultElements.get(i);

            int number = resultElement.getNumber();
            sb.append(number);
            sb.append(" ");
            sb.append(resultElement.getUnit());
            sb.append(((number == 1) ? "" : "s"));


            if (i < size - 2){
                sb.append(", ");
            } else if (i == size - 2) {
                sb.append(" and ");
            }

        }

    }

}

class ResultElement {
    int number;

    String unit;

    public ResultElement(int number, String unit) {
        this.number = number;
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

