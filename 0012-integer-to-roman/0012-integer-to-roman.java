class Solution {
    public String intToRoman(int num) {
        // Define Roman numeral values in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Iterate over the values and construct the Roman numeral
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3749)); // "MMMDCCXLIX"
        System.out.println(solution.intToRoman(58));   // "LVIII"
        System.out.println(solution.intToRoman(1994)); // "MCMXCIV"
        System.out.println(solution.intToRoman(9));    // "IX"
        System.out.println(solution.intToRoman(40));   // "XL"
    }
}
