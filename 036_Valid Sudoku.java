
/**
r0-9
  hashset rowset, colset, cubeset
  c 0-9
cube
rowidx = 3*(r/3) + c/3
colidx = 3*(r%3) + c%3
***/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int r = 0; r < board.length; r++){
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            
            for(int c = 0; c < board.length; c++){
                if(board[r][c] != '.' && !rowSet.add(board[r][c])){
                    return false;
                }
                
                if(board[c][r] != '.' && !colSet.add(board[c][r])){
                    return false;
                }
                
                int rowidx = 3*(r/3) + c/3;
                int colidx = 3*(r%3) + c%3;
                if(board[rowidx][colidx] != '.' && !cubeSet.add(board[rowidx][colidx])){
                    return false;
                }
            }
        }
        
        return true;
    }
}
