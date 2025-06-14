class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Empty string matches empty pattern

        // Handle patterns like "a*", "a*b*", etc., that can match an empty string
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]; // Ignore previous character
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j]; // Use '*' to match multiple
                    }
                }
            }
        }

        return dp[m][n];
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));     // false
        System.out.println(solution.isMatch("aa", "a*"));    // true
        System.out.println(solution.isMatch("ab", ".*"));    // true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));  // false
        System.out.println(solution.isMatch("aaa", "a*a"));  // true
    }
}
