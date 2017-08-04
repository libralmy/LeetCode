/**
* use hashmap: record each row of string as key when B shows N time
 use int[] : record the col count how many times B show up
**/

public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int count = 0;
        int m = picture.length, n = picture[0].length;
        int[] colCount = new int[n];
        
        Map<String, Integer> rowMap = new HashMap<>();
        for(int r = 0; r < m; r++){
            String rowN = rowFinder(N, picture, r, colCount);//find the string that B showed up N times, and record colCount[]
            if(rowN.equals(null)) continue;
            
            if(!rowMap.containsKey(rowN)){
                rowMap.put(rowN, 0);
            }
            rowMap.put(rowN,rowMap.get(rowN)+1);
            
        }
        
        for(String str : rowMap.keySet()){
            if(rowMap.get(str) == N){//// need to know why!!!
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == 'B' && colCount[i] == N){
                        count += N;
                    }
                }
            }
        }
        
        
        return count;
    }
    public String rowFinder(int N, char[][] picture, int r, int[] colCount){
        String rowN ="";
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int c = 0; c < colCount.length; c++){
            if(picture[r][c] == 'B'){
                rowCount++;
                colCount[c]++;
            }
            sb.append(picture[r][c]);
        }
        
        if(rowCount == N){ rowN = sb.toString();}
        return rowN;

    }
    
}
