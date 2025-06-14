class Solution {
    public int romanToInt(String s) {
        // Map to store the integer values of Roman numerals
        Map<Character, Integer> romanValues = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 
            'C', 100, 'D', 500, 'M', 1000
        );

        int total = 0;
        int prevValue = 0;

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(s.charAt(i));
            
            // If current value is smaller than the previous value, subtract it
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            
            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));      // Output: 3
        System.out.println(solution.romanToInt("LVIII"));    // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV"));  // Output: 1994
    }
}
