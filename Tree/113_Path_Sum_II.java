
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> currentRes = new LinkedList<>();
        pathSumHelper(root, sum, res, currentRes);
        return res;
    }

    private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> currentRes) {
        if (root == null) return;
        
        currentRes.add(new Integer(root.val));    //make a deep copy instead of passing a reference

        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(currentRes));   // make a deep copy instead of passing a reference
        } else {
            pathSumHelper(root.left, sum - root.val, res, currentRes);
            pathSumHelper(root.right, sum - root.val, res, currentRes);
        }
        currentRes.remove(currentRes.size() - 1);
    }
}

// iteration 
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> currentRes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root, prev = null;
        int currentSum = 0;
        
        // at first run, we cannot add root to stack, otherwise dupilicated;
        // so we check whether curr != null at first run, and at last run, 
        // the stack is empty && curr == null is acceptable
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                // System.out.println("now add " + curr.val);
                currentRes.add(curr.val);
                currentSum += curr.val;
                stack.push(curr);
                curr = curr.left;
            }
            // System.out.println("go out of the loop ");
            curr = stack.peek();
            // System.out.println("peek " + curr.val);
            
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
                continue;
            }
            
            if (curr.left == null && curr.right == null && currentSum == sum) {
                // System.out.println("currentRes " + currentRes);
                res.add(new ArrayList<Integer>(currentRes));
            }
            
            stack.pop();
            // System.out.println("pop " + stack.pop());
            // System.out.println("now remove " + curr.val);
            currentRes.remove(currentRes.size() - 1);
            currentSum -= curr.val;
            prev = curr;
            curr = null;
            // System.out.println("stack size " + stack.size());
        }
        return res;
    }
}