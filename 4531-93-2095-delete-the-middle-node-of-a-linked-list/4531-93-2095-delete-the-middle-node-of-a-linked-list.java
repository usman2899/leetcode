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
        if (head == null || head.next == null) {
            return null;
        }

        ListNode behindMiddle = null;
        ListNode middle = head;
        ListNode end = head;

        while (end != null && end.next != null) {
            behindMiddle = middle;
            middle = middle.next;
            end = end.next.next;
        }

        behindMiddle.next = middle.next;
        return head;



        
    }
}