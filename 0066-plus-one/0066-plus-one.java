import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // No carry, just increment
                return digits;
            }
            digits[i] = 0; // Carry over
        }

        // If all digits were 9 (e.g., 999 → 1000), create a new array
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(sol.plusOne(digits))); // Output: [1,0,0,0]
    }
}
