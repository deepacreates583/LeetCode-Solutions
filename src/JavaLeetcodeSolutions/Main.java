package JavaLeetcodeSolutions;

public class Main {
    public static void main(String[] args) {
        // Now it works perfectly without conflicting with other files
        Solution solver = new Solution();

        String test2 = "cbbd";
        System.out.println("Input: " + test2);
        System.out.println("Output: " + solver.longestPalindrome(test2));
    }

    // Making this 'static' nests it safely inside the removeDuplicates class
    public static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}
