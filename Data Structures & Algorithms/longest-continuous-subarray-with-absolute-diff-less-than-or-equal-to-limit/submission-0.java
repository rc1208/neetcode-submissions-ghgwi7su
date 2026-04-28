class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left =0;
        // int right=0;

        Deque<Integer> maxDeq = new ArrayDeque();
        Deque<Integer> minDeq = new ArrayDeque();

        int ans = Integer.MIN_VALUE;

        for (int right=0; right<nums.length; right++) {

            int num = nums[right];

            while (!maxDeq.isEmpty() && num > maxDeq.peekLast()) {
                maxDeq.removeLast();
            }

            maxDeq.addLast(num);

            while (!minDeq.isEmpty() && num < minDeq.peekLast()) {
                minDeq.removeLast();
            }

            minDeq.addLast(num);

            if (maxDeq.peekFirst() - minDeq.peekFirst() <= limit) {
                ans = Math.max(ans, right - left + 1);
            }

            while (maxDeq.peekFirst() - minDeq.peekFirst() > limit) {
                if (maxDeq.peekFirst() == nums[left]) maxDeq.removeFirst();
                if (minDeq.peekFirst() == nums[left]) minDeq.removeFirst();

                left++;
            }
        
        }

        return ans;
    }
}