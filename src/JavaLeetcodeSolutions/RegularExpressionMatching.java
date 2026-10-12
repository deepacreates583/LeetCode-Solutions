package JavaLeetcodeSolutions;

class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Base case: deals with patterns like a*, a*b*, etc., matching an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Case 1: Match 0 instances of the preceding character
                    dp[i][j] = dp[i][j - 2];
                    // Case 2: Match 1 or more instances if preceding character matches
                    char prevPatternChar = p.charAt(j - 2);
                    if (prevPatternChar == '.' || prevPatternChar == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        System.out.println("Example 1: " + sol.isMatch("aa", "a"));    // false
        // Example 2
        System.out.println("Example 2: " + sol.isMatch("aa", "a*"));   // true
        // Example 3
        System.out.println("Example 3: " + sol.isMatch("ab", ".*"));   // true
    }
}

