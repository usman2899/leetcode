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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int len = list.size();
        int res = 0;
        
        for (int i = 0; i < len/2; i++) {
            int sum = list.get(i) + list.get(len -1 -i);
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }
}