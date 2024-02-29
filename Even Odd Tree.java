class Solution {
    private int[] heights;

    private boolean check(TreeNode node, int level) {
        if (node == null)
            return true;

        if (level % 2 == 0) { // For even levels
            if (node.val % 2 == 0) // Even value at an even level is not allowed
                return false;
            if (heights[level] != 0 && heights[level] >= node.val) // Value should be strictly increasing
                return false;
        } else { // For odd levels
            if (node.val % 2 != 0) // Odd value at an odd level is not allowed
                return false;
            if (heights[level] != 0 && heights[level] <= node.val) // Value should be strictly decreasing
                return false;
        }
        
        // Update the current level's maximum/minimum value
        heights[level] = node.val;

        // Recur for left and right subtrees
        return check(node.left, level + 1) && check(node.right, level + 1);
    }

    public boolean isEvenOddTree(TreeNode root) {
        heights = new int[100001]; // Array to store maximum/minimum value at each level
        return check(root, 0); // Start recursion from the root at level 0
    }
}
