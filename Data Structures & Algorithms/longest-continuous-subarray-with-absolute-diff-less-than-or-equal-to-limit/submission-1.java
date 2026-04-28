class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left =0;
        // int right=0;

        Deque<Integer> maxDeq = new ArrayDeque();
        Deque<Integer> minDeq = new ArrayDeque();

        int ans = Integer.MIN_VALUE;

        for (int right=0; right<nums.length; right++) {

            int num = nums[right];
            // keep on popping from right of maxQ if num is greater
            while (!maxDeq.isEmpty() && num > maxDeq.peekLast()) {
                maxDeq.removeLast();
            }

            maxDeq.addLast(num);

            // keep on popping from right of minQ if num is smaller
            while (!minDeq.isEmpty() && num < minDeq.peekLast()) {
                minDeq.removeLast();
            }

            minDeq.addLast(num);
            // if constraint holds, record the answer
            if (maxDeq.peekFirst() - minDeq.peekFirst() <= limit) {
                ans = Math.max(ans, right - left + 1);
            }
            // we move the left pointer when there is constraint violation
            // (diff btw max and min becoming greater than limit)
            // we do this because currently in our window we have max and min
            // which are causing the constraint violation and if we
            // move left pointer, that's our only hope to perhaps remove 
            // these either the max or the min which are causing the constraint violation
            // and bring back the window to adhere to the constraint
            // Right pointer only moves when the constraint holds
            while (maxDeq.peekFirst() - minDeq.peekFirst() > limit) {
                if (maxDeq.peekFirst() == nums[left]) maxDeq.removeFirst();
                if (minDeq.peekFirst() == nums[left]) minDeq.removeFirst();

                left++;
            }
        
        }

        return ans;
    }
}