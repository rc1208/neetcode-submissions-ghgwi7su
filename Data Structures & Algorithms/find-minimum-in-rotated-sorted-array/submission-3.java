class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int start=0,end=nums.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            System.out.println(mid);

            if (nums[mid] > nums[mid+1]) return nums[mid+1];

            if (nums[start] <= nums[mid]) start = mid;
            else end = mid;
        }

        return -1;
    }
}
