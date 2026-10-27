package JavaLeetcodeSolutions;

public class SearchPosition {

        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid; // Target found
                } else if (nums[mid] < target) {
                    left = mid + 1; // Search the right half
                } else {
                    right = mid - 1; // Search the left half
                }
            }

            // If not found, 'left' points to the correct insertion index
            return left;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // Test Case 1
            int[] nums1 = {1, 3, 5, 6};
            int target1 = 5;
            System.out.println("Output for Example 1: " + solution.searchInsert(nums1, target1)); // Expected: 2

            // Test Case 2
            int[] nums2 = {1, 3, 5, 6};
            int target2 = 2;
            System.out.println("Output for Example 2: " + solution.searchInsert(nums2, target2)); // Expected: 1

            // Test Case 3
            int[] nums3 = {1, 3, 5, 6};
            int target3 = 7;
            System.out.println("Output for Example 3: " + solution.searchInsert(nums3, target3)); // Expected: 4
        }
    }


