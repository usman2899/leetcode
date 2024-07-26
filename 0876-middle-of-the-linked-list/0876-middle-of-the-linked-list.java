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
    public ListNode middleNode(ListNode head) {
        ListNode b = head;

        while (b.next != null) {
            head = head.next;
            if (b.next.next != null) {
                b = b.next.next;
            }
            else {
                return head;
            }
        }
        return head;
    }
}