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

// Recursion
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(0, res, root);
        return res;
    }
    
    private void levelOrderHelper(int index, List<List<Integer>> res, Node root) {
        if (root == null)
            return;
        
        if (res.size() == index) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        for (Node chil: root.children) {
            levelOrderHelper(index + 1, res, chil);
        }
    }
}