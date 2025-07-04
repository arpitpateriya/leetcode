class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int left = 0, right = x, ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // To prevent overflow, use division instead of multiplication
            if (mid <= x / mid) {
                ans = mid;  // Store the potential answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4)); // Output: 2
        System.out.println(solution.mySqrt(8)); // Output: 2
    }
}
