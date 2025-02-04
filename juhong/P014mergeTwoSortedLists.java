/**
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions/1518523554/
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        final int INF = 101;
        ListNode head = new ListNode();
        ListNode result = head;

        while(true) {

            int a = INF, b = INF;

            if (list1 != null) {
                a = list1.val;
            }

            if (list2 != null) {
                b = list2.val;
            }

            if (a == INF) {
                if (b == INF) {
                    return result.next;
                }
                else {
                    head.next = new ListNode(b);
                    head = head.next;
                    list2 = list2.next;
                }
            }
            else {
                if (b == INF) {
                    head.next = new ListNode(a);
                    head = head.next;
                    list1 = list1.next;
                }
                else {
                    if (a > b) {
                        head.next = new ListNode(b);
                        head = head.next;
                        list2 = list2.next;
                    }
                    else {
                        head.next = new ListNode(a);
                        head = head.next;
                        list1 = list1.next;
                    }
                }
            }

        }
    }
}