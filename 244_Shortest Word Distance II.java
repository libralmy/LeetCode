
    public class WordDistance {
        /**
         * @class WordDistance
         * @param word is a sring array that contains all the word dict
         * @param word1 and word2 are the given two words
         * @return the shortest distance between two words
         *
         * WordDistance constructor: need to all words in the map<word, list index of this word>
         *
         * shortest() 
         * get two index list from pulling up map
         * set up two counter for those two list
         * iterate all the index in two lists
         * dist = min(dist, list1.get(counter1)-list2.get(counter2))
         * index1 < index2 counter1++: counter2++
         *
         * **/
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words){
            for(int i = 0; i< words.length; i++){
                if(!map.containsKey(words[i])){
                    map.put(words[i], new ArrayList<>());
                }
                map.get(words[i]).add(i); ///different between the twosumMap<num, frequency>
            }
        }

        public int shortest(String word1, String word2){
            List<Integer> w1 = new ArrayList<>();
            List<Integer> w2 = new ArrayList<>();
            w1 = map.get(word1);
            w2 = map.get(word2);
            int count1 = 0, count2 = 0;
            int dist  = Integer.MAX_VALUE;
            while(count1 < w1.size() && count2 < w2.size()){
                int d1 = w1.get(count1);
                int d2 = w2.get(count2);
                dist = Math.min(dist, Math.abs(d1 - d2));
                if(d1 < d2){
                    count1++;
                }else{
                    count2++;
                }
                
            }
            return dist;
        }

    }
// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
