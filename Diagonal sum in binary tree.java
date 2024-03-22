
/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/class Tree {
    public static ArrayList<Integer> diagonalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(root, ans, 0);
        return ans;
    }
    
    public static void preorder(Node root, ArrayList<Integer> ans, int diagonal) {
        if (root == null)
            return;
        
        if (diagonal >= ans.size())
            ans.add(root.data);
        else
            ans.set(diagonal, ans.get(diagonal) + root.data);
        
        preorder(root.left, ans, diagonal + 1);
        preorder(root.right, ans, diagonal);
    }
}
