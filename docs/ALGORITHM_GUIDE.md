# Algorithm guide

All three current solution files are covered here. These are independent
LeetCode-style snippets: each declares `public class Solution`, so compile them
separately under that filename rather than together as one Java application.
Costs use fixed-width Java arithmetic and exclude input storage.

## Exponentiation by squaring

Implementation: [`myPow`](../Leetcode/PowXN50.java).

```text
# Power / Binary Exponentiation
# Input: double x, int n
# Output: x raised to n, subject to floating-point behavior
# Time: O(log(|n|+1))
# Memory: O(1)

N = widen n to long
IF N < 0: x = 1/x; N = -N
result = 1
WHILE N > 0:
    IF low bit of N is set: result *= x
    x *= x
    N >>= 1
RETURN result
```

Widening before negation handles `Integer.MIN_VALUE`. An exponent of zero
returns 1. Floating-point overflow, underflow, NaN and division by zero follow
Java `double` behavior; this is not exact arbitrary-precision exponentiation.

## Kth-largest element

Implementation: [`findKthLargest`](../Leetcode/KthLargestElementInAnArray215.java).

```text
# Selection / Bounded Min-Heap
# Input: N integers, 1 <= K <= N
# Output: Kth-largest value, with duplicates counted
# Time: O(N * log(K+1))
# Memory: O(K), with at most K+1 entries during insertion

heap = empty min-heap
FOR each value:
    INSERT value
    IF heap size > K: REMOVE minimum
RETURN heap minimum
```

Invariant: after each iteration, the heap holds the K largest values seen so
far, or all values if fewer than K were seen. Invalid K and empty inputs are
not checked; null unboxing or an unintended result can occur.

## Minimum coin count

Implementation: [`coinChange`](../Leetcode/CoinChange332.java).

```text
# Coin Change / Bottom-Up Dynamic Programming
# Input: C positive integer denominations and nonnegative target A
# Output: minimum coin count, or -1 when unreachable
# Time: O(A*(C+1))
# Memory: O(A+1)

dp[0..A] = A+1; dp[0] = 0
FOR subtotal from 1 through A:
    FOR each coin:
        IF coin <= subtotal:
            dp[subtotal] = MIN(dp[subtotal], dp[subtotal-coin] + 1)
RETURN -1 if dp[A] is still sentinel, otherwise dp[A]
```

Each state depends on smaller subtotals for positive coins. Zero amount returns
0; duplicate denominations add work but do not change the recurrence. Negative
coins/amounts and integer-size limits are outside the contract. The filename's
`332` label is retained; this implementation is minimum coin change, not an
itinerary algorithm.
