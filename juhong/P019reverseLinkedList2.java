/**
 * https://leetcode.com/problems/reverse-linked-list-ii/submissions/1524331303/
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        int index = 1;
        ListNode start = null;
        ListNode end = null;

        while(head != null) {
            if (left <= index && index <= right) {
                stack.push(head);
            }

            if (index == left - 1) {
                start = head;
            }
            else if (index == right) {
                end = head.next;
                while (!stack.isEmpty()) {
                    if (start == null) {
                        start = stack.pop();
                        result = start;
                    }
                    else {
                        start.next = stack.pop();
                        start = start.next;
                    }
                }
                if (start != null) {
                    start.next = end;
                }
            }
            index += 1;
            head = head.next;
        }

        return result;
    }
}