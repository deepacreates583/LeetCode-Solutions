package JavaLeetcodeSolutions;

public class Multiplestrings {
        public String multiply(String num1, String num2) {
            // Handle edge case where either number is zero
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int m = num1.length();
            int n = num2.length();
            // The maximum possible length of the product is m + n
            int[] result = new int[m + n];

            // Multiply each digit from right to left
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                    // Indices in the result array where the digits belong
                    int p1 = i + j;
                    int p2 = i + j + 1;

                    // Add to the current value at this position
                    int sum = mul + result[p2];

                    result[p2] = sum % 10;
                    result[p1] += sum / 10;
                }
            }

            // Build the final string, skipping leading zeros
            StringBuilder sb = new StringBuilder();
            for (int digit : result) {
                if (!(sb.length() == 0 && digit == 0)) {
                    sb.append(digit);
                }
            }

            return sb.toString();
        }

        // Main method to easily execute and test the code inside IntelliJ
        public static void main(String[] args) {
            Solution solver = new Solution();

            // Test case 1
            String num1 = "123";
            String num2 = "456";
            System.out.println("Product of " + num1 + " and " + num2 + " is: " + solver.multiply(num1, num2));

            // Test case 2
            System.out.println("Product of \"2\" and \"3\" is: " + solver.multiply("2", "3"));
        }
    }


