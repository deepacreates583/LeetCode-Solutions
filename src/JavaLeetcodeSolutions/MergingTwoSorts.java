package JavaLeetcodeSolutions;

public class MergingTwoSorts {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Create a dummy node to act as the start of the merged list
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            // Traverse both lists until one of them runs out
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
                current = current.next;
            }

            // Attach any remaining nodes from either list
            if (list1 != null) {
                current.next = list1;
            } else {
                current.next = list2;
            }

            // The actual head is the node following the dummy node
            return dummy.next;
        }
    }


