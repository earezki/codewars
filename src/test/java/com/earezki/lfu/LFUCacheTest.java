package com.earezki.lfu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    @Test
    void test_x1() {
        //["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
        //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
        //Output
        //[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
        LFUCache sut = new LFUCache(2);

        sut.put(1, 1);
        sut.put(2, 2);

        assertEquals(1, sut.get(1));

        sut.put(3, 3);

        assertEquals(-1, sut.get(2));
        assertEquals(3, sut.get(3));

        sut.put(4, 4);

        assertEquals(-1, sut.get(1));
        assertEquals(3, sut.get(3));
        assertEquals(4, sut.get(4));
    }

    @Test
    void test_x2() {
        //["LFUCache","put","put","put","put","get"]
        //[[2],[3,1],[2,1],[2,2],[4,4],[2]]
        //Output
        //[null,null,null,null,null,2]
        LFUCache sut = new LFUCache(2);
        sut.put(3, 1);
        sut.put(2, 1);
        sut.put(2, 2);
        sut.put(4, 4);
        assertEquals(2, sut.get(2));
    }

}