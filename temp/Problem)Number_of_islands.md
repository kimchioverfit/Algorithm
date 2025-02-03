200. Number of Islands
Solved
Medium
Topics
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


```cpp
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty() || grid[0].empty()) return 0;

        int rows = grid.size();
        int cols = grid[0].size();
        int num_islands = 0;

        // 방향 벡터: 상, 하, 좌, 우
        vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    // 새로운 섬 발견
                    ++num_islands;
                    grid[i][j] = '0'; // 방문 표시 (땅을 물로 바꿈)

                    // BFS를 위한 큐 초기화
                    queue<pair<int, int>> q;
                    q.push({i, j});

                    while (!q.empty()) {
                        auto [cur_row, cur_col] = q.front();
                        q.pop();

                        // 현재 위치에서 상하좌우 탐색
                        for (auto [dr, dc] : directions) {
                            int new_row = cur_row + dr;
                            int new_col = cur_col + dc;

                            // 유효한 범위 내에 있고, 땅('1')인 경우
                            if (new_row >= 0 && new_row < rows &&
                                new_col >= 0 && new_col < cols &&
                                grid[new_row][new_col] == '1') {
                                grid[new_row][new_col] = '0'; // 방문 처리
                                q.push({new_row, new_col});
                            }
                        }
                    }
                }
            }
        }

        return num_islands;
    }
};
```