package JavaLeetcodeSolutions;

public class SwapNodeInPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // Create a dummy node to simplify edge cases at the head of the list
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;

            // Loop runs as long as there is a pair of nodes left to swap
            while (current.next != null && current.next.next != null) {
                ListNode first = current.next;
                ListNode second = current.next.next;

                // Swapping pointers
                first.next = second.next;
                second.next = first;
                current.next = second;

                // Advance current pointer by two nodes
                current = first;
            }

            return dummy.next;
        }
    }

}
