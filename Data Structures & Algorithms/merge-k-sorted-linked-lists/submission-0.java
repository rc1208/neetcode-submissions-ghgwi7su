/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length  == 0) return null;
        ListNode l1 = lists[0];

        for (int i=1; i< lists.length;i++) {
            l1 = mergeTwoLists(l1, lists[i]); 
        }

        return l1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1 -> [1,2,4]
        // l2 -> [1,3,5]

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode head = new ListNode(-1);
        ListNode prev = head;


        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                prev.next = ptr1;
                prev = ptr1;
                ptr1 = ptr1.next;
            } else {
                prev.next = ptr2;
                prev = ptr2;
                ptr2 = ptr2.next;
            }
        }
        

        if (ptr1 != null) prev.next = ptr1;
        if (ptr2 != null) prev.next = ptr2;

        ListNode itr = head.next;

        // while (itr != null) {
        //     System.out.println(itr.val);
        //     itr = itr.next;
        // }

        return head.next;
    }
}
