class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Take the first string as the reference prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // Compare characters of prefix with the current string
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j); // Update prefix to the matched part
            if (prefix.isEmpty()) return ""; // If no common prefix, return immediately
        }

        return prefix;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));   // ""
        System.out.println(solution.longestCommonPrefix(new String[]{"interstellar", "internet", "internal"})); // "inte"
        System.out.println(solution.longestCommonPrefix(new String[]{"apple"})); // "apple"
    }
}

