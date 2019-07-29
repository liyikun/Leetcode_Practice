package Leetcode.No146;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map ;
    public LRUCache(int capacity) {
        map = new <Integer, Integer>LinkedHashMap() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key);
        map.remove(key);
        this.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }
        map.put(key, value);
    }
}
