package JavaLeetcodeSolutions;

public class ReverseNodesInKGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;

            // Comprobar si quedan al menos k nodos en la lista
            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }

            // Si hay k nodos, los invertimos
            if (count == k) {
                ListNode prev = null;
                ListNode nextNode = null;
                curr = head;

                for (int i = 0; i < k; i++) {
                    nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }

                // Conectar recursivamente con el siguiente grupo
                if (nextNode != null) {
                    head.next = reverseKGroup(nextNode, k);
                }

                return prev;
            }

            // Si quedan menos de k nodos, se dejan tal cual
            return head;
        }
    }

}
