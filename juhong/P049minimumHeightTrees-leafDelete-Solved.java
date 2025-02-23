class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        List<Integer>[] node = new List[n];
        Arrays.setAll(node, k -> new ArrayList<>());
        int[] degree = new int[n];

        for (int[] edge : edges) {
            node[edge[0]].add(edge[1]);
            degree[edge[0]] += 1;
            node[edge[1]].add(edge[0]);
            degree[edge[1]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            result.clear();
            for (int i = queue.size(); i > 0; i--) {
                int leaf = queue.poll();
                result.add(leaf);

                for (int other : node[leaf]) {
                    if (--degree[other] == 1) {
                        queue.offer(other);
                    }
                }
            }
        }
        return result;

    }
}