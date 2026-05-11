class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remMap = new HashMap();
        int sumSoFar=0;

        // prefix sum for 1st element
        remMap.put(0, -1);

        for (int i=0; i< nums.length; i++) {
            sumSoFar += nums[i];

            if (remMap.containsKey(sumSoFar%k)) {
                int prevIndex = remMap.get(sumSoFar%k);

                if (i - prevIndex >= 2) return true;
            } else {
                 remMap.put(sumSoFar%k , i);
            }

           
        }

        return false;
    }
}