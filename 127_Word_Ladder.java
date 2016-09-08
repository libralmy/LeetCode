

public class Solution {
    /**
    * BFS
    * add end word to the dict
    * push beginword to queue
    *   set return count+1 when current poll() = endword
    *   covert the word poll from queue to charArray and change every char,
    *   then check if it is in the dict and does not = current poll()
    *   if it is, add it into queue, remove form dict for avoding duplicate
    *   count++
    * return 0;
    **/
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
