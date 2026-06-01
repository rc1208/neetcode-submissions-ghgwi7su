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

        if (lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);


        for (int i=0; i< lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (!pq.isEmpty()) {
            ListNode poppedNode = pq.poll();

            curr.next = poppedNode;
            curr = poppedNode;

            if (poppedNode.next != null) {
                pq.add(poppedNode.next);
            }
        }


        return head.next;

    }
}
