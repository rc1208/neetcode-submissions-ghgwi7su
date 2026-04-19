class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap();
        return findNoOfCoins(coins, amount, memo);
    }

    public int findNoOfCoins(int[] coins, int amount,  Map<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo.containsKey(amount)) return memo.get(amount);
        int min = Integer.MAX_VALUE;
        for (int i=0; i< coins.length; i++) {
            int minAmount = findNoOfCoins(coins, amount - coins[i], memo);
            if (minAmount == -1) continue;
            min = Math.min(min, minAmount);
        }

        if (min == Integer.MAX_VALUE) {
            memo.put(amount, -1);
        } else {
            memo.put(amount, min+1);
        }

        


        return memo.get(amount);
    }
}
