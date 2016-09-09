/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    /**
    * @param lists a given ListNode array
    * @return a single ListNode merged by the array
    * 
    * find patition and divided into merge two sorted list
    * partition() 
    *   stop point- start == end return list[start]
    *   slit it and merge two listNode
    *   or else return null
    * merge() return two sorted list
    * it is O(nlogk), merge takes O(n) time and partition takes O(logk) time
    **/
    
    public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){return null;}
        return findpatition(lists, 0, lists.length-1);
    }
    
    public ListNode findpatition(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        if(start < end){
            int partition = start + (end - start)/2;
            ListNode l1 = findpatition(lists, start, partition);
            ListNode l2 = findpatition(lists,partition+1, end);
            return merge(l1, l2);
        }else{
            return null;
        }

    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        
        if(l1 == null){ return l2;}
        if(l2 == null){return l1;}
        
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
        
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
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
        
        if(l1 == null){ pointer.next = l2;}
        if(l2 == null){pointer.next = l1;}
        
        return dummyhead.next;
    }
}
