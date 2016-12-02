
    /********set up a dp array boolean[s.length()+1] , check the dp[slow] == true, it is the break**********/
/*****S1 leetcode => slow = fast -1 => last word c<-o<-d<-e****************/

    /**
    * boolean[] for the break mark
    * fast and slow pointer : s.substring(slow, fast)
    * |fast -> outerloop slow = fast-1 and slow-- 
    * record the previous break in fast
    **/
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length()== 0 || wordDict.isEmpty()){ return false;}
        boolean[] mark = new boolean[s.length()+1];
        mark[0] = true;
        for(int fast = 0; fast <= s.length(); fast++){
            for(int slow = fast-1; slow >= 0; slow--){
                if(mark[slow] && wordDict.contains(s.substring(slow, fast))){
                    mark[fast] = true;
                    break;
                }
            }
        }
        
        return mark[s.length()];
    }
     /*   O(n)
     public boolean wordBreak(String s, Set<String> wordDict) {
         
         boolean[] dp = new boolean[s.length()+1];
         dp[0] =true;
         for(int fast = 1; fast <= s.length(); fast++){//substring(include, exclude)
             for(int slow = 0; slow < fast ; slow++){
                 if(dp[slow] && wordDict.contains(s.substring(slow, fast))){
                     dp[fast] = true;
                     break;
                 }
             }
         }
         return dp[s.length()];

    }*/
   
}
