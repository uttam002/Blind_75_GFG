
/*
class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
       Node list1 = null;
        for (int value : head1) {
            Node newNode = new Node(value);
            newNode.next = list1;
            list1 = newNode;
        }

        // Convert LinkedList<Integer> head2 to linked list of Nodes
        Node list2 = null;
        for (int value : head2) {
            Node newNode = new Node(value);
            newNode.next = list2;
            list2 = newNode;
        }

        // Add all elements from the first linked list to a HashSet
        HashSet<Integer> set = new HashSet<>();
        Node temp1 = list1;
        while (temp1 != null) {
            set.add(temp1.data);
            temp1 = temp1.next;
        }

        // Count pairs whose sum is equal to x
        int count = 0;
        Node temp2 = list2;
        while (temp2 != null) {
            if (set.contains(x - temp2.data)) {
                count++;
            }
            temp2 = temp2.next;
        }

        return count;
    }
}
