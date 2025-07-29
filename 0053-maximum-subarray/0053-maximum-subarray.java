class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Store the maximum subarray sum
        int currentSum = nums[0]; // Store the running sum

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // Extend or restart subarray
            maxSum = Math.max(maxSum, currentSum); // Update maximum found so far
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(nums)); // Output: 6
    }
}
