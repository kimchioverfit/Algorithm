### 기본 Struct 형태 

```cpp
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
```


### Invert Binary Tree

좌우 반전 
```cpp
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(!root) return nullptr;
        TreeNode * node = new TreeNode();
        node->val = root->val;
        node->left = invertTree(root->right);
        node->right = invertTree(root->left);
        return node;
    }
};
```


### Inorder 

```cpp
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorder(root,result);
        return result;
    }
    void inorder(TreeNode* root,vector<int>& result){
        if(!root) return;
        inorder(root->left,result);
        result.push_back(root->val);
        inorder(root->right,result);
    }
};
```



### Bianry tree

`같은 트리인지 검증`
```cpp
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (!p&& !q) return true;
        if (!p|| !q) return false;
        if (p->val != q->val) return false;
        
        return isSameTree(p->left,q->left) && isSameTree(p->right,q->right);
    }
};
```

같지 않을때 false 리턴해주는 부분 중요 



`대칭 검증`
```cpp
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (!root) return true;
        return isMirror(root->left, root->right);
    }
    
    bool isMirror(TreeNode* left, TreeNode* right) {
        if (!left && !right) return true;
        if (!left || !right) return false;
        if (left->val != right->val) return false;
        return isMirror(left->left, right->right) && isMirror(left->right, right->left);
    }
};
```

마지막줄이 중요 


`최대 깊이 구하기`

```cpp
class Solution {
public:
int cnt =0;
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        return 1 + max(maxDepth(root->left), maxDepth(root->right));
    }
};
```

