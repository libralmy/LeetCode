public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int n1 : nums1){
            if(!map.containsKey(n1)){
                map.put(n1, 0);
            }
            map.put(n1, map.get(n1)+1);
            
        }
        
        
        for(int n2 : nums2){
            if(map.containsKey(n2) && map.get(n2) > 0){
                list.add(n2);
                map.put(n2, map.get(n2)-1);
            }
        }
        
        int[] result = new int[list.size()];
        int i = 0;
        for(Integer n : list){
            result[i++] = n;
        }
        
        return result;
    }
}
