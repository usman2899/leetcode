/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        cal(root, Integer.MIN_VALUE);
        return good;
    }
    void cal(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) good++;
        max = Math.max(max, root.val);
        cal(root.left, max);
        cal(root.right, max);
    }
}

        // int res = 0;
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while (!stack.isEmpty()) {
        //     TreeNode cur = stack.pop();
        //     boolean flag = true;
        //     for (int i = 0; i < stack.size(); i++) {
        //         if (stack.get(i).val > cur.val) {
        //             flag = false;
        //         }
        //     }
        //     if (flag) {
        //         res++;
        //     }
        //     if (cur.left != null) {
        //         stack.push(cur.left);
        //     }
        //     if (cur.right != null) {
        //         stack.push(cur.right);
        //     }
        // }
        // return res;