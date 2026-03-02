public class LinkedListCycle2 {

    // This solution implements the floyd aglorithm. This algorithm uses
    // two pointers - slow and fast, and fast might reach null at some point
    // which means that there exists no cycle or might be equal to slow at some
    // point which means that there exists a cycle. After the cycle is detected,
    // We initalise a pointer at head, as the distance from the head to cycle
    // start equals to the distance from the meeting point to cycle start, and we
    // move the pointer pointing to head and slow one step at a time until they're
    // equal and return the node to which the pointer is pointing as the start of
    // the cycle.

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null)
            return null; // base case
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle detected
                ListNode entry = head; // pointer pointing to the head
                while (entry != slow) { // loop to reach the cycle start
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry; // cycle start
            }
        }
        return null; // cycle doesnt exist

    }
}
