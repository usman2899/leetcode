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
        int carry = 0;
        ListNode resNode = new ListNode();
        ListNode curr = resNode;

        while(l1 != null || l2 != null || carry != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int resVal = num1 + num2 + carry;
            if (resVal > 9) {
                carry = 1;
                resVal = resVal % 10;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode(resVal);
            curr.next = temp;
            curr = curr.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return resNode.next;
    }
}