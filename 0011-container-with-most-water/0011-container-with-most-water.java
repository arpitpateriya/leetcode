class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(solution.maxArea(new int[]{1,1}));               // 1
        System.out.println(solution.maxArea(new int[]{4,3,2,1,4}));         // 16
        System.out.println(solution.maxArea(new int[]{1,2,1}));             // 2
    }
}

