/**
 * fast move n steps ahead
 * then slow move same path as fast
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        while(n >= 0){
            fast = fast.next;
            n--;
        }
        
        //slow = slow.next;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
