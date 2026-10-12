package JavaLeetcodeSolutions;

    class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to achieve O(log(min(m, n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            // If partitionX is 0 it means nothing is on left side for nums1. Use -INF
            // If partitionX is m it means nothing is on right side for nums1. Use +INF
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // We are too far right in nums1, move left
                high = partitionX - 1;
            } else {
                // We are too far left in nums1, move right
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("--- Test Case 1 ---");
        System.out.println("Expected: 2.00000");
        System.out.println("Output:   " + solver.findMedianSortedArrays(nums1, nums2));

        // Example 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("\n--- Test Case 2 ---");
        System.out.println("Expected: 2.50000");
        System.out.println("Output:   " + solver.findMedianSortedArrays(nums3, nums4));
    }
}

