import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Found a valid permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip already used elements

            used[i] = true;
            tempList.add(nums[i]); // Choose
            backtrack(nums, tempList, result, used); // Explore
            tempList.remove(tempList.size() - 1); // Unchoose (backtrack)
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(sol.permute(nums));
        // Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
    }
}
