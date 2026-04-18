class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return findMinCoins(coins, amount);
    }

    public int findMinCoins(int[] coins, int amount) {
        // System.out.println(amount);
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (map.containsKey(amount)) return map.get(amount);
        int minValue = Integer.MAX_VALUE;

        for (int i=0; i< coins.length; i++) {
                int change = findMinCoins(coins, amount - coins[i]);
                if (change == -1) {
                    continue;
                }
                minValue = Math.min(minValue, change);
                map.put(amount, minValue);
            
        }

        if (minValue == Integer.MAX_VALUE) {
            map.put(amount, -1);
            return -1;
        } 

        map.put(amount, 1+minValue);
        return 1 + minValue;
    }
}