package JavaLeetcodeSolutions;

import java.util.Arrays;

 class removeDuplicates {

    // LeetCode core solution method
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Pointer 'i' tracks the position of the last unique element found
        int i = 0;

        // Pointer 'j' scans through the rest of the array
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Move the unique element forward
            }
        }

        // The number of unique elements is index + 1
        return i + 1;
    }

    // removeDuplicates execution method for IntelliJ to run local tests
    public static void main(String[] args) {
        removeDuplicates app = new removeDuplicates();

        // Test Case: Standard LeetCode example array
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("--- Running Test in JDK 21 ---");
        System.out.println("Original array: " + Arrays.toString(nums));

        // Call the method
        int k = app.removeDuplicates(nums);

        // Print results
        System.out.println("Number of unique elements (k): " + k);

        System.out.print("Modified array up to k elements: [");
        for (int index = 0; index < k; index++) {
            System.out.print(nums[index]);
            if (index < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
