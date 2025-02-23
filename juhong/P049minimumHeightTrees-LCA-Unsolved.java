class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();

        int[][] parent = new int[n][21];
        int[] depth = new int[n];

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());		
        }
        
        for (int[] edge : edges) {
            ArrayList<Integer> temp = null;
            temp = list.get(edge[0]);
            temp.add(edge[1]);
            list.set(edge[0], temp);

            temp = list.get(edge[1]);
            temp.add(edge[0]);
            list.set(edge[1], temp);
        }

        DFS(0, 1, -1, list, depth, parent);

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j < n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
        
        int minDepth = Integer.MAX_VALUE;
        int[] depthList = new int[n];

        for (int i = 0; i < n; i++) {

            int iDepth = 0;
            for (int j = i + 1; j < n; j++) {
                int jDepth = depth[i] + depth[j];
                if (jDepth <= depthList[j] && jDepth <= iDepth) {
                    continue;
                }
                int commonParent = LCA(i, j, depth, parent);

                jDepth -= 2 * depth[commonParent];
                if (jDepth > depthList[j]) {
                    depthList[j] = jDepth;
                }
                if (jDepth > iDepth) {
                    iDepth = jDepth;
                }
            }
            depthList[i] = depthList[i] > iDepth ? depthList[i] : iDepth;

            if (depthList[i] < minDepth) {
                minDepth = depthList[i];
            }
         }

         for (int i = 0; i < n; i++) {
            if (depthList[i] == minDepth) {
                result.add(i);
            }
         }

        return result;

    }

    public void DFS(int curNode, int curDepth, int parentNode, ArrayList<ArrayList<Integer>> list, int[] depth, int[][] parent) {
        depth[curNode] = curDepth;
        for (int nextNode : list.get(curNode)) {
            if (nextNode != parentNode) {
                parent[nextNode][0] = curNode;
                DFS(nextNode, curDepth + 1, curNode, list, depth, parent);
            }
        }
    }

    public int LCA(int a, int b, int[] depth, int[][] parent) {
        int aDepth = depth[a];
        int bDepth = depth[b];

        if (aDepth < bDepth) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = 20; i >= 0; i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                a = parent[a][i];
            }
        }
        if (a == b) return a;

        for (int i = 20; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

}

class Tuple {
    int depth;
    int node;

    public Tuple(int depth, int node) {
        this.depth = depth;
        this.node = node;
    }
}
