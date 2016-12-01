/**
 DS: ListNode
 Process: push -> add to head
          pop -> remove head
          top -> show head
          getMin -> update by push for geting the smallest elem
 Notice: check the LinkList is null or not before taking action
 Pram: @head - ListNode  
       @minVal - store min val of input 
 **/
 
public ListNode head;
public class MinStack {
    class ListNode{
        int val;
        int minVal;
        ListNode next;
        ListNode(int x, int minVal){
            this.val = x;
            this.minVal = minVal;
        }
    }
    public void push(int x) {
        if(head != null){
            ListNode oldhead = head;
            head = new ListNode(x, Math.min(x, head.minVal));
            head.next = oldhead;
            
        }else{
            head = new ListNode(x, x);
        }
        //minVal = Math.min(x,minVal);

    }

    public void pop() {
        if(head != null){
            ListNode oldhead = head;
            head = head.next;
            oldhead = null;
        }

    }

    public int top() {
        if(head != null){
            return head.val;
        }else{
            return -1;
        }

    }

    public int getMin() {
        if(head != null){
            return head.minVal;
        }else{
            return -1;
        }
    }
 
}



public class MinStack {
    //注意：做任何操作前，都思考一下 stack / minStack 为空的状况
    /*****************ArrayList**********************/
    /*
    public List<Integer> stack;
    public List<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(min.isEmpty() || min.get(min.size()-1) >= x){
            min.add(x);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int temp = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            if(!min.isEmpty() && min.get(min.size()-1) == temp){
                min.remove(min.size()-1);
            }
        }else{
            return;
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.get(stack.size()-1);
        }
        return 0;
    }
    
    public int getMin() {
        if(!min.isEmpty()){
            return min.get(min.size()-1);
        }
        return 0;
    }
    */
    /**************************better solution two stacks***********************************/
   /*
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();    
    
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.empty()) return;
        int elem = stack.pop();
        if(!minStack.empty() && minStack.peek() == elem){
            minStack.pop();
        }
    }

    public int top() {
        if(stack.empty()) return 0;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.empty()) return 0;
        return minStack.peek();
    }
*/
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
 
 
 
 
