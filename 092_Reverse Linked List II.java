/**
 * (m-1)p=p.next
 * pre, cur
 * p.next.next = cur, p.next = pre
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        

        for(int i = 0; i < m-1; i++){
            p = p.next;
        }
        
        ListNode pre = p.next; 
        ListNode cur = pre.next;
        
        
        for(int i = 0; i < n-m; i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        
        p.next.next = cur;
        p.next = pre;
        
        return dummy.next;
    }
    
    
}
