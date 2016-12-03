    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){return 0;}

        PriorityQueue<Integer> pq = new PriorityQueue<>(4);
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< nums.length; i++){
            if(!set.contains(nums[i])){
                pq.add(nums[i]);
                set.add(nums[i]);
                if(pq.size() > 3){
                    set.remove(pq.poll());
                }
            }
        }
        
        
        if(pq.size() < 3){
            while(pq.size() > 1){
                pq.poll();
            }
        }
        return pq.peek();
    }

public int thirdMax(int[] nums) {
        int max, mid, small, count;
        max = mid = small = Integer.MIN_VALUE;
        count = 0;  //Count how many top elements have been found.

        for( int x: nums) {
            //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
            if( x == max || x == mid ) {
                continue;
            }

            if (x > max) {
                //right shift
                small = mid;
                mid = max;

                max = x;
                count++;
            } else if( x > mid) {
                //right shift
                small = mid;

                mid = x;
                count++;
            } else if ( x >= small) { //if small duplicated, that's find, there's no shift and need to increase count.
                small = x;
                count++;
            }
        }

        //"count" is used for checking whether found top 3 maximum elements.
        if( count >= 3) { 
            return small;
        } else {
            return max;
        }
    }
