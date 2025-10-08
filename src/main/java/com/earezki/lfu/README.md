# Least Frequently Used (LFU) Cache

Design and implement a data structure for a Least Frequently Used (LFU) cache.

---

### `LFUCache` Class Implementation

Implement the `LFUCache` class with the following methods:

-   **`LFUCache(int capacity)`**: Initializes the object with the capacity of the data structure.

-   **`int get(int key)`**: Gets the value of the key if the key exists in the cache. Otherwise, returns -1.

-   **`void put(int key, int value)`**: Updates the value of the key if it is present, or inserts the key if it's not already present.

---

### Eviction Policy

When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.

*   **Use Counter**: To determine the least frequently used key, a use counter is maintained for each key. The key with the smallest use counter is the least frequently used.
*   **Tie-Breaking**: When there is a tie (i.e., two or more keys with the same frequency), the **least recently used** key will be invalidated.

### Use Counter Logic

*   When a key is first inserted, its use counter is set to **1**.
*   The use counter for a key is incremented when either a `get` or `put` operation is called on it.

### Time Complexity Requirement

The `get` and `put` functions must each run in **O(1)** average time complexity.

---

### Example

**Input:**
```
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
```

**Output:**
```
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
```

**Explanation:**

```
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost is most recent)

LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(1)=2, cnt(2)=1
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest. Invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU. Invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(3)=3, cnt(4)=1
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
```