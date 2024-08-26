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
    public ListNode mergeNodes(ListNode head) {
    //     int sum = 0;
    //     ListNode curr = head.next;
    //     do {
    //         head = head.next;
    //         if (head.val == 0) {
    //             sum = 0;
    //         } else {
    //             sum += head.val;
    //             curr = head;
    //         }

    //     } while (head != null);
        ListNode curr, temp;
        temp = curr = head.next;

        while (temp != null) {
            int sum = 0;

            while (temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }

            curr.val = sum;
            curr.next = temp.next;
            temp = temp.next;
            curr = curr.next;
        }
        return head.next;    
    }
}