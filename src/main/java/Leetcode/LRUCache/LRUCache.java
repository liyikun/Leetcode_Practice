package Leetcode.LRUCache;


import com.sun.javafx.image.IntPixelGetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map ;
    public LRUCache(int capacity) {
        map = new <Integer, Integer>LinkedHashMap(capacity) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}
