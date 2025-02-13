/** https://leetcode.com/problems/network-delay-time/
 */

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = -1;
        int INT_MAX = 6000 * 100 + 1;

        int[] visited = new int[n + 1];
        Arrays.fill(visited, INT_MAX);

        Stack<Tuple> stack = new Stack<>();
        HashMap<Integer, ArrayList<Tuple>> map = new HashMap<>();

        for (int[] time : times) {
            int start = time[0];
            ArrayList<Tuple> list = null;

            if (map.containsKey(start)) {
                list = map.get(start);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(new Tuple(time[1], time[2]));
            map.put(start, list);
        }

        stack.push(new Tuple(k, 0));

        while(!stack.isEmpty()) {
            Tuple cur = stack.pop();
            
            ArrayList<Tuple> nextList = map.get(cur.end);
            if (nextList == null) {
                continue;
            }

            for (Tuple next : nextList) {
                int timeSum = cur.time + next.time;
                if (visited[next.end] > timeSum) {
                    visited[next.end] = timeSum;
                    stack.push(new Tuple(next.end, timeSum));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == k) {
                continue;
            }
            if (visited[i] == INT_MAX) {
                return -1;
            }
            result = result > visited[i] ? result : visited[i];
        }

        return result;
    }
}

class Tuple {
    int end;
    int time;

    public Tuple(int end, int time) {
        this.end = end;
        this.time = time;
    }

}