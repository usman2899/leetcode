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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode temp = res;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            } else {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }

        while (list1 != null) {
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }

        return res.next;

        // ListNode curr = list1;
        // while (list2 != null) {
        //     if (curr.next == null) {
        //         curr.next = list2;
        //         curr = curr.next;
        //         list2 = list2.next;
        //     } else if (list2.val >= curr.val) {
        //         ListNode temp = curr.next;
        //         curr.next = list2;
        //         curr = curr.next;
        //         curr.next = temp;
        //         curr = curr.next;
        //         list2 = list2.next; 
        //     } else {
        //         ListNode temp = curr;
        //         curr = list2;
        //         curr.next = temp;
        //         curr = curr.next;
        //         list2 = list2.next;
        //     }
        // }
        // return list1;        


    }
}