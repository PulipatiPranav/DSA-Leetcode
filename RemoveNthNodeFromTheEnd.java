/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// In this solution , the approach involves first finding the length of the
// the linked list to find the indice or the number of steps to the nth node
// from
// the end from the begining by doing size - n. Then, we initialise a curr node
// to the head, which moves, the caluculated number of steps to arrive at the
// node before the node to be removed. Then we change the next pointer of the
// curr node to the next pointer of the next node, basically deleting the the
// next
// node.
class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;

        int size = length(head);

        if (n == size)
            return head.next;
        int ind = size - n;

        ListNode curr = head;
        for (int i = 1; i < ind; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;

    }

    public int length(ListNode head) {
        int count = 0;
        if (head == null)
            return count;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;

    }
}