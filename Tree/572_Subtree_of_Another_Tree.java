class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSubtreeHelper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        
        if (s.val != t.val)
            return false;
        return isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right);
    }
}


//

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String stringS = generateString(s);
        String stringT = generateString(t);
        return stringS.contains(stringT);
    }
    
    private String generateString(TreeNode tree) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(tree);
        while (!st.isEmpty()) {
            TreeNode ele = st.pop();
            if (ele == null)
                sb.append(", #");
            else {
                sb.append(", " + ele.val);
                st.push(ele.left);
                st.push(ele.right);
            }
        }
        return sb.toString();
    }
}