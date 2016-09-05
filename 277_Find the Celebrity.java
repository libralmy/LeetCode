/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/**
* @param n number of people 
* @return the index fo celebreity
* 
* candidate = 0, i = 1
* iterate first time, to find knows(candidate, i)
* 
* iterate second time, to find 
*   j<candidate, verify everyone knows it, and it doesnt know anyone
*   j>candidate, verify it knows no one
* 
**/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)){
                candidate = i;
            }
        }
        for(int j = 0; j < n ; j++){
            if(j != candidate && (!knows(j, candidate) || knows(candidate, j))){ return -1;}
        }
        
        return candidate;
        
    }
}
