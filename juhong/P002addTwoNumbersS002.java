/** 2. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        int sum = 0;
        int left = 0;

        // 새로운 노드리스트를 안 만들고, 기존 파라미터 재사용
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        ListNode l1Tail = null;
        ListNode l2Tail = null;
        ListNode winnerHead = null;

        while(l1 != null || l2 != null) {
            // 1) l1 이나 l2 중에 하나라도 있으면 up 과 함께 합
            sum = getVal(l1) + getVal(l2) + up;
            left = sum % 10;
            up = (sum - left) / 10;

            // 2) l1 이나 l2 중에 현재 존재하는 노드에 하나라도 값 넣기
            setVal(l1, left);
            setVal(l2, left);

            // 3) up 이 있는데, 둘다 다음 노드가 없는 경우에 대비해서 다음이 없으면 생성
            // - 2개 노드 모두 생성되도, val 이 0 으로 생성되기 때문에 상관 없음 
            if (up != 0) {
                setNext(l1);
                setNext(l2);
            }

            // 4) l1 이나 l2 중에 현재 존재하는 노드의 다음 노드 찾기
            l1Tail = getNext(l1);
            l2Tail = getNext(l2);

            // 5) 먼저 끊긴 애가 있으면, 그 반대 노드를 winner 노드로 설정
            if (l1Tail == null || l2Tail == null) {
                if (winnerHead == null) {
                    winnerHead = (l1Tail == null) ? l2Head : l1Head;
                }         
            }
            
            l1 = l1Tail;
            l2 = l2Tail;
        }

        return winnerHead;
    }

    /** 
     * 현재 노드가 있는 경우, 값 생성
     */
    private void setVal(ListNode listNode, int val) {
        if (listNode != null) {
            listNode.val = val;
        }
    }

    /** 
     * 현재 노드가 있는 경우, 값 반환
     */
    private int getVal(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }
        return listNode.val;
    }

    /** 
     * 현재 노드가 존재하고, 다음 노드가 없으면 다음 노드 생성
     */
    private void setNext(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next == null) {
                listNode.next = new ListNode();
            }
        }        
    }
    /** 
     * 현재 노드가 존재하면, 다음 노드 반환
     */
    private ListNode getNext(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        return listNode.next;
    }
}