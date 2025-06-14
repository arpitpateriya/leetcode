import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        
        Arrays.sort(nums); // Step 1: Sort the array
        
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for first number
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for second number
                
                int left = j + 1, right = n - 1;
                
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // Use long to avoid overflow
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        
                        // Skip duplicates for third and fourth numbers
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++; // Need a larger sum
                    } else {
                        right--; // Need a smaller sum
                    }
                }
            }
        }
        
        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0)); 
        // Output: [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]

        System.out.println(solution.fourSum(new int[]{2,2,2,2,2}, 8)); 
        // Output: [[2,2,2,2]]
    }
}

