`Climbing Stairs'

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

```cpp
class Solution {
public:
    vector<int> v;
    int climbStairs(int n) {
        v.resize(n + 1);
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                v[i] = 0;
            } else if (i == 1) {
                v[i] = 1;
            } else if (i == 2) {
                v[i] = 2;
            } else {
                v[i] = v[i - 1] + v[i - 2];
            }
        }
        
        return v[n];
    }
};
```


`Pascal's triangle'

```cpp
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> v;

        for (int i = 0; i < numRows; i++) {
            vector<int> temp(i + 1, 1);  // i + 1 크기로 벡터 초기화, 모든 값은 1로 설정

            // 중간 값을 계산
            for (int j = 1; j < i; j++) {
                temp[j] = v[i - 1][j - 1] + v[i - 1][j];
            }

            v.push_back(temp);  // 벡터에 temp 추가
        }
        
        return v;
    }
};
```

