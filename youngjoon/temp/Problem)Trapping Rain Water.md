Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

```cpp
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            // 왼쪽 벽이 오른쪽 벽보다 낮은 경우
            if (height[left] < height[right]) {
                // 현재 왼쪽 벽이 왼쪽 최대 높이보다 높으면 업데이트
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // 아니면 물을 채움
                    trappedWater += (leftMax - height[left]);
                }
                left++;
            }
            // 오른쪽 벽이 왼쪽 벽보다 낮거나 같은 경우
            else {
                // 현재 오른쪽 벽이 오른쪽 최대 높이보다 높으면 업데이트
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // 아니면 물을 채움
                    trappedWater += (rightMax - height[right]);
                }
                right--;
            }
        }

        return trappedWater;
    }
};
```