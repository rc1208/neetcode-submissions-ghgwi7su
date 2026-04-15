class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDeg = new HashMap();
        Map<Integer, List<Integer>> adjList = new HashMap();

        for (int i=0; i<numCourses;i++) {
            inDeg.put(i, 0);
            adjList.put(i, new ArrayList());
        }

        for (int i=0; i<prerequisites.length; i++) {
            int[] courseArr = prerequisites[i];
            int course = courseArr[0];
            int prereq = courseArr[1];

            inDeg.put(course, inDeg.get(course) + 1);

            List<Integer> list = adjList.get(prereq);
            list.add(course);
        }


        Deque<Integer> q = new LinkedList();

        for (int key: inDeg.keySet()) {
            if (inDeg.get(key) == 0) q.addLast(key);
        }

        int count=0;
        while (!q.isEmpty()) {
            int poppedCourse = q.removeFirst();
            System.out.println(poppedCourse);
            count++;

            List<Integer> neighbors = adjList.get(poppedCourse);

            for (int i=0; i<neighbors.size(); i++) {
                int neigh = neighbors.get(i);

                inDeg.put(neigh, inDeg.get(neigh) - 1);

                if (inDeg.get(neigh) == 0) q.addLast(neigh);
            }
        }

        return count == numCourses;

    }
}

// courses: 0,1
// 0 -> 1
// 1 -> 0


// courses: 0,1,2,3
//prereq = [[0,1], [2,1], [3,2], [3,0]]

// 0 -> 3
// 1 -> 0,2
// 2 -> 3
// 3 -> {}