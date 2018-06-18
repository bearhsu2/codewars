package idv.kuma._4kyu.time_formatter;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    public static final int SECS_IN_SECOND = 1;
    public static final int SECS_IN_MINUTE = SECS_IN_SECOND * 60;
    public static final int SECS_IN_HOUR = SECS_IN_MINUTE * 60;
    public static final int SECS_IN_DAY = SECS_IN_HOUR * 24;
    public static final int SECS_IN_YEAR = SECS_IN_DAY * 365;

    private static StringBuilder sb;
    private static int leftover;
    private static List<ResultElement> resultElements;

    public static String formatDuration(int input) {

        if (0 == input) return "now";

        initializeVars(input);

        handleWithUnit(SECS_IN_YEAR, "year");
        handleWithUnit(SECS_IN_DAY, "day");
        handleWithUnit(SECS_IN_HOUR, "hour");
        handleWithUnit(SECS_IN_MINUTE, "minute");
        handleWithUnit(SECS_IN_SECOND, "second");

        return getResultFromList();

    }


    static void initializeVars(int input) {
        sb = new StringBuilder();
        resultElements = new ArrayList();
        leftover = input;
    }


    static void handleWithUnit(int unitSizeInSec, String unitName) {
        if (shouldHandleWithThisUnit(unitSizeInSec)) {

            int units = calculateUnits(unitSizeInSec);

            admustLeftover(unitSizeInSec, units);

            putToResultElements(new ResultElement(units, unitName));
        }
    }

    private static void admustLeftover(int unitSizeInSec, int units) {
        leftover -= units * unitSizeInSec;
    }

    private static int calculateUnits(int unitSizeInSec) {
        return leftover / unitSizeInSec;
    }

    private static boolean shouldHandleWithThisUnit(int unitSizeInSec) {
        return unitSizeInSec <= leftover;
    }


    static void putToResultElements(ResultElement resultElement) {
        resultElements.add(resultElement);
    }

    private static String getResultFromList() {

        int size = resultElements.size();

        for (int i = 0; i < size; i++) {
            ResultElement resultElement = resultElements.get(i);
            int number = resultElement.getNumber();
            sb.append(number)
                    .append(" ")
                    .append(resultElement.getUnit())
                    .append(((number == 1) ? "" : "s"))
                    .append((i < size - 2) ? ", " : "")
                    .append((i == size - 2) ? " and " : "");
        }

        return sb.toString();

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

