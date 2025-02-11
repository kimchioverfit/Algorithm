# [문제](https://leetcode.com/problems/lru-cache/description/)

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- `LRUCache(int capacity)` Initialize the LRU cache with positive size capacity.
- `int get(int key)` Return the value of the key if the key exists, otherwise return -1.
- `void put(int key, int value)` Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.


The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
> ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
> 
> [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output
> [null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation

> LRUCache lRUCache = new LRUCache(2);
> 
> lRUCache.put(1, 1); // cache is {1=1}
> 
> lRUCache.put(2, 2); // cache is {1=1, 2=2}
> 
> lRUCache.get(1);    // return 1
> 
> lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
> 
> lRUCache.get(2);    // returns -1 (not found)
> 
> lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
> 
> lRUCache.get(1);    // return -1 (not found)
> 
> lRUCache.get(3);    // return 3
> 
> lRUCache.get(4);    // return 4

# 풀이
LRU 캐시를 구현하는 문제이다

map에는 put으로 입력받은 key-value를 매핑해주었고, pq에 key와 마지막으로 접근한 시간을 각각 저장해주었다.

put이나 get으로 key에 접근할 때마다 PQ에 우선순위를 업데이트해줘서 
-> 이 부분에서 시간이 오래 걸렸는데, 좀 더 좋은 방법이 생각이 안 난다

capacity를 초과할 때는 pq의 top에 있는 원소를 삭제했다
