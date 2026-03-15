//The approach to this problem involves iterating through both linked lists simultaneously, 
// adding the corresponding digits along with any carry from the previous addition. 
// We create a new linked list to store the result of the addition. 
// We continue this process until we have traversed both linked lists and there is no carry left. 
// Finally, we return the head of the new linked list which represents the sum of the two numbers. 
// This approach has a time complexity of O(max(m,n)) where m and n are the lengths of the two linked lists, 
// and a space complexity of O(max(m,n)) for the new linked list.

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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;

    }
}