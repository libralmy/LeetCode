public class MovingAverage {
    /***
    * use array to store the add up sum
    * using rolling array [size+1] to store the 
    * id++ in next()
    * consider about id<=size
    * sum[getIdx(id)] = sum[getIdx(id-1)] + val;
    ***/
    /** Initialize your data structure here. */
    
    double result = 0;
    double[] sum;
    int id = 0;
    int size = 0;
    
    public MovingAverage(int size) {
            sum = new double[size+1];
            this.size = size;
    }
    
    
    public int getIdx(int x){
        return x%(size+1);
    }
    
    
    public double next(int val) {
        // Write your code here
        id++;

        sum[getIdx(id)] = sum[getIdx(id-1)] + val;
        
        if(id <= size){
            result = sum[getIdx(id)]/id;
        }else{
            result = (sum[getIdx(id)] - sum[getIdx(id-size)])/size;
        }
        
        return result;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */
