
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean leftMostAdded = false;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // If this is the leftmost node at this level, add it to the result list
                if (!leftMostAdded) {
                    result.add(current.data);
                    leftMostAdded = true;
                }

                // Add left and right children to the queue
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return result;
    }
}
