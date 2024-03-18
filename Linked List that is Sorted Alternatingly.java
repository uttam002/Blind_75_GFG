class Solution {
     public Node sort(Node head){
        // Check if the list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        // Initialize two dummy nodes to store nodes of ascending and descending orders
        Node asc = new Node(0), des = new Node(0);
        // Initialize tail pointers for both ascending and descending lists
        Node ascTail = asc, desTail = des;
        // Flag to track whether we are currently processing ascending or descending order
        boolean isAscending = true;

        // Traverse the original list and split it into ascending and descending parts
        while (head != null) {
            if (isAscending) {
                // Append the current node to the ascending list
                ascTail = ascTail.next = head;
            } else {
                // Append the current node to the descending list
                desTail = desTail.next = head;
            }
            // Move to the next node in the original list
            head = head.next;
            // Toggle the flag to switch between ascending and descending orders
            isAscending = !isAscending;
        }
        // Terminate both ascending and descending lists
        ascTail.next = desTail.next = null;

        // Reverse the descending list to get it in ascending order
        Node desHead = reverse(des.next);

        // Merge the sorted ascending and descending lists
        return merge(asc.next, desHead);
   }

    // Function to reverse a linked list
    Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to merge two sorted linked lists
    Node merge(Node l1, Node l2) {
        // Initialize a dummy node to store the merged list
        Node dummy = new Node(0), tail = dummy;
        // Traverse both lists and merge them in ascending order
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail = tail.next = l1;
                l1 = l1.next;
            } else {
                tail = tail.next = l2;
                l2 = l2.next;
            }
        }
        // Append the remaining nodes from either list
        tail.next = (l1 != null) ? l1 : l2;
        // Return the merged list
        return dummy.next;
    }
}
