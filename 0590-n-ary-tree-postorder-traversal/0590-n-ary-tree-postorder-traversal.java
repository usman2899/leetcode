/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        result.add(root.val);
        return result;
    }
    
    void traverse(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        for (Node child: children) {
            traverse(child, result);
            result.add(child.val);
        }
    }
}