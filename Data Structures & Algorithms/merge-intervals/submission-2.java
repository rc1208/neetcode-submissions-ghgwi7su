class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList();

        for (int i=0; i< intervals.length; i++) {
            int[] currInterval = intervals[i];
            int currStart = currInterval[0];
            int currEnd = currInterval[1];

            if (ans.size() == 0) {
                ans.add(currInterval);
                continue;
            }

            int[] lastElem = ans.get(ans.size() - 1);

            if (lastElem[1] >= currStart) {
                int[] newInterval = new int[]{lastElem[0], Math.max(lastElem[1], currEnd)};
                ans.remove(ans.size() - 1);
                ans.add(newInterval);
            } else {
                ans.add(currInterval);
            }

        }

        return ans.toArray(int[][]::new);
    }
}
