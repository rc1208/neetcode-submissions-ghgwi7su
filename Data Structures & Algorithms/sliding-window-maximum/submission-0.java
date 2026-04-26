class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deq = new ArrayDeque();
        
        int left = 0;
        int right = 0;
        int i = 0;


        while (right < nums.length) {
            int num = nums[right];

            while (!deq.isEmpty() && num > nums[deq.peekLast()]) {
                // System.out.println("removing=" + nums[deq.peekLast()]);
                deq.removeLast();
            }

            deq.addLast(right);

            if (right - left + 1 == k) {
                // System.out.println(right + " " + deq.peekFirst());
                ans[i++] = nums[deq.peekFirst()];
                left++;
                if (!deq.isEmpty() && deq.peekFirst() < left) {
                    deq.removeFirst();
                }
            }

            right++;
        }

        return ans;
    }
}
