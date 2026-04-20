class Solution {
    public int characterReplacement(String s, int k) {
       Map<Character, Integer> map = new HashMap();
       int start=0;
       int maxLen = Integer.MIN_VALUE;

       for (int end=0; end< s.length(); end++) {
            char endCh = s.charAt(end);
            map.put(endCh, map.getOrDefault(endCh, 0) + 1);
            // System.out.println(end +  " " +  "window=" + (end - start + 1 - getMax(map)));
            // for each window check if windowSize - largestCountChar > k. If it is, it's
            // time to shrink the window as the window is no longer valid
            while (end - start + 1 - getMax(map) > k) {
                char startCh = s.charAt(start);
                map.put(startCh, map.get(startCh) - 1);
                start++;
            }

            maxLen = Math.max(maxLen, end-start+1);
            // System.out.println(maxLen);

       } 

       return maxLen;
    }


    public int getMax(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE; 
        for (char key: map.keySet()) {
            if (map.get(key) > max) max = map.get(key);
        }

        return max;
    }
}
