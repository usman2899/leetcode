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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String ans1 = traverse(root1);
        String ans2 = traverse(root2);
        return ans1.equals(ans2);
    }
    
    String traverse(TreeNode root) {
        String res = "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left == null && curr.right == null) {
                res += curr.val;
                res += ",";
            }
        }
        return res;
    }
}