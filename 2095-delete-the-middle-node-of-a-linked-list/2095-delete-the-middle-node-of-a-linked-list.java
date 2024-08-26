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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode end = head;
        ListNode middle = head;

        while (end.next != null && end.next.next != null && end.next.next.next != null) {
            end = end.next.next;
            middle = middle.next;
        }

        if (end.next != null) {
            middle.next = middle.next.next;
        }
        return head;        
    }
}