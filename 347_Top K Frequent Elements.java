
    /**
    * @param given int array
    * @param int k - top k elem
    * @return list of top k frequent elem in array
    * 
    * use Map<num, frequenct>
    * use PriorityQueue sort by map.getValue()
    * 
    * PQ comparator: PriorityQueue<Map.Entry<Integer, Integer>> m2, m1=> desending
    *         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>(){
                    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                        return Integer.compare(m2.getValue(), m1.getValue());
                    }
                }
            );
    *        PriorityQueue<Map.Entry<Integer, Integer>> pqueue =
                new PriorityQueue<>((e1,e2)-> e2.getValue() - e1.getValue()); //lambda expressions introduced in Java8
    * iterate int array, add all elem with frequent in map
    * PQ.addAll(map.entrySet());
    * for(i<k) result.add(PQ.poll().getKey())
    **/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(k == 0 || nums.length == 0){return result;}
        
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>(){
                    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                        return Integer.compare(m2.getValue(), m1.getValue());
                    }
                }
            );
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else{
                map.put(n, 1);
            }
        }
        pq.addAll(map.entrySet());
        for(int i = 0; i < k; i++){
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
