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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //1.iterate and count nodes,size -n+1 node to remove from starting - not implementing

        //2. 2 pointer
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = dummy;

        //mode right pointer n spaces ahead
        while(n>0){
            right = right.next;
            n--;
        }

        //move both pointers till right reaches last
        while(right.next != null){
            left = left.next;
            right = right.next;
        }

        //now next to left is the node that needs to be deleted
        left.next = left.next.next;
        return dummy.next;

    }
}
