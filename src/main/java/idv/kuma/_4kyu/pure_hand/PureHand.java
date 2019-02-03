package idv.kuma._4kyu.pure_hand;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PureHand {


    public static String solution(String originalHand) {


        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {

            List<Integer> tiles = toIntegerList(originalHand + i);

            if (isWinning(tiles)) {
                sb.append(String.valueOf(i));
            }
        }


        return sb.toString();
    }

    private static boolean isWinning(List<Integer> tiles) {

        List<Hand> candidateHands = findCandidateHands(tiles);

        if (candidateHands.isEmpty()) return false;


        return true;
    }

    static List<Hand> findCandidateHands(final List<Integer> tiles) {

        List<Hand> hands = new ArrayList<>();

        tiles.stream().filter(i -> Collections.frequency(tiles, i) > 1)
                .collect(Collectors.toSet()).forEach(i -> hands.add(new Hand(i, tiles)));


        return hands;
    }


    static List<Integer> toIntegerList(String input) {

        List<Integer> result = new ArrayList<>();

        for (char c : input.toCharArray()) {
            result.add(Integer.parseInt(String.valueOf(c)));
        }


        return result;
    }


    static class Hand {
        Integer eye;
        List<Integer> remains;

        public Hand(Integer eye, List<Integer> tiles) {
            this.eye = eye;

            this.remains = ((List) ((ArrayList) tiles).clone());

            for (int i = 0; i < 2; i++) {
                this.remains.remove(eye);
            }

            remains.sort(Integer::compareTo);
        }

        public Integer getEye() {
            return eye;
        }

        public List<Integer> getRemains() {
            return remains;
        }
    }
}