package JavaLeetcodeSolutions;

import java.util.*;

class solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 1. Sort the array first

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) {
                    left++; // Sum too small, move left pointer right
                } else {
                    right--; // Sum too large, move right pointer left
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        System.out.println("Ex 1: " + sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Example 2
        System.out.println("Ex 2: " + sol.threeSum(new int[]{0, 1, 1}));
        // Expected: []

        // Example 3
        System.out.println("Ex 3: " + sol.threeSum(new int[]{0, 0, 0}));
        // Expected: [[0, 0, 0]]
    }
}

