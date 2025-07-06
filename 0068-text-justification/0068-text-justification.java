import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineLength = words[index].length();
            int last = index + 1;

            // Find the maximum number of words that fit in the line
            while (last < words.length && (lineLength + words[last].length() + (last - index)) <= maxWidth) {
                lineLength += words[last].length();
                last++;
            }

            int numWords = last - index;
            int numSpaces = maxWidth - lineLength;

            // Build the line
            StringBuilder line = new StringBuilder();
            if (last == words.length || numWords == 1) {  // Last line OR single word in a line (left-justified)
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");  // Fill remaining spaces
            } else {  // Fully justify
                int spacesBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) { // Add spaces
                        int spaces = spacesBetween + ((i - index) < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spaces; s++) line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(sol.fullJustify(words, maxWidth));
    }
}
