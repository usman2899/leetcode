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
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> indexLarger = new ArrayList<>();
        int n = 0;

        while(head != null) {
            while(!stack.isEmpty() && stack.peek()[1] < head.val) {
                indexLarger.add(new int[]{stack.pop()[0], head.val});
            }
            stack.push(new int[]{n, head.val});
            n++;
            head = head.next;
        }

        while(!stack.isEmpty()) {
            indexLarger.add(new int[]{stack.pop()[0], 0});
        }

        int nodes = indexLarger.size();
        int[] res = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            res[indexLarger.get(i)[0]] = indexLarger.get(i)[1];
        }
        return res;

    }
}