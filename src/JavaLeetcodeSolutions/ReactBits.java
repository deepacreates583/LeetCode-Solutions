package JavaLeetcodeSolutions;

import java.util.Arrays;

class Solution {
    // 1. Reverse Bits
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1;
        }
        return result;
    }

    // 2. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length, low = 0, high = m;
        while (low <= high) {
            int pX = (low + high) / 2, pY = (m + n + 1) / 2 - pX;
            int maxLeftX = (pX == 0) ? Integer.MIN_VALUE : nums1[pX - 1];
            int minRightX = (pX == m) ? Integer.MAX_VALUE : nums1[pX];
            int maxLeftY = (pY == 0) ? Integer.MIN_VALUE : nums2[pY - 1];
            int minRightY = (pY == n) ? Integer.MAX_VALUE : nums2[pY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                return Math.max(maxLeftX, maxLeftY);
            }
            if (maxLeftX > minRightY) high = pX - 1;
            else low = pX + 1;
        }
        return 0.0;
    }

    // 3. Regular Expression Matching
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                if (pc == '.' || pc == sc) dp[i][j] = dp[i - 1][j - 1];
                else if (pc == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int input1 = 43261596;
        int output1 = solver.reverseBits(input1);

        String binIn1 = String.format("%32s", Integer.toBinaryString(input1)).replace(' ', '0');
        String binOut1 = String.format("%32s", Integer.toBinaryString(output1)).replace(' ', '0');

        System.out.println("--- Test Case 1 ---");
        System.out.println("Input (Int):  " + input1);
        System.out.println("Input (Bin):  " + binIn1);
        System.out.println("Output (Int): " + output1);
        System.out.println("Output (Bin): " + binOut1);
    }

    public String lengthOfLongestSubstring(String abcabcbb) {
        return abcabcbb.length() == 0 ? "0" : abcabcbb;
    }

    public String threeSum(int[] ints) {
        return Arrays.toString(threeSum(ints).toCharArray());
    }

    public void fourSum(int[] nums, int target) {
        return;
    }

    public boolean reverse(int i) {
        return false;
    }
}


