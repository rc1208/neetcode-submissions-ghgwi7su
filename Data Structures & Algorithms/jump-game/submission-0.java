class Solution {
    public boolean canJump(int[] nums) {

        if (nums.length == 1) return true;
        int goal = nums.length-1;

        for (int i=nums.length-2; i>=0; i--) {
            int jump = nums[i];

            if (jump + i >= goal) goal = i;
        }

        return  (goal == 0) ? true : false;
    }
}
