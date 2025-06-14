import java.util.*;

class Solution {
    // Map digits to corresponding letters
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = KEYPAD[digits.charAt(index) - '0']; // Get the corresponding letters
        for (char c : letters.toCharArray()) {
            current.append(c); // Choose
            backtrack(result, current, digits, index + 1); // Explore
            current.deleteCharAt(current.length() - 1); // Undo (Backtrack)
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations("")); // []
        System.out.println(solution.letterCombinations("2")); // ["a","b","c"]
    }
}
