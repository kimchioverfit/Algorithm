/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/submissions/1518837442/
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
    public ListNode swapPairs(ListNode head) {
        ListNode result = head;
        ListNode prev = null;
        ListNode next = null;
        int cnt = 0;

        while (head != null) {

            next = head.next;
            if (cnt % 2 == 0) {
                if (head.next != null) {
                    if (prev != null) {
                        prev.next = head.next;
                    }
                    prev = head;

                    head.next = head.next.next;
                    next.next = head;

                    if (cnt == 0) {
                        result = next;
                    }
                }
            }
            else {
                prev = head;
                head = head.next;
            }

            cnt += 1;
        }
        return result;
    }
}