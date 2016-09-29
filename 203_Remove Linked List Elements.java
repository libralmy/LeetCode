
 /**
 * @param head a given single listnode
 * @param val the val need to be removed from list
 * @return list
 * dummy.next = head, tail = dummy
 * if==val tail.next = pointer.next
 * else tail = tail.next
 * pointer = pointer.next
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode headp = head;
        while(headp != null){
            if(headp.val == val){
                tail.next = headp.next;
            }else{
                tail = tail.next;
            }
            headp = headp.next;
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
 
