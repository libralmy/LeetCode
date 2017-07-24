/**
* calculate the distance between two points[i] points[j]
* put dis in the map
* map is only for each i to j, so renew each i level
* An2 for each dis in the current map
***/

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int counter = 0;
        
        for(int i = 0 ; i < points.length; i++){
            
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                int dis = getDistance(points[i], points[j]);
                
                if(!map.containsKey(dis)){
                    map.put(dis, 0);
                }
                map.put(dis, map.get(dis)+1);
            }
            
            for(int val : map.values()){
                counter += val*(val-1);
            }
        }
        
        return counter;
    }
    
    
    public int getDistance(int[] a, int[] b){
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx*dx + dy*dy;
    }
}
