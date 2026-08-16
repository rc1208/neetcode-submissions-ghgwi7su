class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> inDeg = new HashMap();
        Map<Integer, Integer> outDeg = new HashMap();

        for (int i=0; i< trust.length; i++) {
            int src = trust[i][0];
            int dest = trust[i][1];

            inDeg.put(dest, inDeg.getOrDefault(dest , 0) + 1);
            outDeg.put(src, outDeg.getOrDefault(src , 0) + 1);
        }

        for (int key: inDeg.keySet()) {
            int inDegree = inDeg.get(key);
            if (inDegree == n-1) {
                if (outDeg.containsKey(key)) continue;
                else return key;
            } 
        }

        return -1;
    }
}