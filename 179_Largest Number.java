/**
str_num[]
(a, b)-> (b+a).compareTo(a+b)
str_num[0].equals("0") return "0"
***/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){return "";}
        
        StringBuilder st = new StringBuilder();
        String[] str_nums = new String[nums.length]; 
        for(int i = 0; i< nums.length; i++){
            str_nums[i] = String.valueOf(nums[i]);
        }
        
        
        Arrays.sort(str_nums, (a,b)-> (b+a).compareTo(a+b));
        if(str_nums[0].equals("0")){
            return "0";
        }
    
        for(String s: str_nums){
            st.append(s);
        }
        
        return st.toString();
    }
}
