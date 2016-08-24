iterative is more effienct
This is only used in single list;
public class Solution {
    /*******************Iterative**********************/
    /*
   public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;

    }*/
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return rLhelper(head, null);
    }
    
    public ListNode rLhelper(ListNode head, ListNode newHead){
        if(head == null) return newHead;
        
        ListNode temp = head.next;
        head.next = newHead;
        return rLhelper(temp, head);
    }
}
