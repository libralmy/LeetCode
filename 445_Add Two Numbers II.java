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
        if(l1 == null){return l2;}
        if(l2 == null){return l1;}
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carier = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carier != 0){
            int sum = (s1.isEmpty()? 0 : s1.pop()) + (s2.isEmpty()? 0 :s2.pop()) + carier;
            int remain = sum%10;
            carier = sum/10;
            
            ListNode temp = new ListNode(remain);
            p.next = temp;
            p = p.next;
        }
        
        
        
        return reverseList(dummy.next);
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
