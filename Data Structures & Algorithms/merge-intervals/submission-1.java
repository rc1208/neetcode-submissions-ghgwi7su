class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> mergeList = new ArrayList();
        mergeList.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            int[] prev = mergeList.get(mergeList.size() - 1);
            int[] current = intervals[i];
            if (prev[1] >= current[0]) {
                mergeList.remove(mergeList.size() - 1);
                int[] merge = new int[2];
                merge[0] = Math.min(prev[0], current[0]);
                merge[1] = Math.max(prev[1], current[1]);
                mergeList.add(merge);
            } else {
                mergeList.add(current);
            }
        }


        return mergeList.toArray(int[][]::new);
    }
}
