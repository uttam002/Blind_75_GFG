//User function Template for C

//Function to find the data of nth node from the end of a linked list.
int getNthFromLast(struct Node *head, int n)
{
    long count=0;
  start = head;
    while(start != NULL) {
      start = start->next;
      count ++;
    }
    if(n>count) return -1;
    else return count-n+1;
}
