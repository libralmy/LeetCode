/**
create a new ListNode to store all even node
slow pointer for odd node
fast pointer for even node
last slow node link with fast
**/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){return null;}
        
        ListNode slow = head, fast = head.next, newEvenhead = fast;
        
        while(fast != null && fast.next != null){
            slow.next = slow.next.next;
            fast.next = fast.next.next;
            
            slow = slow.next;
            fast = fast.next;
            
        }
        slow.next = newEvenhead;
        
        return head;
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
