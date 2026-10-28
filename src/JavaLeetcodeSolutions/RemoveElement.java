package JavaLeetcodeSolutions;

    import java.util.Arrays;

    public class Solution {

        public int removeElement(int[] nums, int val) {
            int k = 0; // Pointer for the next position of a non-val element

            for (int i = 0; i < nums.length; i++) {
                // If the current element is not the target value to remove
                if (nums[i] != val) {
                    nums[k] = nums[i]; // Move it to the front at index k
                    k++; // Increment the count of valid elements
                }
            }

            return k; // Return the number of elements not equal to val
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // Test Case 1
            int[] nums1 = {3, 2, 2, 3};
            int val1 = 3;
            System.out.println("Original Array 1: " + Arrays.toString(nums1));

            int k1 = solution.removeElement(nums1, val1);

            System.out.println("Number of valid elements (k): " + k1);
            System.out.println("Modified Array (first k elements): " + Arrays.toString(Arrays.copyOf(nums1, k1)));
            System.out.println("Full Array State: " + Arrays.toString(nums1));
            System.out.println("----------------------------------------------");

            // Test Case 2
            int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
            int val2 = 2;
            System.out.println("Original Array 2: " + Arrays.toString(nums2));

            int k2 = solution.removeElement(nums2, val2);

            System.out.println("Number of valid elements (k): " + k2);
            System.out.println("Modified Array (first k elements): " + Arrays.toString(Arrays.copyOf(nums2, k2)));
            System.out.println("Full Array State: " + Arrays.toString(nums2));
        }
    }


