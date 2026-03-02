
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;
        if (head.next == null)
            return false;
        if (head.next == head)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null) {
            slow = slow.next;
            if (fast.next == null)
                return false;
            if (fast.next.next != null)
                fast = fast.next.next;
            else
                return false;
            if (fast.next == slow)
                return true;
        }
        return false;

    }
}

// this approach is based on the simple fact that if the linked list has
// a cycle, the next pointer would never point to null and at some point ,
// when the fast pointer goes back in the cycle,it would be behind the
// slow pointer. If this is true, it has a cycle, else it doesnt.