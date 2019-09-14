package idv.kuma._4kyu.machine_learning_game;

import java.util.*;
import java.util.function.Function;


public class MachineLearning {

    int currentCmd;
    int trainedCounts;

    Map<Integer, Integer> correctMappings;

    public MachineLearning() {

        correctMappings = new HashMap<>();
        trainedCounts = 0;
    }

    public int command(int cmd, int num) {
        currentCmd = cmd;

        if (!correctMappings.containsKey(cmd)) correctMappings.put(cmd, 0);

        int suggestedAction = correctMappings.get(cmd);

        System.out.println("train " + trainedCounts + ", num = " + num + ", cmd = " + cmd + ", action = " + suggestedAction);

        trainedCounts++;
        return Actions.FUNCTIONS.get(suggestedAction).apply(num);
    }

    public void response(boolean result) {

        int suggestedAction = correctMappings.get(currentCmd);

        if (result) {
            System.out.println("Correct answer => pair (" + currentCmd + ", " + suggestedAction + ") remains in correct mappings");
        } else {
            // Suggest another answer candidate next time
            suggestedAction++;
            System.out.println("Wrong answer => suggest pair (" + currentCmd + ", " + suggestedAction + ") next time");
            correctMappings.put(currentCmd, suggestedAction);
        }
    }

    static class Actions {
        static final List<Function<Integer, Integer>> FUNCTIONS = Arrays.asList(x -> x + 1, x -> 0, x -> x % 2, x -> x / 2, x -> x * 100);
    }


}
