package JavaLeetcodeSolutions;

public class LengthOfLastWord {
    public class Main {
        public static void main(String[] args) {
            Solution solution = new Solution();

            // Example 1
            String s1 = "Hello World";
            System.out.println("Example 1 Output: " + solution.lengthOfLastWord(s1)); // Expected: 5

            // Example 2
            String s2 = "   fly me   to   the moon  ";
            System.out.println("Example 2 Output: " + solution.lengthOfLastWord(s2)); // Expected: 4

            // Example 3
            String s3 = "luffy is still joyboy";
            System.out.println("Example 3 Output: " + solution.lengthOfLastWord(s3)); // Expected: 6
        }
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            // 1. Remove any leading and trailing whitespace
            s = s.trim();

            // 2. Find the index of the last space character in the trimmed string
            int lastSpaceIndex = s.lastIndexOf(' ');

            // 3. The length of the last word is the difference between the string's
            // total length and the index of the last space minus 1
            return s.length() - 1 - lastSpaceIndex;
        }
    }

}
