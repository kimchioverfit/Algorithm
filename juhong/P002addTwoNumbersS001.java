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

        ListNode l1Head = l1;
        ListNode l2Head = l2;
        ListNode winnerHead = null;
        ListNode winnerTail = null;

        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + up;
            left = sum % 10;
            up = (sum - left) / 10;

            l1.val = left;
            l2.val = left;

            if ((l1.next == null && l2.next == null) && up != 0) {
                l1.next = new ListNode();
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        winnerTail = (l1 == null) ? l2 : l1;
        winnerHead = (l1 == null) ? l2Head : l1Head;

        while(winnerTail != null) {
            sum = winnerTail.val + up;
            left = sum % 10;
            up = (sum - left) / 10;
            winnerTail.val = left;

            if (winnerTail.next == null && up != 0) {
                winnerTail.next = new ListNode();
            }
            winnerTail = winnerTail.next;
        }

        return winnerHead;
    }
}