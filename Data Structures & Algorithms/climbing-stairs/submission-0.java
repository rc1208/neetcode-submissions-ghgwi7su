class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap();
        // memo.put

        return findWaysToClimbStairs(n-1, memo);
        

        // return memo.get(n-1);
    }

    public int findWaysToClimbStairs(int index, Map<Integer, Integer> memo) {
        if (index == 0) return 1;
        if (index == 1) return 2;

        if (memo.containsKey(index)) return memo.get(index);

        int distinctWays = findWaysToClimbStairs(index - 1, memo) + findWaysToClimbStairs(index - 2, memo);

        memo.put(index, distinctWays);

        return memo.get(index);
    }
}
