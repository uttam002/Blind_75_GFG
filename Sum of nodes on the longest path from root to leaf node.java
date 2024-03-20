
//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int sumOfLongRootToLeafPath(Node root) {
        int sum = 0;
        int level = 0;
        Pair ans = solve(root, sum, level + 1);
        return ans.second;
    }

    static Pair solve(Node root, int sum, int level) {
        if (root == null) {
            return new Pair(level, sum);
        }
        sum += root.data;
        Pair left = solve(root.left, sum, level + 1);
        Pair right = solve(root.right, sum, level + 1);
        if (left.first > right.first) {
            return left;
        }
        if (left.first < right.first) {
            return right;
        }
        return left.second > right.second ? left : right;
    }
}
