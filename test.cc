#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int trap(vector<int>& height) {
    int n = height.size();
    if (n == 0) return 0; // 빈 배열이면 0 반환

    // 왼쪽 최대 높이를 저장하는 배열
    vector<int> leftMax(n, 0);
    // 오른쪽 최대 높이를 저장하는 배열
    vector<int> rightMax(n, 0);

    // 왼쪽 최대 높이 계산
    leftMax[0] = height[0];
    for (int i = 1; i < n; ++i) {
        leftMax[i] = max(leftMax[i - 1], height[i]);
    }

    // 오른쪽 최대 높이 계산
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; --i) {
        rightMax[i] = max(rightMax[i + 1], height[i]);
    }

    // 각 인덱스에서 물의 양 계산
    int totalWater = 0;
    for (int i = 0; i < n; ++i) {
        int waterAtCurrent = min(leftMax[i], rightMax[i]) - height[i];
        if (waterAtCurrent > 0) {
            totalWater += waterAtCurrent;
        }
    }

    return totalWater;
}

int main() {
    // 예제 입력
    vector<int> height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    
    // 결과 출력
    cout << "Trapped Water: " << trap(height) << endl;

    return 0;
}
