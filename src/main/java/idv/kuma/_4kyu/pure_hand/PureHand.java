package idv.kuma._4kyu.pure_hand;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PureHand {


    public static String solution(String originalHand) {


        StringBuilder sb = new StringBuilder();

        System.out.println(originalHand);

        for (int i = 1; i <= 9; i++) {

            List<Integer> tiles = toIntegerList(originalHand + i);

            if (Collections.frequency(tiles, i) > 4) continue;

            if (isWinning(tiles)) {
                sb.append(String.valueOf(i));
            }
        }


        return sb.toString();
    }

    private static boolean isWinning(List<Integer> tiles) {

        List<Hand> candidateHands = findCandidateHands(tiles);

        if (candidateHands.isEmpty()) return false;

        Optional<Hand> winningHandOpt = candidateHands.stream().filter(hand -> isRemainingsAllMelds(hand)).findAny();


        return winningHandOpt.isPresent();
    }

    static boolean isRemainingsAllMelds(Hand hand) {

        List<Integer> remains = hand.getRemains();

        return isAllMeld(remains);


    }

    private static boolean isAllMeld(List<Integer> allTiles) {

        if (allTiles.size() <= 0) return true;

        int min = allTiles.stream()
                .mapToInt(v -> v)
                .min().getAsInt();

        if (Collections.frequency(allTiles, min) >= 3) {

            List<Integer> subList = makeClone(allTiles);
            for (int i = 0; i < 3; i++) {
                subList.remove(Integer.valueOf(min));
            }

            return isAllMeld(subList);
        }

        if (allTiles.contains(min + 1) && allTiles.contains(min + 2)) {

            List<Integer> subList = makeClone(allTiles);
            subList.remove(Integer.valueOf(min));
            subList.remove(Integer.valueOf(min + 1));
            subList.remove(Integer.valueOf(min + 2));

            return isAllMeld(subList);
        }


        return false;
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

    static List makeClone(List tiles) {
        return (List) ((ArrayList) tiles).clone();
    }

    static class Hand {
        Integer eye;
        List<Integer> remains;

        public Hand(Integer eye, List<Integer> tiles) {
            this.eye = eye;

            this.remains = makeClone(tiles);

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