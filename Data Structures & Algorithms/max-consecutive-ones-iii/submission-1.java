class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int maxLen = 0;

        while (r<nums.length) {
            if(nums[r] == 0) k--;

            if (k >= 0) {
                maxLen = Math.max(maxLen, r-l+1);
            }

            while (k < 0) {
                if(nums[l] == 0) k++;
                l++;
            }

 
            r++;
        }

        return maxLen;
 
    }
}

/*
while (r<len):
 if nums[r] == 0 k--;

 if (k >= 0) maxLen -> max(maxLen, windowS)

 while (k < 0) {
    if nums[l] == 0 k++
    l++;
 }
 r++;
 


*/