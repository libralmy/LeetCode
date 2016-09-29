
 * @param listNode 
 * @return reverse pair of node
 * 1 first = dummypointer.next, second = dummypointer.next.next
 * 2 first.next = second.next
 * 3 reverse step 1
 * 4 move dummypointer to nextnext
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dpointer = dummy;
        while(dpointer.next != null && dpointer.next.next != null){
            ListNode first = dpointer.next;
            ListNode second = dpointer.next.next;
            first.next = second.next;
            dpointer.next = second;
            dpointer.next.next = first;
            dpointer = dpointer.next.next;
        }
        
        return dummy.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
