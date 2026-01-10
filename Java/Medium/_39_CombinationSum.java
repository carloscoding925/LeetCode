package Java.Medium;

import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {
    public static void main(String[] args) {
        System.out.println("#39 - Combination Sum - Medium");

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result.toString());

        return;
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
