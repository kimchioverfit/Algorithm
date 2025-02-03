
### Priority Queue

Input:
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output: [null, 4, 5, 5, 8, 8]

```cpp
class KthLargest {
public:
    priority_queue<int> pq;  // 기본적으로 max-pq 사용
    int temp = 0;

    KthLargest(int k, vector<int>& nums) {
        temp = k;
        for (int num : nums) {
            add(num);
        }
    }

    int add(int val) {
        pq.push(-val); // 값을 음수로 변환하여 삽입 (최소 힙처럼 동작)
        // PQ에서는 sort할 필요없이 자동으로 정렬해준다. 기본적으로 작은값이 위로감
        
        // 힙의 크기가 k를 초과하면 가장 작은 값을 제거
        if (pq.size() > temp) {
            pq.pop();
        }

        // k번째로 큰 값 반환 (음수로 저장했으므로 다시 양수로 변환)
        return -pq.top();
    }
};
```