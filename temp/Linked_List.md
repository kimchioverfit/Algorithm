### 기본 Struct

```cpp
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
```


###  Reverse

```cpp
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr|| head->next == nullptr){
            return head;
        }
        ListNode* node = new ListNode();
        node = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return node ;
    }
};
``` 


`Add Two Number`

```cpp
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode();
        ListNode* current = dummy;
        int carry = 0;
        while (l1 || l2 || carry) {
            int sum = carry;
            if (l1) {
                sum += l1->val;
                l1 = l1->next;
            }
            if (l2) {
                sum += l2->val;
                l2 = l2->next;
            }
            carry = sum / 10;
            current->next = new ListNode(sum % 10);
            current = current->next;
        }
        return dummy->next;
    }
};
```