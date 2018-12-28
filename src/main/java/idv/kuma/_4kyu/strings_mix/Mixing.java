package idv.kuma._4kyu.strings_mix;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mixing {

    private static FrequencyMaker frequencyMaker = new FrequencyMaker();

    public static String mix(String s1, String s2) {

        List<CharStat> stats1 = frequencyMaker.makeStatics(s1, "1");
        List<CharStat> stats2 = frequencyMaker.makeStatics(s2, "2");

        stats1.addAll(stats2);

        List<CharStat> result = stats1;

        result.sort(CharStat::compareTo);

        result = determineEq(result);


        String resultString = makeResultString(result);


        System.out.println(resultString);

        return resultString;
    }

    private static List<CharStat> determineEq(List<CharStat> original) {
        List<CharStat> result = new ArrayList<>();

        for (int i = 0; i < original.size(); i++) {
            CharStat current = original.get(i);

            if (i == original.size() - 1){
                result.add(current);
                break;
            }

            CharStat next = original.get(i + 1);
            if (current.charactor == next.charactor && current.frequency == next.frequency) {
                result.add(makeEqCharSet(current));
                i++;
            } else {
                result.add(current);
            }
        }

        return result;

    }

    private static CharStat makeEqCharSet(CharStat cs1) {
        return new CharStat(cs1.charactor, cs1.frequency, "=");
    }

    private static String makeResultString(List<CharStat> charStats) {

        return charStats.stream().map(x -> x.toString()).collect(Collectors.joining("/"));


    }


    public static class FrequencyMaker {

        public List<CharStat> makeStatics(String str, String stringName) {
            List<CharStat> statics = new ArrayList<>();

            // TODO: fill this part

            return statics;
        }
    }

    public static class CharStat implements Comparable {
        private char charactor;
        private int frequency;
        private String originalString;

        public CharStat(char charactor, int frequency, String originalString) {
            this.charactor = charactor;
            this.frequency = frequency;
            this.originalString = originalString;
        }


        public char getCharactor() {
            return charactor;
        }

        public int getFrequency() {
            return frequency;
        }

        public String getOriginalString() {
            return originalString;
        }

        @Override
        public String toString() {
            return originalString + ":" + makeSubstring();
        }

        private String makeSubstring() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < frequency; i++) {
                sb.append(charactor);
            }
            return sb.toString();
        }

        @Override
        public int compareTo(Object o) {
            CharStat another = (CharStat) o;

            if (this.frequency > another.frequency) return -1;
            if (this.frequency < another.frequency) return 1;

            if (this.charactor < another.charactor) return -1;
            if (this.charactor > another.charactor) return 1;
            return 0;
        }
    }
}