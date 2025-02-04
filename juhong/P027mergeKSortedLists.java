/**
 * https://leetcode.com/problems/merge-k-sorted-lists/submissions/1528734529/
 */

import java.util.*;
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode();
        ListNode result = head;

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.offer(listNode);
            }
        }

        while (!pq.isEmpty()) {
            ListNode element = pq.poll();
            if (element.next != null) {
                pq.offer(element.next);
            }

            head.next = element;
            head = head.next;
        }

        return result.next == null ? null : result.next;
    }
}