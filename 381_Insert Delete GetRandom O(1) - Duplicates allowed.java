/**
* indexList = new ArrayList<Integer>();
* randomMap = new HashMap<Integer, LinkedHashSet<Integer>>();
* //get current index
* int idx = randomMap.get(val).iterator().next();
* and then remove it from map
* idx < indexList.size() -1 
* swap the idx and last one, remove the last one from Map and list
* make sure the empty list get removed
* if (randomMap.get(val).isEmpty()) randomMap.remove(val);
**/
public class RandomizedCollection {
    public Map<Integer, Set<Integer>> map;
    public List<Integer> indexList;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        indexList = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            indexList.add(val);
            map.get(val).add(indexList.size()-1);
            return false;
        }else{
            indexList.add(val);
            map.put(val,new LinkedHashSet<>());
            map.get(val).add(indexList.size()-1);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int tempIdx = map.get(val).iterator().next();
            map.get(val).remove(tempIdx);
            
            if(tempIdx < indexList.size()-1){
                int last = indexList.get(indexList.size()-1);
                indexList.set(tempIdx, last);
                map.get(last).remove(indexList.size()-1);
                map.get(last).add(tempIdx);
            }
            
            indexList.remove(indexList.size()-1);
            if(map.get(val).isEmpty()){ map.remove(val);}
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r = new Random();
        int idx = r.nextInt(indexList.size());
        return indexList.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
