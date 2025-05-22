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
        ListNode head = new ListNode();
        ListNode ptr = head;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            ListNode curr = new ListNode();
            if (l1 == null) {
                if (carry) {
                    int value = l2.val + 1;
                    curr.val = value % 10;
                    if (value < 10) carry = false;
                } else {
                    curr.val = l2.val;
                }
                l2 = l2.next;
            } else if (l2 == null) {
                if (carry) {
                    int value = l1.val + 1;
                    curr.val = value % 10;
                    if (value < 10) carry = false;
                } else {
                    curr.val = l1.val;
                }
                l1 = l1.next;
            } else {
                if (carry) {
                    int value = l1.val + l2.val + 1;
                    curr.val = value % 10;
                    if (value < 10) carry = false;
                } else {
                    int value = l1.val + l2.val;
                    curr.val = value % 10;
                    if (value > 9) carry = true;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            ptr.next = curr;
            ptr = ptr.next;
        }
        if (carry) {
            ListNode curr = new ListNode(1);
            ptr.next = curr;
            ptr = ptr.next;
        }
        return head.next;
    }
}