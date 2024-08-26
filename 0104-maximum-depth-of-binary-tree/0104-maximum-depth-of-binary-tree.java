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
    public int maxDepth(TreeNode root) {
    //     int l, r, n;
    //     l = r = n = 0; 
    //     n = findDepth(n, l, r, root);
    //     return n;
    // }
    // int findDepth(int n, int l, int r, TreeNode root) {
    //     if (root == null) {
    //         return n;
    //     }
    //     n++;
    //     l = findDepth(n, l, r, root.left);
    //     r = findDepth(n, l, r, root.right);
    //     if (l>r) {
    //         n = l;
    //     } else {
    //         n = r;
    //     }
    //     return n;

        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}