class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<Integer> l = new ArrayList();
         findCombination(0, nums, 0, target, l);

        return ans;
    }

    public void findCombination(int index, int[] nums, int sum, int target, List<Integer> l) {
        if (target == sum) {
            List<Integer> copy = new ArrayList(l);
            ans.add(copy);
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i=index; i< nums.length; i++) {
            l.add(nums[i]);
            findCombination(i, nums, sum + nums[i], target, l);
            l.remove(l.size() - 1);
        }
     }
        
}
