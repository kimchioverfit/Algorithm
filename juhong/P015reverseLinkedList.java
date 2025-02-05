/**
 * https://leetcode.com/problems/reverse-linked-list/submissions/1518553488/
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
    public ListNode reverseList(ListNode head) {
        ListNode before = null;

        while(head != null) {
            ListNode next = head.next;

            if (before == null) {
                before = new ListNode(head.val);
            }
            else {
                ListNode node = new ListNode(head.val, before);
                before = node;
            }
            head = next;
        }
        return before;
    }
}