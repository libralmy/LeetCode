    /**
    * d(n) = 0  -> 0
    *        9  -> 9
    *        n%9 !=0  -> n%9
    *        n%9 ==0  -> 9
    **/
public class Solution {

    public int addDigits(int num) {
        return num == 0? 0:(num%9 ==0? 9: num%9);
    }
}
