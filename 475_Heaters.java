/**
* @param a given array that contains the index of houses, 
* @param a given array that contains the index of heaters
* @return the shortest radius that heaters need
* sorted two arrays
* using two pointers one go with houses, one goes with heaters
* heater[j] - house[i]>= heater[j+1] -house[i], heater pointer get in the middle of houses
* record the min distanse heater[j] - house[i]
**/
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        
        if(houses ==  null || heaters == null){return result;}
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int heat = 0;
        for(int h = 0 ; h < houses.length ; h++){
            while(heat < heaters.length-1 && Math.abs(heaters[heat] - houses[h]) >= Math.abs(heaters[heat+1] - houses[h])){
                heat++;
            }
            result = Math.abs(heaters[heat] - houses[h]) > result? Math.abs(heaters[heat] - houses[h]) : result;
        }
        
        
        
        return result;
    }
}
