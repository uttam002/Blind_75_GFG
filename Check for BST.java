
class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    int val = -1;
    boolean isBST(Node root)
    {
        if(root == null)    return true;
        
        boolean leftFlag = isBST(root.left);
        
        if(root.data <= val)    return false;
        val = root.data;
        
        boolean rightFlag = isBST(root.right);
        
        return leftFlag && rightFlag;
    }
}
