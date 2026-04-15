class TimeMap {
    Map<String, List<Point>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            List<Point> l = map.get(key);
            Point newPoint = new Point(value, timestamp);
            l.add(newPoint);
        } else {
            List<Point> l = new ArrayList();
            Point newPoint = new Point(value, timestamp);
            l.add(newPoint);
            map.put(key, l);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Point> l = map.get(key);
        int left = 0; int right = l.size() - 1; 

        System.out.println(l.size());

        String result = "";

        while (left <= right) {
            int mid = (left + right)/2;

            if (l.get(mid).timestamp <= timestamp) {
                result = l.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
                
            }
        }

        return result;
    }
}

class Point {
    String value;
    int timestamp;

    public Point(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

// alice -> [("happy", 1), ("sad", 2),  ("s",p), ("d", 5), ("d", 8), ("d", 9)]
// get(alice, 5) -> sad
