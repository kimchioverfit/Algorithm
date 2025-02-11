
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean[] visited = new boolean[numCourses];
        boolean[] traced = new boolean[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            ArrayList<Integer> list = null;
            if (map.containsKey(pre[0])) {
                list = map.get(pre[0]);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(pre[1]);
            map.put(pre[0], list);
        }

        for (int key : map.keySet()) {
            if (!dfs(key, visited, traced, map)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int i, boolean[] visited, boolean[] traced, HashMap<Integer, ArrayList<Integer>> map) {
        if (traced[i]) {
            return false;
        }
        if (visited[i]) {
            return true;
        }

        traced[i] = true;
        ArrayList<Integer> list = map.get(i);

        if (list != null) {
            for (int next : list) {
                if (!dfs(next, visited, traced, map)) {
                    return false;
                }
            }
        }
        traced[i] = false;
        visited[i] = true;
        return true;
    }
}