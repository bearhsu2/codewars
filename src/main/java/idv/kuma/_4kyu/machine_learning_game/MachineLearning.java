package idv.kuma._4kyu.machine_learning_game;

import static idv.kuma._4kyu.machine_learning_game.MachineLearning.Actions.FUNCTIONS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MachineLearning {

    int currentCmd;
    int suggestedAction;
    int trainedCounts;

    List<Pair> candidatePairs;
    Map<Integer, Integer> correctPairs;

    public MachineLearning() {
        candidatePairs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                candidatePairs.add(new Pair(i, j));
            }
        }
        correctPairs = new HashMap<>();
        trainedCounts = 0;
    }

    public int command(int cmd, int num) {
        currentCmd = cmd;
        if (trainedCounts >= 20) {

            if (correctPairs.size() < 5){
                for (Pair pair : candidatePairs){
                    if (!correctPairs.containsKey(pair.getKey()) && !correctPairs.containsValue(pair.getValue())){
                        correctPairs.put(pair.getKey(), pair.getValue());
                    }
                }
            }

            suggestedAction = correctPairs.get(cmd);
        } else {
            suggestedAction = candidatePairs
                    .stream()
                    .filter(pair -> pair.getKey() == cmd)
                    .collect(Collectors.toList())
                    .get(0)
                    .getValue();
        }

        System.out.println("train " + trainedCounts + ", num = " + num + ", cmd = " + cmd + ", action = " + suggestedAction);

        trainedCounts++;
        return FUNCTIONS.get(suggestedAction).apply(num);
    }

    public void response(boolean result) {
        if (result) {
            System.out.println("Correct answer => add pair (" + currentCmd + ", " + suggestedAction + ") to correct pairs");
            correctPairs.put(currentCmd, suggestedAction);
        } else {
            // Remove (cmd, action) pair from candidate pairs
            System.out.println("Wrong answer => remove pair (" + currentCmd + ", " + suggestedAction + ") from candidate pairs");
            candidatePairs = candidatePairs
                    .stream()
                    .filter(pair -> !(pair.getKey() == currentCmd && pair.getValue() == suggestedAction))
                    .collect(Collectors.toList());
        }
    }

    static class Actions {
        static final List<Function<Integer, Integer>> FUNCTIONS = Arrays.asList(x -> x + 1, x -> 0, x -> x % 2, x -> x / 2, x -> x * 100);
    }

    static class Pair{
        int key;
        int value;


        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

}
