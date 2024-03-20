/*node class of the binary ssearch tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution
{
    public static int sumOfLeafNodes(Node root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null)return root.data;
        
        int leftSum = sumOfLeafNodes(root.left),rightSum = sumOfLeafNodes(root.right);
        return leftSum + rightSum;
    }
}
