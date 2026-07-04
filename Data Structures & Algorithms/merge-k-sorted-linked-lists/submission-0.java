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

        //divide and conquer, binary search, merge 2 sorted LL
        if(lists == null || lists.length == 0){
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length-1);

    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end){

        if(start == end){ //if only single list no need to merge
            return lists[start];
        }

        if(start+1 == end){ //if 2 lists
            return merge2LL(lists[start], lists[end]);

        }

        //if more than 2 lists
        int mid = start + (end - start)/2;
        ListNode left = mergeKListsHelper(lists, start, mid); // handle left part
        ListNode right = mergeKListsHelper(lists, mid+1, end); // handle right part
        return merge2LL(left,right);

    }

    private ListNode merge2LL(ListNode l1, ListNode l2){
        ListNode mergedHead = new ListNode(-1);
        ListNode mergedTail = mergedHead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                mergedTail.next = l1;
                l1 = l1.next;
            }else{
                mergedTail.next = l2;
                l2 = l2.next;
            }
            mergedTail = mergedTail.next;
        }

        if(l1 != null){
            mergedTail.next = l1;
        }else{
            mergedTail.next = l2;
        }
        return mergedHead.next;
    }
}
