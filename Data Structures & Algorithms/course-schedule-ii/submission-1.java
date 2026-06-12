class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDeg = new HashMap();
        Map<Integer, List<Integer>> neigh = new HashMap();

        for (int i=0; i<numCourses; i++) {
            inDeg.put(i, 0);
            neigh.put(i, new ArrayList());
        }

        for (int[] num: prerequisites) {
            int course = num[0];
            int prereq = num[1];

            inDeg.put(course, inDeg.getOrDefault(course, 0) + 1);

            List<Integer> l = neigh.get(prereq);
            l.add(course);
        }

        Deque<Integer> q = new ArrayDeque();

        for (int i=0; i<numCourses; i++) {
            if (inDeg.get(i) == 0) {
                q.addLast(i);
            }
        }

        List<Integer> ans = new ArrayList();

        
        int count=0;

        while (!q.isEmpty()) {
            Integer poppedCourse = q.removeFirst();
            count++;

           
            ans.add(poppedCourse);


            List<Integer> l = neigh.get(poppedCourse);

            for (int i=0; i< l.size(); i++) {
                int nextCourse = l.get(i);

                inDeg.put(nextCourse, inDeg.get(nextCourse) - 1);

                if (inDeg.get(nextCourse) == 0) {
                    q.addLast(nextCourse);
                }
            }

        }

        if (count != numCourses) {
            return new int[0];
        }

        int[] ansArr = new int[ans.size()];

        for (int i=0; i< ans.size(); i++) ansArr[i] = ans.get(i);

        return ansArr;
        
 
    }
}
