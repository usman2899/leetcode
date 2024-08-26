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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        return res;
    }

    void traverse(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        } 
        traverse(res, root.left);
        res.add(root.val);
        traverse(res, root.right);
        
    }
}