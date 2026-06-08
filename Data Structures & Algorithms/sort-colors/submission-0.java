class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int j=0;
        for (int i=0; i<=2; i++) {
            if (map.containsKey(i)) {
                int size = map.get(i);
                for (int k=1; k<=size; k++) {
                    nums[j++] = i;
                }
            }
        }
    }
}