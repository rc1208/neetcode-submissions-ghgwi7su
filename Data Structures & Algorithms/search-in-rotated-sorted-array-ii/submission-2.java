class Solution {
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            System.out.println("l=" + left + "r=" + right + "m=" + mid);

            if (nums[mid] == target) return true;

            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]){
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++; //case when nums[left] == nums[mid] == nums[right]
            }
        }

        return false;
    }
}

/*
nums = [3,4,4,5,6,1,2,2], target = 1
l=0, r=7, m=3
l=4, r=7, m=5


nums= [6,1,2,3,4,5] t=5


nums=[1,0,1,1,1]
target=0
l=0 r=4 
*/