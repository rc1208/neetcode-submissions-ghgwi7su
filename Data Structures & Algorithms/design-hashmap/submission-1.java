class MyHashMap {
    int capacity;
    List<Bucket> hashTable;
    public MyHashMap() {
        capacity = 2069;
        hashTable = new ArrayList();

        for (int i=0; i<2069; i++) {
            hashTable.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int index = key%capacity;
        Bucket bucket = hashTable.get(index);
        bucket.add(key, value);

    }
    
    public int get(int key) {
        int index = key%capacity;
        Bucket bucket = hashTable.get(index);
        return bucket.get(key);
    }
    
    public void remove(int key) {
        int index = key%capacity;
        Bucket bucket = hashTable.get(index);
        bucket.remove(key);
    }
}

class Bucket {
    List<Data> bucket;

    public Bucket() {
        bucket = new ArrayList();
    }

    public void add(int key, int value) {

        for (int i=0; i< bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.get(i).value = value;
                return;
            }
        }

        bucket.add(new Data(key, value));
    }

    public int get(int key) {

        for (int i=0; i< bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                return bucket.get(i).value;
            }
        }

        return -1;
    }

    public void remove(int key) {

        for (int i=0; i< bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
            }
        }
    }
}

class Data {
    int key;
    int value;

    public Data(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */