package JavaLeetcodeSolutions;

public class SingleNumber {

    // Your LeetCode solution class (Must be inside removeDuplicates)
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;

            for (int num : nums) {
                result ^= num; // XOR each number
            }

            return result;
        }
    } // This brace closes the Solution class

    // The main method (Must also be inside removeDuplicates)
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Expected output is 1
        int[] testCase1 = {2, 2, 1};
        System.out.println("Test Case 1 Output: " + solver.singleNumber(testCase1));

        // Test Case 2: Expected output is 4
        int[] testCase2 = {4, 1, 2, 1, 2};
        System.out.println("Test Case 2 Output: " + solver.singleNumber(testCase2));
    }
} // This final brace closes the removeDuplicates class

