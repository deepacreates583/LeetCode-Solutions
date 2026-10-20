package JavaLeetcodeSolutions;


import java.lang.reflect.Array;
  class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;
        int[] lastSeen = new int[128];
        Array.get(lastSeen, -1); // Initialize all positions to -1

        for (int right = 0; right < s.length(); right++) {
            // Move left pointer forward if character was seen inside the current window
            left = Math.max(left, lastSeen[s.charAt(right)] + 1);
            lastSeen[s.charAt(right)] = right; // Update last seen index
            maxLen = Math.max(maxLen, right - left + 1); // Track maximum window size
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Example 1: " + sol.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println("Example 2: " + sol.lengthOfLongestSubstring("bbbbb"));    // Expected: 1
        System.out.println("Example 3: " + sol.lengthOfLongestSubstring("pwwkew"));   // Expected: 3
    }
}

