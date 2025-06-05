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
    
    Map<Integer, Integer> map = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;

        for(Integer key: map.keySet()) {
            if (map.get(key) > maxSum || (map.get(key) == maxSum && key < res)) {
                res = key;
                maxSum = map.get(key);
            }
        }
        return res;
        
    }
    void dfs(TreeNode root, int level) {
        if (root == null) return;

        map.put(level, map.getOrDefault(level, 0) + root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

// class Solution {
//     List<Integer> list = new ArrayList<>();

//     public int maxLevelSum(TreeNode root) {
//         dfs(root, 0);
//         int res = 0;
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < list.size(); i++) {
//             if (list.get(i) > max) {
//                 max = list.get(i);
//                 res = i;
//             }
//         }
//         return res+1;
//     }

//     void dfs(TreeNode root, int level) {
//         if (root == null) {
//             return;
//         }
//         if (list.size() == level) {
//             list.add(root.val);
//         } else {
//             int newVal = list.get(level) + root.val;
//             list.set(level, newVal);
//         }
//         dfs(root.left, level+1);
//         dfs(root.right, level+1);
//     }
// }