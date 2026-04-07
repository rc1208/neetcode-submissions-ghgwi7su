class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        // map: { 3: 0, 4: 1, 5: 2}
        int[] ans = new int[2];

        for (int i=0; i< nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
              
                return ans;
            }

            map.put(nums[i], i);
        }

        return ans;
    }
}
