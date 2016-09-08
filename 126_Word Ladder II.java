public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> neighbors = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        ArrayList<String> path = new ArrayList<String>();

        dict.add(start);
        dict.add(end);

        bfs(start, end, dict, neighbors, distance);
        dfs(start, end, dict, neighbors, distance, path, res);
        return res;
    }


    /**
     * 设置字符串的相邻字符串列表及每个字符串到开始节点的距离(即给neighbors、distance赋值)
     */
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> neighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            neighbors.put(str, new ArrayList<String>());
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> curNeighbors = getNeighbors(cur, dict);

                for (String neighbor : curNeighbors) {
                    neighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            //循环退出条件,当找到end的时候,就没有必要继续循环了,因为题目要求的是最短路径
            if (foundEnd)
                break;
        }
    }

    /**
     * 查找字符串的相邻字符串列表(即字符串只更改一个字符之后得到的而且包含在字典表中的字符串)
     */
    private ArrayList<String> getNeighbors(String str, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char arr[] = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            for(char c='a';c<='z';c++){
                if(arr[i]==c) continue;
                char tmp=arr[i];
                arr[i]=c;
                if(dict.contains(String.valueOf(arr))) res.add(String.valueOf(arr));
                arr[i]=tmp;
            }
        }
        return res;
    }

    /**
     * 统计路径
     */
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> neighbors, HashMap<String, Integer> distance, ArrayList<String> path, List<List<String>> res) {

        path.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(path));
        }else {
            for (String next : neighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, neighbors, distance, path, res);
                }
            }
        }
        //当回退的时候需要从path中删除相关节点
        path.remove(path.size() - 1);
    }
}
