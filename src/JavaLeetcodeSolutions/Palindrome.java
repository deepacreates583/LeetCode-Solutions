package JavaLeetcodeSolutions;

public class Palindrome {

    // Core function to determine if a number is a palindrome
    public boolean isPalindrome(int x) {
        // Special cases:
        // Negative numbers are not palindromes
        // If the last digit is 0, the first digit must also be 0 (only '0' satisfies this)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse the second half of the number
        while (x > reversedHalf) {
            reversedHalf = (reversedHalf * 10) + (x % 10);
            x /= 10;
        }

        // Check if x matches the reversed half
        return x == reversedHalf || x == reversedHalf / 10;
    }

    // Main function to run and test the solution
    public static void main(String[] args) {
        Palindrome solver = new Palindrome();

        // Test Case 1: Positive Palindrome
        int test1 = 121;
        System.out.println("Input:  x = " + test1);
        System.out.println("Output: " + solver.isPalindrome(test1) + "\n");

        // Test Case 2: Negative Number
        int test2 = -121;
        System.out.println("Input:  x = " + test2);
        System.out.println("Output: " + solver.isPalindrome(test2) + "\n");

        // Test Case 3: Ends in Zero
        int test3 = 10;
        System.out.println("Input:  x = " + test3);
        System.out.println("Output: " + solver.isPalindrome(test3) + "\n");

        // Test Case 4: Zero itself
        int test4 = 0;
        System.out.println("Input:  x = " + test4);
        System.out.println("Output: " + solver.isPalindrome(test4));
    }
}
