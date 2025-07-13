class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1; // Search right half
                }
            } 
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search right half
                } else {
                    right = mid - 1; // Search left half
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(sol.search(nums1, 0)); // Output: 4
        System.out.println(sol.search(nums1, 3)); // Output: -1

        int[] nums2 = {1};
        System.out.println(sol.search(nums2, 0)); // Output: -1
    }
}
