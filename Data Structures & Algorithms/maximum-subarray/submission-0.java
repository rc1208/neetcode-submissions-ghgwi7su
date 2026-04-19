class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int right=1; right < nums.length; right++) {
            if (currSum < 0) currSum = 0; //if prefix is -ve, don't add it, instead make it 0

            currSum += nums[right];

            maxSum = Math.max(maxSum, currSum);

        }


        return maxSum;
    }
}
