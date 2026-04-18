class Solution {
    public int rob(int[] nums) {
        // top-down approach
        Map<Integer, Integer> memo = new HashMap();

        if (nums.length == 0) return 0;

        
        findMaxRob(nums, nums.length - 1, memo);

        return memo.get(nums.length - 1);
    }

    public int findMaxRob(int[] nums, int index, Map<Integer, Integer> memo) {
        if (index == 0) {
            memo.put(0, nums[0]);
            return nums[0];
        }

        if (index == 1) {
            memo.put(1, Math.max(nums[0], nums[1]));
            return memo.get(1);
        }

        if (memo.containsKey(index)) return memo.get(index);

        int maxRob = Math.max(findMaxRob(nums, index-1, memo),
         nums[index] + findMaxRob(nums, index-2, memo));

        memo.put(index, maxRob);

        return memo.get(index);
    }
}
