class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        // int maxTarget = Integer.MIN_VALUE;
        for (int i=0; i< nums.length; i++) {
            int sumSoFar = 0;
            for (int j=i; j< nums.length; j++) {
                sumSoFar += nums[j];
                // System.out.println(sumSoFar);
                // System.out.println(minLen < j-i+1);
                // System.out.println(maxTarget < sumSoFar);

                if(sumSoFar >= target) {
                    // System.out.println("true + " + i + " " + j);
                    minLen = Math.min(minLen, j-i+1);
                    // maxTarget = sumSoFar;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }
}


/*
find all subarrays 
find sum
compare w/ target, keep track of min len if sum >= target
return min len

2
2 1
2 1 5



*/