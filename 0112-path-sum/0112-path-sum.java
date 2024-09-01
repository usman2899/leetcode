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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        nodeStack.push(root);
        numStack.push(targetSum - root.val);
        
        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int currSum = numStack.pop();
            if (currNode.left == null && currNode.right == null && currSum == 0) {
                return true;
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                numStack.push(currSum - currNode.left.val);
            }
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                numStack.push(currSum - currNode.right.val);
            }
        }
        return false;
    }
}