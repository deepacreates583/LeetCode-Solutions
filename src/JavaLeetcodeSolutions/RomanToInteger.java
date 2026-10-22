package JavaLeetcodeSolutions;

import java.util.HashMap;
import java.util.Map;

public class romantoInteger{
    public int romanToInt(String s) {
        // Map to store the integer value of each Roman numeral symbol
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentVal = romanMap.get(s.charAt(i));

            // If the current value is less than the next value, subtract it (e.g., IV -> -1 + 5 = 4)
            if (i < length - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }

        return total;
    }

    // Main method to execute and test the code in IntelliJ
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test examples
        String test1 = "III";
        String test2 = "LVIII";
        String test3 = "MCMXCIV";

        System.out.println(test1 + " -> " + solution.romanToInt(test1)); // Expected: 3
        System.out.println(test2 + " -> " + solution.romanToInt(test2)); // Expected: 58
        System.out.println(test3 + " -> " + solution.romanToInt(test3)); // Expected: 1994
    }
}
public static void main(String[] args) {
    return (" ");
}
