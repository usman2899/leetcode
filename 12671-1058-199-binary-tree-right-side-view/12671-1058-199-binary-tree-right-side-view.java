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

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 0);
        return result;
    }

    void traverse(TreeNode root, Integer level) {
        if (root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(root.val);
        }

        traverse(root.right, level+1);
        traverse(root.left, level+1);
    }
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     if (root == null) {
    //         return result;
    //     }
        
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);

    //     while(!queue.isEmpty()) {
    //         int lvlSize = queue.size();
    //         int val = 0;

    //         for (int i = 0; i < lvlSize; i++) {
    //             TreeNode curr = queue.poll();
    //             val = curr.val;

    //             if (curr.left != null) {
    //                 queue.offer(curr.left);
    //             }
    //             if (curr.right != null) {
    //                 queue.offer(curr.right);
    //             }
    //         }
    //         result.add(val);
    //     }
    //     return result;
    // }
}