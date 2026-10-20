class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val)
            // either the value of node are both greater than the root so they will be on the right side
                root = root.right;
            else if (p.val < root.val && q.val < root.val)
            //either the value of the nodes are both smaller than the root so they will be on the left side    
                root = root.left;
            else
            // if the values of the nodes are equal to or one is smaller and one is greater than the root, in that case return the root
                return root;
        }
        return null;
    }
}