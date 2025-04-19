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
    public ListNode reverseList(ListNode head) {

        //One pass solution
        if (head == null || head.next == null) {
            return head;
        } 

        ListNode result = new ListNode();
        
        //Otherwise 0 added to end of LL
        result = null;

        //New node created, current LL node value put in it, added before result, result updated to this new node, head incremented
        while (head != null) {
            int val = head.val;
            ListNode curr = new ListNode();
            curr.val = val;
            curr.next = result;
            result = curr;
            head = head.next;
        }
        return result;

        // //Two pass solution - First pass hold all values of LL in array, second pass build new LL on basis of this
        // if (head == null || head.next == null) {
        //     return head;
        // } 

        // //Stack to reverse
        // Stack<Integer> values = new Stack<>();

        // //Load stack
        // while (head != null) {
        //     values.push(head.val);
        //     head = head.next;
        // }

        // /**result to hold start of LL
        // pointer to hold current node of linked list
        // current to create new node and add after pointer, then move pointer to current
        // */
        // ListNode result = new ListNode();
        // result.val = values.pop();
        // ListNode pointer = new ListNode();
        // pointer.val = values.pop();
        // result.next = pointer;
        // pointer = result.next;

        // while(!values.isEmpty()) {
        //     ListNode curr = new ListNode();
        //     curr.val = values.pop();
        //     pointer.next = curr;
        //     pointer = pointer.next;
        // }
        // return result;
    }
}