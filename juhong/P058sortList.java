/** https://leetcode.com/problems/sort-list/
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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        return merge(sortList(left), sortList(right));
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode cur = head;
        
        while(left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return head.next;
    }

    public ListNode sortListCollections(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }
        Collections.sort(arr);

        ListNode result = null;
        ListNode tail = null;
        for (int num : arr) {
            ListNode node = new ListNode(num);
            if (tail == null) {
                result = node;
                tail = result;
            }
            else {
                tail.next = node;
                tail = tail.next;                
            }
        }
        return result;
    }
}