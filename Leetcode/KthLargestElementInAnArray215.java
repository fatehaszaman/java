// Leetcode question number 215
// Bounded Min-Heap / Keep the K largest values encountered.
// Time: O(N*log(K+1)); Memory: O(K); requires 1 <= K <= N.
// Pseudocode: offer each value, remove minimum when oversized, return minimum.
// Duplicates count separately. See docs/ALGORITHM_GUIDE.md.
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
