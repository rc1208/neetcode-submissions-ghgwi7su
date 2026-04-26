class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length-k+1];
        // monontically decreasing queue
        Deque<Integer> deq = new ArrayDeque();
        
        int left = 0;
        int right = 0;
        int i = 0;


        while (right < nums.length) {
            int num = nums[right];

            // remove elements that are smaller than nums[right] in deque
            // because they are not relevant anymore as nums[right] is the larger value
            while (!deq.isEmpty() && num > nums[deq.peekLast()]) {
                deq.removeLast();
            }

            deq.addLast(right);
            //once we build the window of size k, time to add to ans and also increment left pointer
            if (right - left + 1 == k) {
                // System.out.println(right + " " + deq.peekFirst());
                ans[i++] = nums[deq.peekFirst()];
                left++;
                // check whether when moving the left pointer, we lose the left most largest value
                if (!deq.isEmpty() && deq.peekFirst() < left) {
                    deq.removeFirst();
                }
            }

            right++;
        }

        return ans;
    }
}
