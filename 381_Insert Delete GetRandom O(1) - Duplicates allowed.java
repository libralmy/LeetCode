/**
* indexList = new ArrayList<Integer>();
* randomMap = new HashMap<Integer, LinkedHashSet<Integer>>();
* //get current index
* int idx = randomMap.get(val).iterator().next();
* and then remove it from map
* idx < indexList.size() -1 
* swap the idx and last one, remove the last one
* make sure the empty list get removed
* if (randomMap.get(val).isEmpty()) randomMap.remove(val);
**/
public class RandomizedCollection {
    ArrayList<Integer> nums;
	HashMap<Integer, Set<Integer>> locs;
	java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
	    locs = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
	    if ( ! contain ) locs.put( val, new LinkedHashSet<Integer>() ); 
	    locs.get(val).add(nums.size());        
	    nums.add(val);
	    return ! contain ;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
	    if ( ! contain ) return false;
	    int loc = locs.get(val).iterator().next();
	    locs.get(val).remove(loc);
	    if (loc < nums.size() - 1 ) {
	       int lastone = nums.get( nums.size()-1 );
	       nums.set( loc , lastone );
	       locs.get(lastone).remove( nums.size()-1);
	       locs.get(lastone).add(loc);
	    }
	    nums.remove(nums.size() - 1);
	   
	    if (locs.get(val).isEmpty()) locs.remove(val);
	    return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class RandomizedCollection {
    ArrayList<Integer> indexList;
	HashMap<Integer, Set<Integer>> randomMap;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        indexList = new ArrayList<Integer>();
	    randomMap = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

	    if (randomMap.containsKey(val)){
	        randomMap.get(val).add(indexList.size()); 
	        return false;
	    }else{
	        randomMap.put(val,new LinkedHashSet<Integer>()); 
	        randomMap.get(val).add(indexList.size());        
	        indexList.add(val);
	        return true;
	    }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
	    if (!randomMap.containsKey(val)){ 
	        return false;
	        
	    }
	        int idx = randomMap.get(val).iterator().next();
	        randomMap.get(val).remove(idx);
	        
	        
	        if (idx < indexList.size() - 1 ) {
	            int lastone = indexList.get( indexList.size()-1 );
	            indexList.set( idx , lastone );
	            randomMap.get(lastone).remove( indexList.size()-1);
	            randomMap.get(lastone).add(idx);
	        }
	        indexList.remove(indexList.size() - 1);
	        if (randomMap.get(val).isEmpty()) randomMap.remove(val);
	       
	        return true;
	    
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r = new Random();
        int ridx = 0;
        if(!indexList.isEmpty()){
            return indexList.get(r.nextInt(indexList.size()));
        }
        return ridx;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
