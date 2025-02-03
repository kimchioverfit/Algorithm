

### 

```cpp
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";
        
        int start = 0, end = 0;
        
        // 중간을 기준으로 양쪽을 빼가면서 팰린드롬을 찾음
        for (int i = 0; i < s.size(); ++i) {
            int len1 = expandAroundCenter(s, i, i); // 홀수 길이 팰린드롬
            int len2 = expandAroundCenter(s, i, i + 1); // 짝수 길이 팰린드롬
            int len = max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substr(start, end - start + 1);
    }
    
private:
    int expandAroundCenter(const string& s, int left, int right) {
        while (left >= 0 && right < s.size() && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
};
```
중간을 기점으로 좌우 같으면 포인터를 확대

Time O(N^2)
Space O(1)