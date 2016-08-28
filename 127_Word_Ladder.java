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
