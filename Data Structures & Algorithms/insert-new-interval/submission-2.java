class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // if (intervals.length == 0) return new int[0][0];
        List<int[]> intervalsList = new ArrayList();

        boolean inserted = false;

        for (int i=0; i<intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0] && inserted == false) {
                intervalsList.add(newInterval);
                inserted = true;
            }

            intervalsList.add(intervals[i]);
        }

        if (inserted == false) intervalsList.add(newInterval);

        for (int i=0; i<intervalsList.size(); i++) {
            System.out.print(intervalsList.get(i)[0] + "." +  intervalsList.get(i)[1] + " ");
        }

        List<int[]> mergeList = new ArrayList();

        mergeList.add(intervalsList.get(0));

        for (int i=1; i<intervalsList.size(); i++) {
            int[] prevInterval = mergeList.get(mergeList.size() - 1);
            int[] currInterval = intervalsList.get(i);

            int[] mergeInterval = new int[2];

            if (prevInterval[1] >= currInterval[0]) {
                System.out.println("true" + prevInterval[0] + "." + prevInterval[1]);
                mergeList.remove(mergeList.size() - 1);
                mergeInterval[0] = Math.min(prevInterval[0], currInterval[0]);
                mergeInterval[1] = Math.max(prevInterval[1], currInterval[1]);
                
               
                mergeList.add(mergeInterval);
            } else {
                mergeList.add(currInterval);
            }
        }

        return mergeList.toArray(new int[0][]);
    }
}
