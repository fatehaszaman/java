// Power / Binary Exponentiation
// Time: O(log(|n|+1)); Memory: O(1), fixed-width Java arithmetic.
// Pseudocode: widen exponent, invert for negatives, multiply on set bits,
// square the base and halve the exponent until zero.
// Contract and edge cases: docs/ALGORITHM_GUIDE.md.

public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) { x = 1 / x; N = -N; }
        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) res *= x;
            x *= x;
            N >>= 1;
        }
        return res;
    }
}
