994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

```cpp
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        queue<pair<int, int>> q; // 좌표 저장용
        int freshOranges = 0; // 신선한 오렌지를 지표로 쓸거임
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2) q.push(make_pair(i,j));
                //시작부터 썩어있는 좌표를 queue안에 넣는다.
                //나중에 이 큐를 이용해서 초기 접근할거임.
            }
        }
        // 썩은 오렌지가 없고 신선한 오렌지가 없는 경우
        if (freshOranges == 0) return 0;
        vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        //여기까지가 초기 설정 

        while (!q.empty()) {
            int size = q.size();
            bool rotted = false;

            for (int i = 0; i < size; ++i) {
                auto [x, y] = q.front();
                q.pop();

                // 4방향 탐색 // directions 이용해서 깔끔하게 접근하는 방법 외워두기
                for (auto [dx, dy] : directions) {
                    int nx = x + dx;
                    int ny = y + dy;

                    // 유효한 위치인지 확인하고, 신선한 오렌지를 썩게 만듦
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // 썩음으로 변경
                        q.push({nx, ny});
                        freshOranges--;
                        rotted = true;
                    }
                }
            }

            // 만약 썩은 오렌지가 있었다면 시간 증가
            if (rotted) minutes++;
        }

        // 신선한 오렌지가 남아 있다면 -1 반환, 아니면 걸린 시간 반환
        return freshOranges == 0 ? minutes : -1;

    }
};
```