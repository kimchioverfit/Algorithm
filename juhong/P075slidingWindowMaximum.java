/** https://leetcode.com/problems/sliding-window-maximum/
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        QueueWithMax<Integer> queue = new QueueWithMax<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);

            if (i < k - 1) {
                continue;
            }
            result[i - k + 1] = queue.getMax();
            queue.poll();
        }

        return result;
    }
}

public class QueueWithMax<T extends Comparable<T>> {
    Queue<T> queue;
    Deque<T> cMax; // candidates for Max value

    public QueueWithMax() {
        queue = new LinkedList<>();
        cMax = new LinkedList<>();
    }

    public void offer(T element) {
        queue.offer(element);
        while (!cMax.isEmpty() && element.compareTo(cMax.peekLast()) > 0) {
            cMax.pollLast();
        }
        cMax.offerLast(element);
    }

    public T poll() {
        if (cMax.peekFirst().equals(queue.peek())) {
            cMax.pollFirst();
        }
        return queue.poll();
    }

    public T getMax() {
        return cMax.peekFirst();
    }
}