/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        findPath(root, p, pStack);
        findPath(root, q, qStack);

        Collections.reverse(pStack);
        Collections.reverse(qStack);

        TreeNode lca = null;
        
        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();

            if (pNode == qNode) {
                lca = pNode;
            } else {
                break;
            }
        }
        return lca;
    }

    private boolean findPath(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null) {
            return false;
        }

        stack.push(root);

        if (root == target) {
            return true;
        }

        if (findPath(root.left, target, stack) || findPath(root.right, target, stack)) {
            return true;
        }

        stack.pop();
        return false;
    }
}