class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // top down
        Map<Integer, Integer> memo = new HashMap();

        return findMinCost(cost, cost.length, memo);
        
    }

    public int findMinCost(int[] cost, int index, Map<Integer, Integer> memo) {
        // cost of reaching to index 0 or index 1 is 0 because those are our starting indices
        if (index <= 1) return 0;

        if(memo.containsKey(index)) return memo.get(index);

        int minCost = Math.min(cost[index-1] + findMinCost(cost, index-1, memo),
         cost[index-2] + findMinCost(cost, index-2, memo));

        memo.put(index, minCost);

        return memo.get(index);
    }
}
