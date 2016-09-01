
    /**
     * @param s an given string
     * @return verify it is number or not
     * condition: trim() the space
     *            Num - check seeNum and ecouldshowafter
     *            Dot - check seeDot and seeE
     *            E - check seeNum and seeE , update ecouldshowafter
     *            +- - check i!=0 && i-1 != 'e'
     *return seeNum && ecouldshowafter
     * **/
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean seeNum = false;
        boolean seeDot = false;
        boolean seeE = false;
        boolean ecouldshowafter = false;

        for(int i = 0 ; i < s.length(); i++){
            char tempChr = s.charAt(i);
            if(tempChr >= '0' && tempChr <= '9'){
                seeNum = true;
                ecouldshowafter = true;
            }else if( tempChr == '.'){
                if(seeDot || seeE){
                    return false;
                }else{
                    seeDot = true;
                }
            }else if(tempChr == 'e'){
                if(seeE || !ecouldshowafter){
                    return false;
                }else{
                    seeE = true;
                    ecouldshowafter = false;
                }
            }else if(tempChr == '+' || tempChr == '-'){
                if(i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return seeNum && ecouldshowafter;
    }
}
