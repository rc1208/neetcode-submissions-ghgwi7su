class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0, right = nums.length-1;

        while (left<right) {
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;

            if (nums[mid] > target) right = mid-1;
            else left = mid+1;
        }

        return target > nums[left] ? left+1: left;
    }
}

/*
nums=[-1,0,2,4,6,8]
target=5


l=0,r=5
m=2

l=3,r=5
m=4

l=3,r=3


-----

nums=[1,3,5,7,9]
target=6

l=0,r=4
m=2

l=3,r=4
m=3

*/