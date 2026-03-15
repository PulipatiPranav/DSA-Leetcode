//The approach to this problem involves using a double ended queue (deque) to store the nodes
//of the Linked List. We iterate through the Linked List and add each node to the deque.
//Then, we create a new Linked List by alternating between the front and back of the deque until it is empty.
//Finally, we set the next pointer of the last node to null to terminate the list and avoid cycles.
//However, this approach uses O(n) extra space due to the deque, which is not opptimal. An optimal solution would
//involve using the two pointer approach (slow and fast pointers) to find the middle of the list, reverse the second half
//of the list, and then merge two halves together alternatively. This optimal approach would have a time complexity of
//O(n) and a space complexity of O(1).

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReorderList {
    public void Solution(ListNode head) {

        if (head == null)
            return;

        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {

            dq.addLast(curr);
            curr = curr.next;

        }

        ListNode temp = new ListNode();
        curr = temp;
        boolean flag = true;
        while (!dq.isEmpty()) {
            if (flag) {

                curr.next = dq.pollFirst();

            } else {

                curr.next = dq.pollLast();

            }
            flag = !flag;
            curr = curr.next;

        }
        curr.next = null;

    }
}