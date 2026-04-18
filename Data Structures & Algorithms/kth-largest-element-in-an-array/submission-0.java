class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for (int n: nums) pq.add(n);

        int count = 1;
        while (true) {
            if (k == count) return pq.peek();

            pq.poll();
            count++;
        }


        // return -1;
    }
}
