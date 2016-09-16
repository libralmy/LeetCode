
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edges
while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S
if graph has edges then
    return error (graph has at least one cycle)
else 
    return L (a topologically sorted order)
    
    public class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        int[] visited = new int[numCourses];
        
        //courses that would have the dependency graph
        List<List<Integer>> courses = new ArrayList<List<Integer>>();
        
        for(int i=0;i<numCourses;i++){
            courses.add(new ArrayList<Integer>());
        }
        
        //add dependencies
        for(int i=0;i< prereq.length;i++){
            // for a course, add all the courses that are dependent on it
            courses.get(prereq[i][1]).add(prereq[i][0]);
        }
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(!dfs(i,courses,visited)) return false;
            }
        }
        return true;

    }
    
    public boolean dfs(int i,List<List<Integer>> courses, int[]visited){
        visited[i] = 1;
        
        // these are all the courses which are eligible
        //when we take their prerequisite, which is course i
        List<Integer> eligibleCourses = courses.get(i);
        
        for(int j=0;j<eligibleCourses.size();j++){
            int eligibleCourse = eligibleCourses.get(j);
            //it is already visited, during previous dfs call, so its a cycle 
            if(visited[eligibleCourse] == 1) return false;
            if(visited[eligibleCourse] == 2) continue;
               if(!dfs(eligibleCourse,courses,visited)){
                    return false;
                } 
        }
        
        //it is totally complete and no cycle found in its depth first traversal
        visited[i] = 2;
        return true;
        
        
    }
}
