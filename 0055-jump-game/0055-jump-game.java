class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // If we can't reach index i, return false
            maxReach = Math.max(maxReach, i + nums[i]); // Update maxReach
            if (maxReach >= nums.length - 1) return true; // Early exit if last index is reachable
        }

        return true;
    }

}
