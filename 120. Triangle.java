public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){return 0;}
        
        int[] res = new int[triangle.size()+1];
        
        for(int layer = triangle.size()-1; layer >= 0; layer--){
            for(int j = 0; j < triangle.get(layer).size(); j++){
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(layer).get(j);
            }
        }
        
        return res[0];
    }
}
