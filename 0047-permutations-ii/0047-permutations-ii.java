import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Found a valid permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip used elements

            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]); // Choose
            backtrack(nums, tempList, result, used); // Explore
            tempList.remove(tempList.size() - 1); // Unchoose (backtrack)
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(sol.permuteUnique(nums));
        // Output: [[1,1,2], [1,2,1], [2,1,1]]
    }
}
