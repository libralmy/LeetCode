

public class Solution {

    /**
     * @param beginWord a string start to trace
     * @param endWord a string end the trace
     * @return the shortest distance between the two words
     *
     * add end word into wordlist
     * S1 BFS: count=0 use queue to be the temporary storage for the path of word tracking
     * S2 BFS: count=1(when reach endword, while stoped) use HashSet iterated and addin as the temporary storage for avoiding to check duplicates word in wordList
     *      if(currChecked.size() == 0) return 0; and put lastChecked = currChecked, len++
     * **/
     
     
     /**
     * push  the endword to wordlist
     * use queue to store the word that needs to be checked, first loop size of queue, if poll() == end word, return count +1
     * get the word 
     * change to char array IN the iteration of string elements
     * change every element and check if it is exsited in the wordlist, then count++, and remove it from wordlist
     **/
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList.isEmpty()){return 0;}

        Set<String> lastChecked = new HashSet<>();
        lastChecked.add(beginWord);
        wordList.add(endWord);
        int len = 1;

        while(!lastChecked.contains(endWord)){
            Set<String> currChecked = new HashSet<>();
            for(String tempStr : lastChecked){
                for(int i = 0; i < tempStr.length(); i++){
                    char[] tempStrCharArry = tempStr.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        tempStrCharArry[i] = ch;
                        String tempStrConvert = String.valueOf(tempStrCharArry);
                        if(wordList.contains(tempStrConvert)){
                            currChecked.add(tempStrConvert);
                            wordList.remove(tempStrConvert);
                        }
                    }
                }
            }

            if(currChecked.size() == 0) return 0;
            lastChecked = currChecked;
            len++;
        }
        return len;
    }
