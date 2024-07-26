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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len == 1) {
            return null;
        }
        temp = head;
        int diff = len - n;
        if (diff == 0) {
            return head.next;
        }

        for (int i = 0; i <= diff; i++ ){
            if (i == diff-1) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;

        }
        return head;
    }
}