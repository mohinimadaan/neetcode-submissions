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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        //check if k nodes exists
        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        //now curr is pointing to first node of next group

        if(count == k){
            ListNode reversed = reverseKGroup(curr,k); //to reverse later nnodes
            //reverse current/first group

            curr = head;
            count = 0;
            while(count < k){
                ListNode next = curr.next;
                curr.next = reversed;
                reversed = curr;
                curr = next;
                count++;
            }
            return reversed;
                
        }
        return head;

        
    }
}
