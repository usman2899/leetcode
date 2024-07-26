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
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val == val) {
                result = curr;
                break;
            }
            if (curr.right != null) {
                stack.add(curr.right);
            }
            if (curr.left != null) {
                stack.add(curr.left);
            }
        }
        return result;        
    }
}