/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node delNode)
    {
         delNode.data = delNode.next.data;
        
        delNode.next = delNode.next.next;
    }
}
