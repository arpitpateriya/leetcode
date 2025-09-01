class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0; // Variables to track the start and end of the longest palindrome

        for (int i = 0; i < s.length(); i++) {
            // Check for palindrome with odd length
            int len1 = expandAroundCenter(s, i, i);
            // Check for palindrome with even length
            int len2 = expandAroundCenter(s, i, i + 1);
            // Get the maximum length between the two cases
            int len = Math.max(len1, len2);

            // Update the start and end if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
