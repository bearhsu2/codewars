package idv.kuma._4kyu.strings_mix;


import java.util.*;
import java.util.stream.Collectors;

public class Mixing {

    private static FrequencyMaker frequencyMaker = new FrequencyMaker();

    public static String mix(String s1, String s2) {

        List<CharStat> stats1 = frequencyMaker.makeStatics(s1, "1");
        List<CharStat> stats2 = frequencyMaker.makeStatics(s2, "2");

        stats1.addAll(stats2);

        List<CharStat> result = stats1;

        // 1st pass
        result.sort(CharStat::compareTo);

        // 2nd pass
        result = determineEq(result);

        // 3rd pass
        result = determineDuplicatedCharButDifferentFreq(result);

        // 4th pass
        result.sort(CharStat::compareToConsideringEq);


        String resultString = makeResultString(result);


        System.out.println(resultString);

        return resultString;
    }

    private static List<CharStat> determineDuplicatedCharButDifferentFreq(List<CharStat> original) {
        List<CharStat> result = new ArrayList<>();
        Set<Character> processedChars = new HashSet<>();

        original.forEach(charStat -> {
            if (!processedChars.contains(charStat.charactor)) {
                result.add(charStat);
                processedChars.add(charStat.charactor);
            }
        });

        return result;
    }

    private static List<CharStat> determineEq(List<CharStat> original) {
        List<CharStat> result = new ArrayList<>();

        for (int i = 0; i < original.size(); i++) {
            CharStat current = original.get(i);

            if (i == original.size() - 1) {
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

            char[] charArray = str.toCharArray();
            Map<Character, Integer> charToCount = new HashMap<>();

            for (char c : charArray) {

                if (c < 'a' || c > 'z') continue;

                Integer count = charToCount.get(c);

                if (count == null) {
                    charToCount.put(c, 1);
                } else {
                    charToCount.put(c, count + 1);
                }
            }


            charToCount.entrySet().forEach(entry -> {
                if (entry.getValue() > 1) {
                    statics.add(new CharStat(entry.getKey(), entry.getValue(), stringName));
                }
            });


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



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CharStat charStat = (CharStat) o;

            if (charactor != charStat.charactor) return false;
            if (frequency != charStat.frequency) return false;
            return originalString != null ? originalString.equals(charStat.originalString) : charStat.originalString == null;
        }

        @Override
        public int hashCode() {
            int result = (int) charactor;
            result = 31 * result + frequency;
            result = 31 * result + (originalString != null ? originalString.hashCode() : 0);
            return result;
        }

        public int compareToConsideringEq(CharStat another) {
            if (this.frequency > another.frequency) return -1;
            if (this.frequency < another.frequency) return 1;

            return this.toString().compareTo(another.toString());
        }
    }
}