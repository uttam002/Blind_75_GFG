

/* struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};
*/

//Function to find the data of nth node from the end of a linked list.
int getNthFromLast(Node *head, int n)
{
   Node* temp=head;
       int size=0;
       while(head)
       {
           size++;
           head=head->next;
       }
       int slow=size-n;
       if(slow<0) return -1;
       while(slow!=0)
       {
           temp=temp->next;
           slow--;
       }
       return temp->data;
}
