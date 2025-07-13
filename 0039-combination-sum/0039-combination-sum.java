import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Optional, helps in pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // Prune unnecessary recursion

            tempList.add(candidates[i]); // Choose the number
            backtrack(candidates, target - candidates[i], i, tempList, result); // Recur with same index
            tempList.remove(tempList.size() - 1); // Backtrack (remove last added number)
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target));
        // Output: [[2,2,3], [7]]
    }
}
