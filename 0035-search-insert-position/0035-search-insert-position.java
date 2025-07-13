class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right
            } else {
                right = mid - 1; // Search left
            }
        }

        return left; // Insert position
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 3, 5, 6};
        System.out.println(sol.searchInsert(nums1, 5)); // Output: 2
        System.out.println(sol.searchInsert(nums1, 2)); // Output: 1
        System.out.println(sol.searchInsert(nums1, 7)); // Output: 4
        System.out.println(sol.searchInsert(nums1, 0)); // Output: 0
    }
}
