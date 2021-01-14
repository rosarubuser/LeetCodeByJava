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

// iteration

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if (root ==  null) return res;
        
        queue.offer(root);       
        while(!queue.isEmpty()) {
            List<Integer> currLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                currLevel.add(tmp.val);
                for (Node chil : tmp.children)
                    queue.add(chil);
            }
            res.add(currLevel);
        }
        return res;
    }
}