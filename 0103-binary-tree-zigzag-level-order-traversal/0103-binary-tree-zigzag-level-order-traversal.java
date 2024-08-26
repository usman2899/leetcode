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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        
        while(!stack.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            Stack<TreeNode> currStack = new Stack<>();
            int levelSize = stack.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = stack.pop();
                currList.add(currNode.val);
                currStack = addStack(currNode, currStack, level);
            }
            stack = currStack;
            res.add(currList);
            level++;
        }
        return res;       
    }
    
    Stack<TreeNode> addStack(TreeNode node, Stack<TreeNode> stack, int level) {
        if (level % 2 == 0) {
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        } else {
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return stack;
    }
}