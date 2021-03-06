public class Solution {
    /**
    * Basically I keep two sets of words, one set reached that represents the borders that have been reached with "distance" steps; 
    another set wordDict that has not been reached. 
    In the while loop, for each word in the reached set, I give all variations and check if it matches anything from wordDict, 
    if it has a match, I add that word into toAdd set, which will be my "reached" set in the next loop, 
    and remove the word from wordDict because I already reached it in this step. 
    And at the end of while loop, I check the size of toAdd, 
    which means that if I can't reach any new String from wordDict, I won't be able to reach the endWord, 
    then just return 0. Finally if the endWord is in reached set, I return the current steps "distance".

    The idea is that reached always contain only the ones we just reached in the last step, 
    and wordDict always contain the ones that haven't been reached. 
    This is pretty much what Dijkstra's algorithm does, or you can see this as some variation of BFS.

    ps: I get TLE at the first two submissions, because when I check if wordDict has any matches with reached set, 
    I use two for loops and determine if any pair of words differ by one. 
    That's a huge slow-down because it'll takes m (size of reached) * n (size of wordDict) * l (length of words) time, 
    while in this solution, it takes 26 * l * m time. So when n is huge, this solution will be (n/26) times faster.
    **/
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList.isEmpty()){
            return 0;
        }
        int counter = 1;
        Set<String> latestList = new HashSet<>();
        latestList.add(beginWord);
        wordList.add(endWord);
        
        while(!latestList.contains(endWord)){
            Set<String> currentList = new HashSet<>();
            for(String str : latestList){
                
                for(int i = 0; i < str.length(); i++){
                    char[] charArr= str.toCharArray();
                    
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        charArr[i] = ch;
                        String tempStr = String.valueOf(charArr);
                        if(wordList.contains(tempStr) && !tempStr.equals(str)){
                            currentList.add(tempStr);
                            wordList.remove(tempStr);
                        }
                    }
                }
            }
            
            if(currentList.size() == 0){return 0;}
            latestList = currentList;
            counter++;
            
        }
        
        return counter;
    }
    
    
}
