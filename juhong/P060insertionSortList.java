/** https://leetcode.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode head) {
        ListNode result = null;
        ListNode resultHead = null;
        ListNode resultTail = null;
        ListNode next = null;
        ListNode cur = head;

        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;

        while (cur != null) {
            next = cur.next;
            if (result == null) {
                result = cur;
                resultHead = result;
                resultTail = result;
                min = cur.val;
                max = cur.val;
                result.next = null;
            }
            else {
                resultHead = result;

                if (cur.val <= min) {
                    min = cur.val;
                    cur.next = resultHead;
                    result = cur;
                }
                else if (cur.val >= max) {
                    max = cur.val;
                    resultTail.next = cur;
                    resultTail = cur;
                    resultTail.next = null;
                }
                else {
                    while (resultHead != null) {
                        if (resultHead.val < cur.val) {
                            if (resultHead.next == null || (cur.val <= resultHead.next.val)) {
                                cur.next = resultHead.next;
                                resultHead.next = cur;
                                break;
                            }
                        }
                        resultHead = resultHead.next;
                    }
                }
            }
            cur = next;
        }
        return result;
    }
}