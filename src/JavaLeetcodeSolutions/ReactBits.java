package JavaLeetcodeSolutions;

class Solution {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1; // Logical right shift handles signed integers correctly
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // LeetCode Example 1
        int input1 = 43261596;
        int output1 = solver.reverseBits(input1);

        // Fixed binary string padding for console output
        String binIn1 = String.format("%32s", Integer.toBinaryString(input1)).replace(' ', '0');
        String binOut1 = String.format("%32s", Integer.toBinaryString(output1)).replace(' ', '0');

        System.out.println("--- Test Case 1 ---");
        System.out.println("Input (Int):  " + input1);
        System.out.println("Input (Bin):  " + binIn1);
        System.out.println("Output (Int): " + output1);
        System.out.println("Output (Bin): " + binOut1);
    }

    public String findMedianSortedArrays(int[] nums1, int[] nums2) {

        return "";
    }
}



