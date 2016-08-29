   /**
    * @param nums[] is the input array
    * @param k is the window size
    * @return array of max value when sliding window
    * conner case nums[] is null, k is 0, k window is greater than length of nums => return 0
    * DS: ArrayDeque - double-ended queue
    * enqueue() - peekLast(top of queue) < num
    *           make sure the first elem always be the largest, if not remove all and add it at first
    * offer first k-1 elem in queue
    * iterate start from i=k-1
    *   offer the kth elem into queue
    *   add the peekFirst elem in the result arry
    *   remove the left elem out of window
    * dequeue() - only remove the first elem is the left elem of sliding window
    **/
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k ==0 || k>nums.length){return nums;}
        int[] result = new int[nums.length-k+1];// k =2 {1,2,3}
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < k-1; i++){
            enqueue(deque, nums[i]);
        }
        
        for(int i = k-1; i < nums.length; i++){
            enqueue(deque, nums[i]);
            result[i-(k-1)] = deque.peekFirst();
            dequeue(deque, nums[i-(k-1)]);//left elem that will move out of queue
        }
        
        return result;
    }
    
    public static void enqueue(Deque<Integer> deque, int num){
        while(!deque.isEmpty() && deque.peekLast() < num){
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    public static void dequeue(Deque<Integer> deque, int num){
        if(deque.peekFirst() == num){
            deque.pollFirst();
        }
    }
