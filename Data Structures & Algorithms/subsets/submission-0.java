class Solution {

    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        
        doSubsets(nums, new ArrayList(), 0);
        return ans;
    }

    public void doSubsets(int[] nums, List<Integer> l, int index) {
        if (index == nums.length) {
            List<Integer> copy = List.copyOf(l);
            ans.add(copy);
            return;
        } 
        // take decision to add element at index i
        l.add(nums[index]);
        doSubsets(nums, l, index+1);
        // take decision to exclude element at index i
        //
        l.remove(l.size() - 1);
        doSubsets(nums, l, index+1);

        
    }
}
