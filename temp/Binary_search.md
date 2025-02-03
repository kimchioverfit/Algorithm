### Binary Search

```cpp
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
};
```

Sorting 되어있다는 가정하에 쓸모가있음.

중간지점 선택 후 
1. target과 같은지 확인 (같다면 바로 return)
2. target보다 mid에서의 값이 작다면 left를 mid+1로 수정.
3. target보다 mid에서의 값이 크다면 right를 mid-1로 수정 


`삽입위치 찾기`

```cpp
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
};
```

### 

```cpp
double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    if (nums1.size() > nums2.size()) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    int x = nums1.size();
    int y = nums2.size();
    
    int low = 0, high = x;
    
    while (low <= high) {
        int partitionX = (low + high) / 2;
        int partitionY = (x + y + 1) / 2 - partitionX;
        
        int maxX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
        int minX = (partitionX == x) ? INT_MAX : nums1[partitionX];
        
        int maxY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
        int minY = (partitionY == y) ? INT_MAX : nums2[partitionY];
        
        if (maxX <= minY && maxY <= minX) {
            if ((x + y) % 2 == 0) {
                return (double)(max(maxX, maxY) + min(minX, minY)) / 2;
            } else {
                return (double)max(maxX, maxY);
            }
        } else if (maxX > minY) {
            high = partitionX - 1;
        } else {
            low = partitionX + 1;
        }
    }
}
```


### Binary Search Tree
`이진탐색트리인지 검증`
```cpp
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return validate(root, LONG_MIN, LONG_MAX);
    }

private:
    bool validate(TreeNode* node, long min, long max) {
        if (node == nullptr) {
            return true;
        }

        if (node->val <= min || node->val >= max) {
            return false;
        }

        return validate(node->left, min, node->val) && validate(node->right, node->val, max);
    }
};
```
전위순위 Pre order




`이진탐색트리 회복`
```cpp

class Solution {
public:
    void recoverTree(TreeNode* root) {
        vector<TreeNode*> nodes;
        vector<int> values;
        inorderTraversal(root, nodes, values);
        sort(values.begin(), values.end());
        for (int i = 0; i < nodes.size(); i++) {
            nodes[i]->val = values[i];
        }
    }

private:
    void inorderTraversal(TreeNode* root, vector<TreeNode*>& nodes, vector<int>& values) {
        if (root == nullptr) {
            return;
        }
        inorderTraversal(root->left, nodes, values);
        nodes.push_back(root);
        values.push_back(root->val);
        inorderTraversal(root->right, nodes, values);
    }
};
```