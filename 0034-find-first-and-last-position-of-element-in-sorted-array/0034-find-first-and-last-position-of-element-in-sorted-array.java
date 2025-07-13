class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Store the index
                if (isFirst) {
                    right = mid - 1; // Search left for first occurrence
                } else {
                    left = mid + 1;  // Search right for last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }
        return bound;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(sol.searchRange(nums1, 8))); // Output: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(sol.searchRange(nums2, 6))); // Output: [-1, -1]

        int[] nums3 = {};
        System.out.println(Arrays.toString(sol.searchRange(nums3, 0))); // Output: [-1, -1]
    }
}
