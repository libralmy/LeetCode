
    /**
    * @param height a given int array
    * @return the water that been trapped
    * -> | <- left < right pointer get into mid to decide the water
    * see which one is shorter then go with the shorter side and update that side max
    * cause one side taller bar will hold water in the future
    * if[l]<[r] 
    *   if[l]>lmax update lmax
    *   else water += lmax - [l]
    * else
    *   if[r]>rmax update rmax
    *   else water += rmax - [r]
    **/
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){return 0;}
        int water = 0;
        int left = 0, right = height.length-1, lmax = 0, rmax = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > lmax){
                    lmax = height[left];
                }else{
                    water += lmax - height[left];
                }
                
                left++;
            }else{
                if(height[right] > rmax){
                    rmax = height[right];
                }else{
                    water += rmax - height[right];
                }
                right--;
            }
            
        }
        
        return water;
    }
}
