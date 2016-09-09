
/**
* DS: Map<val, index in the list> random can not be done in O(1)
* so need a ArrayList<val> to getRandom
* insert() check val is in hashmap or not
* remove()  hashmap.remove is O(1), list is not, get tempindex = indexMap.remove(val); and last elem in the list
*           so if val != last, swap the one that need to be removed to the tail, 
*           and consider update the index in map
*           then remove the tail in the list
* getRandom() random.nextInt(index of map), return list.get(index)
**/
public class RandomizedSet {
    public Map<Integer, Integer> indexMap;
    public ArrayList<Integer> indexList;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        indexMap = new HashMap<>();
        indexList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }else{
            indexList.add(val);
            indexMap.put(val, indexList.size()-1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }else{
            int tempindex = indexMap.remove(val);
            int oldLast = indexList.get(indexList.size()-1);
            if(val != oldLast){
                indexList.set(tempindex, oldLast);
                indexMap.put(oldLast, tempindex);
            }
            indexList.remove(indexList.size()-1);
            return true;
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(indexList.size());
        return indexList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
