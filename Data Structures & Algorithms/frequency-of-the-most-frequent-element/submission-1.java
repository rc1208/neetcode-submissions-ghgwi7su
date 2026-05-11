class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left=0;
        int right=0;
        int sumSoFar =0;
        int max = Integer.MIN_VALUE;

        while (right < nums.length) {
            
            sumSoFar += nums[right];
            while (nums[right]*(right - left + 1) > sumSoFar + k && left<nums.length) {
                sumSoFar -= nums[left];
                left++;
            }
        
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}