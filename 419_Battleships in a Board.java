public class Solution {
    /**
    * only need to check the head of battleship
    * so DFS down and right
    * if up and left are 'X' then it means it already been checked or it doesnt meet the condition
    **/
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length ==0){
            return 0;
        }
        int result = 0;
        
        for(int r = 0; r < board.length; r++){
            for(int c = 0 ; c < board[0].length; c++){
                if(board[r][c] == 'X' && (r == 0 || board[r-1][c] == '.') && (c == 0 || board[r][c-1] == '.')){
                    result++;
                }
            }
        }
        
        return result;
    }
}
