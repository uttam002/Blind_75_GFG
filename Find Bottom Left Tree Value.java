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
    int leftmostValue;
    int maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        leftmostValue = root.val;
        maxDepth = 0;
        findBottomLeftValue(root, 1);
        return leftmostValue;
    }

    private void findBottomLeftValue(TreeNode node, int depth) {
        if (node == null) return;

        if (depth > maxDepth) {
            leftmostValue = node.val;
            maxDepth = depth;
        }

        findBottomLeftValue(node.left, depth + 1);
        findBottomLeftValue(node.right, depth + 1);
    }
}
