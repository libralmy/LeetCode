    /**
     * push  the endword to wordlist
     * use queue to store the word that needs to be checked, first loop size of queue, if poll() == end word, return count +1
     * get the word 
     * change to char array IN the iteration of string elements
     * change every element and check if it is exsited in the wordlist, then count++, and remove it from wordlist
     **/

public class Solution {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList.isEmpty()){ return 0;}
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 0 ;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                String temp = queue.poll();
                if(temp.equals(endWord)){ return count + 1;}
                
                for (int i = 0; i < temp.length(); i++) {
                    char[] charStr = temp.toCharArray();
                    for (char a = 'a'; a <= 'z'; a++) {
                        charStr[i] = a;
                        String tempStr = String.valueOf(charStr);
                        if (!tempStr.equals(temp) && wordList.contains(tempStr)) {
                            queue.add(tempStr);
                            wordList.remove(tempStr);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}


/**
use hashset reached.add(beginword) 
new set toAdd is the alll the word been searched,  wordDict is the non reached part
***/

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while(!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for(String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance ++;
            if(toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
