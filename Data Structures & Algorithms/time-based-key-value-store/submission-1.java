class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap treeMap = map.get(key);
            treeMap.put(timestamp, value);
        } else {
            TreeMap treeMap = new TreeMap();
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }
    }
    
    public String get(String key, int timestamp) {
         if (!map.containsKey(key)) return "";
         TreeMap<Integer, String> treeMap = map.get(key);

         Integer floorKey = treeMap.floorKey(timestamp);

         if (floorKey == null) {
            return "";
         } else {
            return treeMap.get(floorKey);
         }
    }
}


// alice -> [("happy", 1), ("sad", 2),   ("d", 5)]
// get(alice, 4) -> sad
// 