class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMapCount = new HashMap();
        // prefixMapCount.put(0, 1);

        int prefix = 0;
        int ans=0;
        int sum=0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            prefixMapCount.put(prefix, prefixMapCount.getOrDefault(prefix, 0) + 1);
            prefix = prefix + nums[i];

            if(prefixMapCount.containsKey(sum - k)) {
                ans += prefixMapCount.get(sum-k);
            }
        }


        return ans;
    }
}