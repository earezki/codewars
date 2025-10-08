package com.earezki.lfu;

import java.util.*;

class LFUCache {

    static private class Entry {
        int key;
        int value;
        int frequency;
        long lastAccessed;

        Entry(int key, int value, int frequency, long lastAccessed) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.lastAccessed = lastAccessed;
        }
    }

    private final int capacity;
    private final Map<Integer, Entry> cache = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        var entry = cache.get(key);

        if (entry == null) {
            return -1;
        }

        entry.frequency++;
        entry.lastAccessed = epoch();
        return entry.value;
    }
    
    public void put(int key, int value) {
        var current = cache.get(key);
        if (current != null) {
            current.value = value;
            current.frequency++;
            current.lastAccessed = epoch();

            return;
        }

        if (cache.size() >= capacity) {
            var maxHeap = new PriorityQueue<>(
                    Comparator.comparingInt((Entry e) -> e.frequency)
                            .thenComparing((Entry e) -> e.lastAccessed)
            );

            for (Entry entry : cache.values()) {
                maxHeap.offer(entry);
                if (maxHeap.size() > capacity) {
                    maxHeap.poll();
                }
            }

            while (maxHeap.size() >= capacity) {
                Entry polled = maxHeap.poll();
                cache.remove(
                        polled.key
                );
            }
        }

        cache.put(key, new Entry(key, value, 1, epoch()));
    }

    private long epoch() {
        return System.currentTimeMillis();
    }
}