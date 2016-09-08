public class Solution {
    /**
    * @param neighbours Graph Map<word, list of All the elem that only change one char>
    * @param distance Unique Map<word, distance from the beginWord>
    * @param trail of shorttest path List<words>
    * @bfs(start, end, dict, neighbors, distance) - build up the neighbours map 
    * @getNeighbours() - get all the elements that only change one char (part of bfs)
    * @dfs(start, end, dict, neighbors, distance, path, result) - backtracking to record the shortest path based on distance map and iteration of neighours map
    * 
    * main()-   add start and end word into dict, start bfs and dfs
    * bfs() -   push all the words in dict into neighbours map
    *           setup the start point - queue.offer(start), distance.put(start, 0)
    *           sign of foundEnd 
    *           get current distance for praparing addup
    *           get all the list of current neighbours
    *           iterate the neighbours
    *               add into neighbours map
    *               distance map only record the key neighbour is not exsited and addup the distance based on                   the current distace
    *               if foundEnd => update true- will end after the loop
    *               else offer the neighbour into queue
    *           after the iteration, if found end then break;
    * dfs() -   setup begin point path.add(currstart)
    *           setup end point endWord.equals(curstart) => add into list
    *           iteration of neighbours map for each curstart
    *               if currstart distance +1 = distance map.get(currstart)
    *                   dfs()
    *           remove(size-1)
    **/
    
    public Map<String, List<String>> neighbours;
    public Map<String, Integer> distance;
    public List<String> path;
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result =  new ArrayList<>();
        if(wordList.size() == 0) return result;
        wordList.add(beginWord);
        wordList.add(endWord);
        
        neighbours = new HashMap<>();
        distance = new HashMap<>();
        path = new ArrayList<>();
        
        bfs(neighbours, distance, beginWord, endWord, wordList);//build up neighbours map, distance map -> Graph
        dfs(neighbours, distance, beginWord, endWord, wordList, result, path);//record the shortest path based on Graph
        
        return result;
        
    }
    
    public void dfs(Map<String, List<String>> neighbours, Map<String, Integer> distance, 
                    String currbeginWord, String endWord, Set<String> wordList, List<List<String>> result,List<String> path){
        path.add(currbeginWord);
        if(endWord.equals(currbeginWord)){
            result.add(new ArrayList<>(path));
            return;
        }else{
            for(String currNeigh : neighbours.get(currbeginWord)){
                if(distance.get(currNeigh) == distance.get(currbeginWord) +1){
                   dfs(neighbours, distance, currNeigh, endWord, wordList, result, path); 
                }
            }
        }
        path.remove(path.size()-1);
    }
    
    public void bfs(Map<String, List<String>> neighbours, Map<String, Integer> distance, 
                    String beginWord, String endWord, Set<String> wordList){
        for(String w : wordList){
            neighbours.put(w, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean foundEnd = false;
            for(int i = 0 ; i < size; i++){
                String strWord = queue.poll();
                int currDist = distance.get(strWord);
                ArrayList<String> listcurrNeighbour = getNeighbours(strWord, wordList); 
                
                for(String neighbour : listcurrNeighbour){
                    neighbours.get(strWord).add(neighbour);
                    if(!distance.containsKey(neighbour)){
                        distance.put(neighbour, currDist+1);
                    }
                    
                    if(endWord.equals(neighbour)){
                        foundEnd = true;
                    }else{
                        queue.offer(neighbour);
                    }
                }
            }
            if(foundEnd){
                break;
            }
            
        }
    }
    
    public ArrayList<String> getNeighbours(String strWord, Set<String> wordList){
        ArrayList<String> tempList = new ArrayList<>();
        for(int i = 0; i < strWord.length(); i++){
            char[] chArrystrWord = strWord.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                chArrystrWord[i] = ch;
                String strWordKey = String.valueOf(chArrystrWord);
                if(wordList.contains(strWordKey)){
                    tempList.add(strWordKey);
                }
            }
            
        }
        
        return tempList;
    }
}
