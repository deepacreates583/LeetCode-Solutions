package JavaLeetcodeSolutions;

public class CountAndSay  {

    public String countAndSay(int n) {
        // Base case
        if (n <= 0) {
            return "";
        }

        String currentString = "1";

        // Iteratively generate the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder nextString = new StringBuilder();
            int count = 1;

            // Traverse the current string to perform Run-Length Encoding (RLE)
            for (int j = 1; j < currentString.length(); j++) {
                if (currentString.charAt(j) == currentString.charAt(j - 1)) {
                    count++;
                } else {
                    nextString.append(count).append(currentString.charAt(j - 1));
                    count = 1; // Reset counter for the new character
                }
            }
            // Append the last character group
            nextString.append(count).append(currentString.charAt(currentString.length() - 1));
            currentString = nextString.toString();
        }

        return currentString;
    }

    // Main method to run and test the code in IntelliJ
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case from the problem description (n = 4)
        int testN = 4;
        String result;
        result = solution(testN);

        System.out.println("Input: n = " + testN);
        System.out.println("Output: \"" + result + "\"");
    }

    private static String solution(int testN) {
        return (" ");
    }
}
