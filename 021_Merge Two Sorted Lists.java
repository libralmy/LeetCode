/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 * @param l1 sorted linked list
 * @param l2 sorted linked list
 * @return a linked list is the result of two merged list
 * 
 * S1 recurstion: 
 *   stop point: l1 == null(return l2) || l2 == null(return l1)
 *   same process l1.next = merge(l1.next,l2) return l1 || l2.next = merge(l1, l2.next) return l2
 * 
 * S2 iteration:
    * BFS:
    * dummyhead, pointer
    * while l1 and l2 is not null
    *   l1.val < l2.val
    *   pointer = new node(l1.val)
    *   l1 = l1.next
    *   same as l2
    *   pointer = pointer.next
    * if finish l1, add rest of l2
    * same as l2
    * return dummyhead.next
 **/
public class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){ return l2;}
        if(l2 == null){ return l1;}
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode pointer = dummyhead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pointer.next = l1;
                l1 = l1.next;
            }else{
                pointer.next = l2;
                l2 = l2.next;
            }
            
            pointer = pointer.next;
        }
        if(l1 == null) pointer.next = l2;
        if(l2 == null) pointer.next = l1;
        
        return dummyhead.next;
        
    }
}
