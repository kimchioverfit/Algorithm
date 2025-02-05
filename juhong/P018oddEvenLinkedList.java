/**
 * https://leetcode.com/problems/odd-even-linked-list/submissions/1524217403/
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
    public ListNode oddEvenList(ListNode head) {
        ListNode even = null;
        ListNode evenHead = null;
        ListNode result = head;

        while(head != null) {
            if (even == null) {
                even = head.next;
                evenHead = even;
            }
            else {
                evenHead.next = head.next;
                evenHead = evenHead.next;
            }

            if (head.next != null) {
                head.next = head.next.next;
            }
            if (head.next != null) {
                head = head.next;
            }
            else {
                head.next = even;
                return result;
            }
        }
        return result;
    }
}