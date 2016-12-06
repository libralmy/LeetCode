public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for(int num1 : nums1){
            if(!set.contains(num1)){
                set.add(num1);
            }
        }
        
        for(int num2: nums2){
            if(set.contains(num2)){
                intersection.add(num2);
            }
        }
        
        int[] result = new int[intersection.size()];
        int i = 0;
        for(Integer n : intersection){
            result[i++] = n;
        }
        
        return result;
    }
}
