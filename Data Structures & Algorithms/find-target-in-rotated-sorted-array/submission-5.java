class Solution {
    public int search(int[] nums, int target) {

       if (nums.length == 1) {
        if (nums[0] == target) return 0;
        else return -1;
       }

       
       int start = 0, end = nums.length - 1;


       while (start <= end) {
            
            int mid = start + (end - start)/2;
            System.out.println(mid);
            if (nums[mid] == target) return mid;
            // first half is sorted
            if (nums[start] <= nums[mid]) {
                System.out.println("first half");
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //second half is sorted
                System.out.println("second half");
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
       }

       return -1;

    }
}
