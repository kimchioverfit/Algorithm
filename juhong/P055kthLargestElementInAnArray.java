class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        for (int num : nums) {
            pq.offer(num);
        }

        int cnt = 0;
        while (cnt++ < k) {
            result = pq.poll();
        }
        return result;
    }
}