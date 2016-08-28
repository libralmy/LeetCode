/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){return null;}
        RandomListNode dummy = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        //copy of listed node
        while(dummy != null){
            map.put(dummy, new RandomListNode(dummy.label));
            dummy = dummy.next;
        }
        //reset pointer back to head and copy next, random pointer for the value of key;
        dummy = head;
        while(dummy != null){
            map.get(dummy).next = map.get(dummy.next);//copy next pointer
            map.get(dummy).random = map.get(dummy.random);//copy random pointer
            dummy = dummy.next;
        }
        
        return map.get(head);
        
    }
}

/*
//http://46aae4d1e2371e4aa769798941cef698.devproxy.yunshipei.com/tmylzq187/article/details/50913211
public RandomListNode copyRandomList(RandomListNode head) {
	RandomListNode iter = head, next;

	// First round: make copy of each node,
	// and link them together side-by-side in a single list.
	while (iter != null) {
		next = iter.next;

		RandomListNode copy = new RandomListNode(iter.label);
		iter.next = copy;
		copy.next = next;

		iter = next;
	}

	// Second round: assign random pointers for the copy nodes.
	iter = head;
	while (iter != null) {
		if (iter.random != null) {
			iter.next.random = iter.random.next;
		}
		iter = iter.next.next;
	}

	// Third round: restore the original list, and extract the copy list.
	iter = head;
	RandomListNode pseudoHead = new RandomListNode(0);
	RandomListNode copy, copyIter = pseudoHead;

	while (iter != null) {
		next = iter.next.next;

		// extract the copy
		copy = iter.next;
		copyIter.next = copy;
		copyIter = copy;

		// restore the original list
		iter.next = next;

		iter = next;
	}

	return pseudoHead.next;
}
*/
