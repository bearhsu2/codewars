package idv.kuma._4kyu.strings_mix;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mixing {

    private static FrequencyMaker frequencyMaker = new FrequencyMaker();

    public static String mix(String s1, String s2) {

        List<CharStat> stats1 = frequencyMaker.makeStatics(s1, "1");
        List<CharStat> stats2 = frequencyMaker.makeStatics(s2, "2");


        List<CharStat> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < stats1.size() || j < stats2.size()) {
            CharStat cs1 = i >= stats1.size() ? null : stats1.get(i);
            CharStat cs2 = j >= stats2.size() ? null : stats2.get(j);

            if (cs1 == null) {
                result.add(cs2);
                j++;
            } else if (cs2 == null) {
                result.add(cs1);
                i++;
            } else if (cs1.frequency > cs2.frequency) {
                result.add(cs1);
                i++;
            } else if (cs1.frequency < cs2.frequency) {
                result.add(cs2);
                j++;
            } else {
                System.out.println("SHIT!!!!");
            }

        }


        return makeResultString(result);
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

    public static class CharStat {
        private char charactor;
        private int frequency;
        private String originalString;

        public CharStat(char charactor, int frequency, String originalString) {
            this.charactor = charactor;
            this.frequency = frequency;
            this.originalString = originalString;
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

    }
}