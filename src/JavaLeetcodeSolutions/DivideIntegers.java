package JavaLeetcodeSolutions;

public class DivideIntegers {
    class Solution {
        public int divide(int dividend, int divisor) {
            // Handle the specific 32-bit signed integer overflow edge case
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            // Determine if the final quotient should be negative
            boolean isNegative = (dividend < 0) ^ (divisor < 0);

            // Convert both numbers to negative to prevent overflow issues
            // (Math.abs(Integer.MIN_VALUE) overflows a positive 32-bit int)
            int negDividend = dividend < 0 ? dividend : -dividend;
            int negDivisor = divisor < 0 ? divisor : -divisor;

            int quotient = 0;

            // Since numbers are negative, negDividend <= negDivisor means |dividend| >= |divisor|
            while (negDividend <= negDivisor) {
                int currentDivisor = negDivisor;
                int numDoubles = 1;

                // Double the divisor using bitwise left-shift until it exceeds the remaining dividend.
                // Check (Integer.MIN_VALUE >> 1) to prevent overflow during the shift operation.
                while (currentDivisor >= (Integer.MIN_VALUE >> 1) && negDividend <= (currentDivisor << 1)) {
                    currentDivisor <<= 1;
                    numDoubles <<= 1;
                }

                // Subtract the largest accumulated multiple from the dividend
                negDividend -= currentDivisor;
                quotient += numDoubles;
            }

            // Apply the correct sign to the calculated quotient
            return isNegative ? -quotient : quotient;
        }
    }

}
