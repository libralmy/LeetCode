    /**
    * @param l1, l2  two given list
    * @return one ListNode
    * 
    * sum, carry to next digit, remain in current digit
    * need two pointer for l1 and l2
    * l1 and l2 might not have same length,or carry one more; while(p1!=null||p2!=null||carry!=0)
    * add up two digits, carry = sum/10, remain = sum%10
    * need to check p1 == null? before .next
    * pointer.next = new ListNode(remain);
    * 
    * ListNode dummyhead.next is the return
    * 
    **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){ return l2;}
        if(l2 == null){ return l1;}
        ListNode dummyhead = new ListNode(0);
        ListNode pointer = dummyhead;
        ListNode p1 = l1, p2 = l2;
        
        int sum = 0, carry = 0, remain = 0;
        while(p1 != null || p2 != null || carry != 0){
            sum = (p1 == null? 0: p1.val) + (p2 == null? 0: p2.val) + carry;
            carry = sum/10;
            remain = sum%10;
            
            pointer.next = new ListNode(remain);
            pointer = pointer.next;
            
            p1 = (p1 == null ? null : p1.next);
            p2 = (p2 == null ? null : p2.next);
           
        }
        return dummyhead.next;
    }
}
 /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }
    private ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry == 1)  return new ListNode(1);
            else    return null;
        }
        
        int sum = carry;
        sum = (l1 == null)?sum:sum+l1.val;
        sum = (l2 == null)?sum:sum+l2.val;
        
        carry = sum / 10;
        sum = sum % 10;
        
        ListNode node = new ListNode(sum);
        if(l1 == null)  
            node.next = helper(l1,l2.next,carry);
        else if(l2 == null)
            node.next = helper(l1.next,l2,carry);
        else
            node.next = helper(l1.next,l2.next,carry);
        return node;
        
    }
*/
}
