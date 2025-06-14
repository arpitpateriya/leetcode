import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Push opening brackets
            } else {
                if (stack.isEmpty()) return false; // No matching open bracket
                
                char top = stack.pop(); // Pop last opening bracket
                
                // Check for matching pairs
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty(); // Stack must be empty if valid
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));      // true
        System.out.println(solution.isValid("()[]{}"));  // true
        System.out.println(solution.isValid("(]"));      // false
        System.out.println(solution.isValid("([)]"));    // false
        System.out.println(solution.isValid("{[]}"));    // true
    }
}
