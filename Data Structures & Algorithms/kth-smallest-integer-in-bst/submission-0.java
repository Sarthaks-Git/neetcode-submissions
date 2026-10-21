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
    int count = 0;
    int result = 0;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || found) {
            return;
        }

        inorder(node.left, k);

        // Stop if the answer was found in the left subtree
        if (found) {
            return;
        }

        count++;

        if (count == k) {
            result = node.val;
            found = true;
            return;
        }

        inorder(node.right, k);
    }
}
