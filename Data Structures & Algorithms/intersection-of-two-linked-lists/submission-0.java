/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet();
        ListNode ptr = headA;
        while (ptr != null) {
            set.add(ptr);
            ptr = ptr.next;
        }

        ListNode ptr1 = headB;

        while (ptr1 != null) {
            if (set.contains(ptr1)) return ptr1;
            ptr1 = ptr1.next;
        }

        return null;

    }
}