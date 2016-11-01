
public class Solution {
    /**
    * use the PQ as the temp storage to get lexical order arrivals
    * Map<departure, PQ<arrivals>>
    * dfs(departure) to get the path
    * path.add(0, departure)
    **/
    List<String> path = new LinkedList<>();
    Map<String, PriorityQueue<String>> flights = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        
        for(int i = 0; i < tickets.length; i++){
            if(!flights.containsKey(tickets[i][0])){
                flights.put(tickets[i][0], new PriorityQueue<>());
            }
            flights.get(tickets[i][0]).add(tickets[i][1]);
        }
        
        dfs("JFK");
        
        return path;
        
    }
    
    public void dfs(String departure){
        PriorityQueue<String> arrivals = flights.get(departure);
        
        while(arrivals != null && !arrivals.isEmpty()){
            dfs(arrivals.poll());
        }
        path.add(0,departure);
    }
}
