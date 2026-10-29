package JavaLeetcodeSolutions;

import java.util.ArrayList;
import java.util.List;

class number{
    // Mapping array where index represents the digit character '0'-'9'
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Base case: if input is empty, return an empty list
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Start the recursive backtracking process
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder currentCombination, int index) {
        // If the current combination is of the same length as digits, we found a valid combination
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get the letters corresponding to the current digit character
        char digitChar = digits.charAt(index);
        String letters = KEYPAD[digitChar - '0'];

        // Loop through all letters mapped to the current digit
        for (int i = 0; i < letters.length(); i++) {
            // Choose: add the current character
            currentCombination.append(letters.charAt(i));

            // Explore: move to the next digit index
            backtrack(result, digits, currentCombination, index + 1);

            // Unchoose: backtrack by removing the last added character
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}

