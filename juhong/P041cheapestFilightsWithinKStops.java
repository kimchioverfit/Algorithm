/** https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int MAXVALUE = Integer.MAX_VALUE;

        HashMap<Integer, ArrayList<Tuple>> map = new HashMap<>();
        int[] visited = new int[n];
        Arrays.fill(visited, MAXVALUE);

        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];

            ArrayList<Tuple> list = null;
            if (map.containsKey(start)) {
                list = map.get(start);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(new Tuple(end, cost));
            map.put(start, list);
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src, 0, 0));

        while (!queue.isEmpty()) {
            Tuple cur = queue.remove();
            if (cur.stop > k) {
                continue;
            }

            ArrayList<Tuple> nextList = map.get(cur.end);
            if (nextList != null) {
                for (Tuple next : nextList) {
                    if (visited[next.end] > next.cost + cur.cost) {
                        visited[next.end] = next.cost + cur.cost;
                        queue.add(new Tuple(next.end, next.cost + cur.cost, cur.stop + 1));
                    }
                }
            }
        }

        return visited[dst] == MAXVALUE ? -1 : visited[dst];
    }
}

class Tuple {
    int end;
    int cost;
    int stop;

    public Tuple(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    public Tuple(int end, int cost, int stop) {
        this.end = end;
        this.cost = cost;
        this.stop = stop;
    }

}