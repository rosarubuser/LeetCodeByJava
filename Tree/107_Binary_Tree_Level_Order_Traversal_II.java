// 3m, BFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) 
            return res;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode element = queue.poll();
                level.add(element.val);
                if (element.left != null)
                    queue.offer(element.left);
                if (element.right != null)
                    queue.offer(element.right);
            }
            res.addFirst(level);
        }
        return res;
    }
}

// 4ms DFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        levelOrderBottomHelper(root, res, 0);
        return res;
    }
    
    private void levelOrderBottomHelper(TreeNode root, LinkedList<List<Integer>> res, int level) {
        if (root == null)
            return;
        if (res.size() == level) {
            res.addFirst(new ArrayList<>());
        }
        
        res.get(res.size() - 1 - level).add(root.val);
        if (root.left != null)
            levelOrderBottomHelper(root.left, res, level + 1);
        if (root.right != null)
            levelOrderBottomHelper(root.right, res, level + 1);
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        levelOrderBottomHelper(root, res, 0);
        return res;
    }
    
    private void levelOrderBottomHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null)
            return;
        if (res.size() == level) {
            res.add(0, new ArrayList<>());
        }
        
        res.get(res.size() - 1 - level).add(root.val);
        if (root.left != null)
            levelOrderBottomHelper(root.left, res, level + 1);
        if (root.right != null)
            levelOrderBottomHelper(root.right, res, level + 1);
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottomHelper(root, res, 0);
        Collections.reverse(res);
        return res;
    }
    
    private void levelOrderBottomHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null)
            return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        if (root.left != null)
            levelOrderBottomHelper(root.left, res, level + 1);
        if (root.right != null)
            levelOrderBottomHelper(root.right, res, level + 1);
    }
}