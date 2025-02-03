(32bits)
INT_MAX = 2^31-1 
INT_MIN = -2^31 

함수 파라미터 적을 때, 
void inorder(TreeNode* root,vector<int>& result)
여기서 &를 빼먹지말자. 참조연산자가 없으면 값만 들어간다.