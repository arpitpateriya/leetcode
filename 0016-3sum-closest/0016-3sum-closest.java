import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is exactly target, return immediately
                if (sum == target) return sum;

                // Update closest sum if the new sum is closer
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move pointers based on sum comparison with target
                if (sum < target) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return closestSum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // Output: 2
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1)); // Output: 0
        System.out.println(solution.threeSumClosest(new int[]{1, 1, 1, 0}, -100)); // Output: 2
    }
}
