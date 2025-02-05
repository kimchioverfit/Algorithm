/**
 * https://leetcode.com/problems/add-two-numbers/submissions/1518658076/
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

        ListNode result = new ListNode();
        ListNode head = result;

        int up = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum = up;
            up = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            up = (int) sum / 10;
            sum = sum % 10;

            head.next = new ListNode(sum);
            head = head.next;
        }
        if (up != 0) {
            head.next = new ListNode(up);
        }

        return result.next;
    }
}