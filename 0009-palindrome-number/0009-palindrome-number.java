class Solution {
    public boolean isPalindrome(int x) {
        // If the number is negative or ends with a 0 (but is not 0), it cannot be a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When the length of the number is odd, we discard the middle digit
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
