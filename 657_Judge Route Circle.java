/***
UD: vert+-
LR: horizen+-
return vert=0 & horizen=0
**/
class Solution {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() < 2){
            return false;
        }
        
        int vert = 0, horizen = 0;
        for(int i = 0; i < moves.length(); i++){
            char temp = moves.charAt(i);
            if(temp == 'U'){
                vert--;
            }else if(temp =='D'){
                vert++;
            }else if(temp =='L'){
                horizen--;
            }else if(temp == 'R'){
                horizen++;
            }
        }
        
        return vert == 0 && horizen == 0;
    }
}
